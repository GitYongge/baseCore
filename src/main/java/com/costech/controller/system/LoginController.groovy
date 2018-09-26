package com.costech.controller.system

import com.costech.controller.base.BaseController
import com.costech.entity.system.User
import com.costech.service.system.log.LogService
import com.costech.service.system.loginimg.LoginImgService
import com.costech.service.system.user.UserService
import com.costech.util.*
import org.apache.shiro.SecurityUtils
import org.apache.shiro.authc.AuthenticationException
import org.apache.shiro.authc.UsernamePasswordToken
import org.apache.shiro.crypto.hash.SimpleHash
import org.apache.shiro.session.Session
import org.apache.shiro.subject.Subject
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.servlet.ModelAndView

import javax.annotation.Resource

/**
 * @ClassName: LoginController
 * @description: 登录总入口
 * @author: yangy
 * @create: 2018-09-17 11:00
 * */
@Controller
class LoginController extends BaseController {

    @Resource(name="loginImgService")
    private LoginImgService loginImgService
    @Resource(name="userService")
    private UserService userService
    @Resource(name="logService")
    private LogService logService

    @RequestMapping(value = "/login_toLogin")
    ModelAndView toLogin() throws Exception {
        ModelAndView mv = this.getModelAndView()
        PageData pd = this.getPageData()
        pd = this.setLoginPd(pd)    //设置登录页面的配置参数
        mv.setViewName("system/index/login")
        mv.addObject("pd", pd)
        return mv
    }

    /**设置登录页面的配置参数
     * @param pd
     * @return
     */
    PageData setLoginPd(PageData pd){
        pd.put("SYSNAME", Tools.readTxtFile(Const.SYSNAME))		//读取系统名称
        String strLOGINEDIT = Tools.readTxtFile(Const.LOGINEDIT)	//读取登录页面配置
        if(strLOGINEDIT){
            String [] strLo = strLOGINEDIT.split(";")
            if(strLo.length == 2){
                pd.put("isZhuce", strLo[0])
                pd.put("isMusic", strLo[1])
            }
        }
        try {
            List<PageData> listImg = loginImgService.listAll(pd)	//登录背景图片
            pd.put("listImg", listImg)
        } catch (Exception e) {
            e.printStackTrace()
        }
        return pd
    }

    /**请求登录，验证用户
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/login_login" ,produces="application/json;charset=UTF-8")
    @ResponseBody
    Object login()throws Exception{
        Map<String,String> map = new HashMap<String,String>()
        PageData pd = this.getPageData()
        String errInfo
        String [] KEYDATA = pd.getString("KEYDATA").replaceAll("c2o0s1c7o", "").replaceAll("c2o0s1c8o", "").split(",costech,")
        if(null != KEYDATA && KEYDATA.length == 3){
            Session session = Jurisdiction.getSession()
            String sessionCode = (String)session.getAttribute(Const.SESSION_SECURITY_CODE)		//获取session中的验证码
            String code = KEYDATA[2]
            if(null == code || "".equals(code)){//判断效验码
                errInfo = "nullcode" 			//效验码为空
            }else{
                String USERNAME = KEYDATA[0]	//登录过来的用户名
                String PASSWORD  = KEYDATA[1]	//登录过来的密码
                pd.put("USERNAME", USERNAME)
                if(Tools.notEmpty(sessionCode) && sessionCode.equalsIgnoreCase(code)){		//判断登录验证码
                    String passwd = new SimpleHash("SHA-1", USERNAME, PASSWORD).toString()	//密码加密
                    pd.put("PASSWORD", passwd)
                    pd = userService.getUserByNameAndPwd(pd)	//根据用户名和密码去读取用户信息
                    if(pd != null){
                        this.removeSession(USERNAME)//请缓存
                        pd.put("LAST_LOGIN",DateUtil.getTime().toString())
                        userService.updateLastLogin(pd)
                        User user = new User()
                        user.USER_ID = pd.getString("USER_ID")
                        user.USERNAME = pd.getString("USERNAME")
                        user.PASSWORD = pd.getString("PASSWORD")
                        user.NAME = pd.getString("NAME")
                        user.RIGHTS = pd.getString("RIGHTS")
                        user.ROLE_ID = pd.getString("ROLE_ID")
                        user.LAST_LOGIN = pd.getString("LAST_LOGIN")
                        user.IP = pd.getString("IP")
                        user.STATUS = pd.getString("STATUS")
                        session.setAttribute(Const.SESSION_USER, user)		//把用户信息放session中
                        session.removeAttribute(Const.SESSION_SECURITY_CODE)	//清除登录验证码的session
                        //shiro加入身份验证
                        Subject subject = SecurityUtils.getSubject()
                        UsernamePasswordToken token = new UsernamePasswordToken(USERNAME, PASSWORD)
                        try {
                            subject.login(token)
                        } catch (AuthenticationException e) {
                            errInfo = "身份验证失败！"
                        }
                    }else{
                        errInfo = "usererror" 				//用户名或密码有误
                        logBefore(logger, USERNAME+"登录系统密码或用户名错误")
                        logService.save(USERNAME, "登录系统密码或用户名错误")
                    }
                }else{
                    errInfo = "codeerror"				 	//验证码输入有误
                }
                if(Tools.isEmpty(errInfo)){
                    errInfo = "success"					//验证成功
                    logBefore(logger, USERNAME+"登录系统")
                    logService.save(USERNAME, "登录系统")
                }
            }
        }else{
            errInfo = "error"	//缺少参数
        }
        map.put("result", errInfo)
        return AppUtil.returnObject(new PageData(), map)
    }

    /**
     * 清理session
     */
    void removeSession(String USERNAME){
        Session session = Jurisdiction.getSession()	//以下清除session缓存
        session.removeAttribute(Const.SESSION_USER)
        session.removeAttribute(USERNAME + Const.SESSION_ROLE_RIGHTS)
        session.removeAttribute(USERNAME + Const.SESSION_allmenuList)
        session.removeAttribute(USERNAME + Const.SESSION_menuList)
        session.removeAttribute(USERNAME + Const.SESSION_QX)
        session.removeAttribute(USERNAME + Const.SESSION_QX2)
        session.removeAttribute(Const.SESSION_userpds)
        session.removeAttribute(Const.SESSION_USERNAME)
        session.removeAttribute(Const.SESSION_U_NAME)
        session.removeAttribute(Const.SESSION_USERROL)
        session.removeAttribute(Const.SESSION_RNUMBERS)
        session.removeAttribute("changeMenu")
        session.removeAttribute("DEPARTMENT_IDS")
        session.removeAttribute("DEPARTMENT_ID")
    }

}
