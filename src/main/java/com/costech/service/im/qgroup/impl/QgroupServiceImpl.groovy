package com.costech.service.im.qgroup.impl

import com.costech.dao.DaoSupport
import com.costech.entity.Page
import com.costech.service.im.qgroup.QgroupService
import com.costech.util.PageData
import org.springframework.stereotype.Service

import javax.annotation.Resource

/**
 * @ClassName: QgroupServiceImpl
 * @description: 群组
 * @author: yangy
 * @create: 2018-09-17 15:25
 * */
@Service("qgroupService")
class QgroupServiceImpl implements QgroupService{
    @Resource(name = "daoSupport")
    private DaoSupport dao

    /**新增
     * @param pd
     * @throws Exception
     */
    void save(PageData pd)throws Exception{
        dao.save("QgroupMapper.save", pd)
    }

    /**删除
     * @param pd
     * @throws Exception
     */
    void delete(PageData pd)throws Exception{
        dao.delete("QgroupMapper.delete", pd)
    }

    /**修改
     * @param pd
     * @throws Exception
     */
    void edit(PageData pd)throws Exception{
        dao.update("QgroupMapper.edit", pd)
    }

    /**列表
     * @param page
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    List<PageData> list(Page page)throws Exception{
        return (List<PageData>)dao.findForList("QgroupMapper.datalistPage", page)
    }

    /**列表(全部)
     * @param pd
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    List<PageData> listAll(PageData pd)throws Exception{
        return (List<PageData>)dao.findForList("QgroupMapper.listAll", pd)
    }

    /**群检索列表
     * @param pd
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    List<PageData> searchListAll(PageData pd)throws Exception{
        return (List<PageData>)dao.findForList("QgroupMapper.searchListAll", pd)
    }

    /**我在的全部群列表
     * @param pd
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    List<PageData> mylistAll(PageData pd)throws Exception{
        return (List<PageData>)dao.findForList("QgroupMapper.mylistAll", pd)
    }

    /**通过id获取数据
     * @param pd
     * @throws Exception
     */
    PageData findById(PageData pd)throws Exception{
        return (PageData)dao.findForObject("QgroupMapper.findById", pd)
    }

    /**删除图片
     * @param pd
     * @throws Exception
     */
    void delTp(PageData pd)throws Exception{
        dao.update("QgroupMapper.delTp", pd)
    }
}
