package com.costech.service.system.user.impl

import com.costech.dao.DaoSupport
import com.costech.entity.Page
import com.costech.entity.system.User
import com.costech.service.system.user.UserService
import com.costech.util.PageData
import org.springframework.stereotype.Service

import javax.annotation.Resource

/**
 * @ClassName: UserServiceImpl
 * @description: 用户接口实现类
 * @author: yangy
 * @create: 2018-09-17 18:08
 * */
@Service("userService")
class UserServiceImpl implements UserService {

    @Resource(name = "daoSupport")
    private DaoSupport dao

    /**登录判断
     * @param pd
     * @return
     * @throws Exception
     */
    PageData getUserByNameAndPwd(PageData pd)throws Exception{
        return (PageData)dao.findForObject("UserMapper.getUserInfo", pd)
    }

    /**更新登录时间
     * @param pd
     * @throws Exception
     */
    void updateLastLogin(PageData pd)throws Exception{
        dao.update("UserMapper.updateLastLogin", pd)
    }

    /**保存用户皮肤
     * @param pd
     * @throws Exception
     */
    void saveSkin(PageData pd)throws Exception{
        dao.update("UserMapper.saveSkin", pd)
    }

    /**通过用户ID获取用户信息和角色信息
     * @param USER_ID
     * @return
     * @throws Exception
     */
    User getUserAndRoleById(String USER_ID) throws Exception {
        return (User) dao.findForObject("UserMapper.getUserAndRoleById", USER_ID)
    }

    /**通过USERNAEME获取数据
     * @param pd
     * @return
     * @throws Exception
     */
    PageData findByUsername(PageData pd)throws Exception{
        return (PageData)dao.findForObject("UserMapper.findByUsername", pd)
    }

    /**列出某角色下的所有用户
     * @param pd
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    List<PageData> listAllUserByRoldId(PageData pd) throws Exception {
        return (List<PageData>) dao.findForList("UserMapper.listAllUserByRoldId", pd)
    }

    /**保存用户IP
     * @param pd
     * @throws Exception
     */
    void saveIP(PageData pd)throws Exception{
        dao.update("UserMapper.saveIP", pd)
    }

    /**用户列表
     * @param page
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    List<PageData> listUsers(Page page)throws Exception{
        return (List<PageData>) dao.findForList("UserMapper.userlistPage", page)
    }

    /**用户列表(弹窗选择用)
     * @param page
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    List<PageData> listUsersBystaff(Page page)throws Exception{
        return (List<PageData>) dao.findForList("UserMapper.userBystafflistPage", page)
    }

    /**通过邮箱获取数据
     * @param pd
     * @return
     * @throws Exception
     */
    PageData findByUE(PageData pd)throws Exception{
        return (PageData)dao.findForObject("UserMapper.findByUE", pd)
    }

    /**通过编号获取数据
     * @param pd
     * @return
     * @throws Exception
     */
    PageData findByUN(PageData pd)throws Exception{
        return (PageData)dao.findForObject("UserMapper.findByUN", pd)
    }

    /**通过id获取数据
     * @param pd
     * @return
     * @throws Exception
     */
    PageData findById(PageData pd)throws Exception{
        return (PageData)dao.findForObject("UserMapper.findById", pd)
    }

    /**保存用户
     * @param pd
     * @throws Exception
     */
    void saveU(PageData pd)throws Exception{
        dao.save("UserMapper.saveU", pd)
    }

    /**修改用户
     * @param pd
     * @throws Exception
     */
    void editU(PageData pd)throws Exception{
        dao.update("UserMapper.editU", pd)
    }

    /**删除用户
     * @param pd
     * @throws Exception
     */
    void deleteU(PageData pd)throws Exception{
        dao.delete("UserMapper.deleteU", pd)
    }

    /**批量删除用户
     * @param USER_IDS
     * @throws Exception
     */
    void deleteAllU(String[] USER_IDS)throws Exception{
        dao.delete("UserMapper.deleteAllU", USER_IDS)
    }

    /**用户列表(全部)
     * @param USER_IDS
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    List<PageData> listAllUser(PageData pd)throws Exception{
        return (List<PageData>) dao.findForList("UserMapper.listAllUser", pd)
    }

    /**获取总数
     * @param pd
     * @throws Exception
     */
    PageData getUserCount(String value)throws Exception{
        return (PageData)dao.findForObject("UserMapper.getUserCount", value)
    }

}
