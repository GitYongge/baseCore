package com.costech.service.im.imstate.impl

import com.costech.dao.DaoSupport
import com.costech.entity.Page
import com.costech.service.im.imstate.ImstateService
import com.costech.util.PageData
import org.springframework.stereotype.Service

import javax.annotation.Resource

/**
 * @ClassName: ImstateServiceImpl
 * @description: ${description}
 * @author: yangy
 * @create: 2018-09-17 15:17
 * */
@Service("imstateService")
class ImstateServiceImpl implements ImstateService{

    @Resource(name = "daoSupport")
    private DaoSupport dao

    /**新增
     * @param pd
     * @throws Exception
     */
    void save(PageData pd)throws Exception{
        dao.save("ImstateMapper.save", pd)
    }

    /**删除
     * @param pd
     * @throws Exception
     */
    void delete(PageData pd)throws Exception{
        dao.delete("ImstateMapper.delete", pd)
    }

    /**修改在线状态
     * @param pd
     * @throws Exception
     */
    void editOnline(PageData pd)throws Exception{
        dao.update("ImstateMapper.editOnline", pd)
    }

    /**修改个性签名
     * @param pd
     * @throws Exception
     */
    void editAuto(PageData pd)throws Exception{
        dao.update("ImstateMapper.editAuto", pd)
    }

    /**修改皮肤
     * @param pd
     * @throws Exception
     */
    void editSign(PageData pd)throws Exception{
        dao.update("ImstateMapper.editSign", pd)
    }

    /**列表
     * @param page
     * @throws Exception
     */
    List<PageData> list(Page page)throws Exception{
        return (List<PageData>)dao.findForList("ImstateMapper.datalistPage", page)
    }

    /**列表(全部)
     * @param pd
     * @throws Exception
     */
    List<PageData> listAll(PageData pd)throws Exception{
        return (List<PageData>)dao.findForList("ImstateMapper.listAll", pd)
    }

    /**通过id获取数据
     * @param pd
     * @throws Exception
     */
    PageData findById(PageData pd)throws Exception{
        return (PageData)dao.findForObject("ImstateMapper.findById", pd)
    }

    /**通过用户名获取数据
     * @param pd
     * @throws Exception
     */
    PageData findByUsername(PageData pd)throws Exception{
        return (PageData)dao.findForObject("ImstateMapper.findByUsername", pd)
    }

    /**批量删除
     * @param ArrayDATA_IDS
     * @throws Exception
     */
    void deleteAll(String[] ArrayDATA_IDS)throws Exception{
        dao.delete("ImstateMapper.deleteAll", ArrayDATA_IDS)
    }
}
