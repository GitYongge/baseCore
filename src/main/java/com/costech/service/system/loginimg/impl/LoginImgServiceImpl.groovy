package com.costech.service.system.loginimg.impl

import com.costech.dao.DaoSupport
import com.costech.entity.Page
import com.costech.service.system.loginimg.LoginImgService
import com.costech.util.PageData
import org.springframework.stereotype.Service

import javax.annotation.Resource
/**
 * @ClassName: LoginImgServiceImpl
 * @description: 登录页面背景图片
 * @author: yangy
 * @create: 2018-09-17 11:13
 * */
@Service("loginImgService")
class LoginImgServiceImpl implements LoginImgService {

    @Resource(name = "daoSupport")
    private DaoSupport dao

    /**新增
     * @param pd
     * @throws Exception
     */
    void save(PageData pd)throws Exception{
        dao.save("LogInImgMapper.save", pd)
    }

    /**删除
     * @param pd
     * @throws Exception
     */
    void delete(PageData pd)throws Exception{
        dao.delete("LogInImgMapper.delete", pd)
    }

    /**修改
     * @param pd
     * @throws Exception
     */
    void edit(PageData pd)throws Exception{
        dao.update("LogInImgMapper.edit", pd)
    }

    /**列表
     * @param page
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    List<PageData> list(Page page)throws Exception{
        return (List<PageData>)dao.findForList("LogInImgMapper.datalistPage", page)
    }

    /**列表(全部)
     * @param pd
     * @throws Exception
     */
    List<PageData> listAll(PageData pd)throws Exception{
        return (List<PageData>)dao.findForList("LogInImgMapper.listAll", pd)
    }

    /**通过id获取数据
     * @param pd
     * @throws Exception
     */
    PageData findById(PageData pd)throws Exception{
        return (PageData)dao.findForObject("LogInImgMapper.findById", pd)
    }

    /**批量删除
     * @param ArrayDATA_IDS
     * @throws Exception
     */
    void deleteAll(String[] ArrayDATA_IDS)throws Exception{
        dao.delete("LogInImgMapper.deleteAll", ArrayDATA_IDS)
    }
}
