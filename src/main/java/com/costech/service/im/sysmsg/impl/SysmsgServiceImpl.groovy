package com.costech.service.im.sysmsg.impl

import com.costech.dao.DaoSupport
import com.costech.entity.Page
import com.costech.service.im.sysmsg.SysmsgService
import com.costech.util.PageData
import org.springframework.stereotype.Service

import javax.annotation.Resource

/**
 * @ClassName: SysmsgServiceImpl
 * @description: IM系统消息
 * @author: yangy
 * @create: 2018-09-17 15:30
 * */
@Service("sysmsgService")
class SysmsgServiceImpl implements SysmsgService {

    @Resource(name = "daoSupport")
    private DaoSupport dao


    /**新增
     * @param pd
     * @throws Exception
     */
    void save(PageData pd)throws Exception{
        dao.save("SysmsgMapper.save", pd)
    }

    /**删除
     * @param pd
     * @throws Exception
     */
    void delete(PageData pd)throws Exception{
        dao.delete("SysmsgMapper.delete", pd)
    }

    /**修改
     * @param pd
     * @throws Exception
     */
    void edit(PageData pd)throws Exception{
        dao.update("SysmsgMapper.edit", pd)
    }

    /**消息设置成已读
     * @param pd
     * @throws Exception
     */
    void read(PageData pd)throws Exception{
        dao.update("SysmsgMapper.read", pd)
    }

    /**列表
     * @param page
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    List<PageData> list(Page page)throws Exception{
        return (List<PageData>)dao.findForList("SysmsgMapper.datalistPage", page)
    }

    /**列表(全部)
     * @param pd
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    List<PageData> listAll(PageData pd)throws Exception{
        return (List<PageData>)dao.findForList("SysmsgMapper.listAll", pd)
    }

    /**通过id获取数据
     * @param pd
     * @throws Exception
     */
    PageData findById(PageData pd)throws Exception{
        return (PageData)dao.findForObject("SysmsgMapper.findById", pd)
    }

    /**获取未读总数
     * @param pd
     * @throws Exception
     */
    PageData getMsgCount(PageData pd)throws Exception{
        return (PageData)dao.findForObject("SysmsgMapper.getMsgCount", pd)
    }

    /**批量删除
     * @param ArrayDATA_IDS
     * @throws Exception
     */
    void deleteAll(String[] ArrayDATA_IDS)throws Exception{
        dao.delete("SysmsgMapper.deleteAll", ArrayDATA_IDS)
    }

}
