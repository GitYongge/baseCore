package com.costech.service.im.hismsg.impl

import com.costech.dao.DaoSupport
import com.costech.entity.Page
import com.costech.service.im.hismsg.HismsgService
import com.costech.util.PageData
import org.springframework.stereotype.Service

import javax.annotation.Resource

/**
 * @ClassName: HismsgServiceImpl
 * @description: ${description}
 * @author: yangy
 * @create: 2018-09-17 13:51
 * */

@Service("hismsgService")
class HismsgServiceImpl implements HismsgService {

    @Resource(name = "daoSupport")
    private DaoSupport dao

    /**新增
     * @param pd
     * @throws Exception
     */
    void save(PageData pd)throws Exception{
        dao.save("HismsgMapper.save", pd)
    }

    /**删除
     * @param pd
     * @throws Exception
     */
    void delete(PageData pd)throws Exception{
        dao.delete("HismsgMapper.delete", pd)
    }

    /**修改
     * @param pd
     * @throws Exception
     */
    void edit(PageData pd)throws Exception{
        dao.update("HismsgMapper.edit", pd)
    }

    /**列表
     * @param page
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    List<PageData> list(Page page)throws Exception{
        return (List<PageData>)dao.findForList("HismsgMapper.datalistPage", page)
    }

    /**列表(全部全部未读消息)
     * @param pd
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    List<PageData> listAllnoread(PageData pd)throws Exception{
        return (List<PageData>)dao.findForList("HismsgMapper.listAllnoread", pd)
    }

    /**列表(全部)
     * @param pd
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    List<PageData> listAll(PageData pd)throws Exception{
        return (List<PageData>)dao.findForList("HismsgMapper.listAll", pd)
    }

    /**通过id获取数据
     * @param pd
     * @throws Exception
     */
    PageData findById(PageData pd)throws Exception{
        return (PageData)dao.findForObject("HismsgMapper.findById", pd)
    }

    /**批量删除
     * @param ArrayDATA_IDS
     * @throws Exception
     */
    void deleteAll(String[] ArrayDATA_IDS)throws Exception{
        dao.delete("HismsgMapper.deleteAll", ArrayDATA_IDS)
    }
}
