package com.costech.service.im.iqgroup.impl

import com.costech.dao.DaoSupport
import com.costech.entity.Page
import com.costech.service.im.iqgroup.IQgroupService
import com.costech.util.PageData
import org.springframework.stereotype.Service

import javax.annotation.Resource

/**
 * @ClassName: IQgroupServiceImpl
 * @description: 我在的群组
 * @author: yangy
 * @create: 2018-09-17 14:01
 * */

@Service("iqgroupService")
class IQgroupServiceImpl implements IQgroupService {

        @Resource(name = "daoSupport")
        private DaoSupport dao

        /**新增
         * @param pd
         * @throws Exception
         */
        void save(PageData pd)throws Exception{
            dao.save("IQgroupMapper.save", pd)
        }

        /**删除
         * @param pd
         * @throws Exception
         */
        void delete(PageData pd)throws Exception{
            dao.delete("IQgroupMapper.delete", pd)
        }

        /**修改
         * @param pd
         * @throws Exception
         */
        void edit(PageData pd)throws Exception{
            dao.update("IQgroupMapper.edit", pd)
        }

        /**列表
         * @param page
         * @throws Exception
         */
        @SuppressWarnings("unchecked")
        List<PageData> list(Page page)throws Exception{
            return (List<PageData>)dao.findForList("IQgroupMapper.datalistPage", page)
        }

        /**列表(全部群成员)带分页
         * @param page
         * @throws Exception
         */
        @SuppressWarnings("unchecked")
        List<PageData> memberslistPage(Page page)throws Exception{
            return (List<PageData>)dao.findForList("IQgroupMapper.memberslistPage", page)
        }

        /**列表(全部)
         * @param pd
         * @throws Exception
         */
        @SuppressWarnings("unchecked")
        List<PageData> listAll(PageData pd)throws Exception{
            return (List<PageData>)dao.findForList("IQgroupMapper.listAll", pd)
        }

        /**通过id获取数据
         * @param pd
         * @throws Exception
         */
        PageData findById(PageData pd)throws Exception{
            return (PageData)dao.findForObject("IQgroupMapper.findById", pd)
        }

        /**判断我是否在某群
         * @param pd
         * @throws Exception
         */
        PageData findByIdandQid(PageData pd)throws Exception{
            return (PageData)dao.findForObject("IQgroupMapper.findByIdandQid", pd)
        }

        /**批量删除
         * @param ArrayDATA_IDS
         * @throws Exception
         */
        void deleteAll(String[] ArrayDATA_IDS)throws Exception{
            dao.delete("IQgroupMapper.deleteAll", ArrayDATA_IDS)
        }
}
