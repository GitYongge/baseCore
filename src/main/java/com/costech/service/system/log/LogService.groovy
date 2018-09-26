package com.costech.service.system.log

import com.costech.entity.Page
import com.costech.util.PageData

/**
 * @ClassName: LogService
 * @description: 操作日志记录接口
 * @author: yangy
 * @create: 2018-09-17 18:13
 * */
interface LogService {

    /**新增
     * @param pd
     * @throws Exception
     */
    void save(String USERNAME, String CONTENT) throws Exception

    /**删除
     * @param pd
     * @throws Exception
     */
    void delete(PageData pd) throws Exception

    /**列表
     * @param page
     * @throws Exception
     */
    List<PageData> list(Page page) throws Exception

    /**列表(全部)
     * @param pd
     * @throws Exception
     */
    List<PageData> listAll(PageData pd) throws Exception

    /**通过id获取数据
     * @param pd
     * @throws Exception
     */
    PageData findById(PageData pd) throws Exception

    /**批量删除
     * @param ArrayDATA_IDS
     * @throws Exception
     */
    void deleteAll(String[] ArrayDATA_IDS) throws Exception

}
