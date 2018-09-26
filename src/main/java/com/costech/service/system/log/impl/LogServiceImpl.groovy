package com.costech.service.system.log.impl

import com.costech.dao.DaoSupport
import com.costech.entity.Page
import com.costech.service.system.log.LogService
import com.costech.util.PageData
import com.costech.util.Tools
import com.costech.util.UuidUtil
import org.springframework.stereotype.Service

import javax.annotation.Resource

/**
 * @ClassName: LogServiceImpl
 * @description: 操作日志记录
 * @author: yangy
 * @create: 2018-09-17 18:14
 * */
@Service("logService")
class LogServiceImpl implements LogService {

    @Resource(name = "daoSupport")
    private DaoSupport dao

    /**新增
     * @param pd
     * @throws Exception
     */
    void save(String USERNAME, String CONTENT)throws Exception{
        PageData pd = new PageData()
        pd.put("USERNAME", USERNAME)				//用户名
        pd.put("CONTENT", CONTENT)						//事件
        pd.put("FHLOG_ID", UuidUtil.get32UUID())		//主键
        pd.put("CZTIME", Tools.date2Str(new Date()))	//操作时间
        dao.save("LogMapper.save", pd)
    }

    /**删除
     * @param pd
     * @throws Exception
     */
    void delete(PageData pd)throws Exception{
        dao.delete("LogMapper.delete", pd)
    }

    /**列表
     * @param page
     * @throws Exception
     */
    List<PageData> list(Page page)throws Exception{
        return (List<PageData>)dao.findForList("LogMapper.datalistPage", page)
    }

    /**列表(全部)
     * @param pd
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    List<PageData> listAll(PageData pd)throws Exception{
        return (List<PageData>)dao.findForList("LogMapper.listAll", pd)
    }

    /**通过id获取数据
     * @param pd
     * @throws Exception
     */
    PageData findById(PageData pd)throws Exception{
        return (PageData)dao.findForObject("LogMapper.findById", pd)
    }

    /**批量删除
     * @param ArrayDATA_IDS
     * @throws Exception
     */
    void deleteAll(String[] ArrayDATA_IDS)throws Exception{
        dao.delete("LogMapper.deleteAll", ArrayDATA_IDS)
    }

}
