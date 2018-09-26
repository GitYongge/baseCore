package com.costech.service.im.sysmsg

import com.costech.entity.Page
import com.costech.util.PageData

/**
 * @ClassName: SysmsgService
 * @description: IM系统消息接口
 * @author: yangy
 * @create: 2018-09-17 15:29
 * */
interface SysmsgService {
    /**新增
     * @param pd
     * @throws Exception
     */
    void save(PageData pd)throws Exception

    /**删除
     * @param pd
     * @throws Exception
     */
    void delete(PageData pd)throws Exception

    /**修改
     * @param pd
     * @throws Exception
     */
    void edit(PageData pd)throws Exception

    /**消息设置成已读
     * @param pd
     * @throws Exception
     */
    void read(PageData pd)throws Exception

    /**列表
     * @param page
     * @throws Exception
     */
    List<PageData> list(Page page)throws Exception

    /**列表(全部)
     * @param pd
     * @throws Exception
     */
    List<PageData> listAll(PageData pd)throws Exception

    /**通过id获取数据
     * @param pd
     * @throws Exception
     */
    PageData findById(PageData pd)throws Exception

    /**获取未读总数
     * @param pd
     * @throws Exception
     */
    PageData getMsgCount(PageData pd)throws Exception

    /**批量删除
     * @param ArrayDATA_IDS
     * @throws Exception
     */
    void deleteAll(String[] ArrayDATA_IDS)throws Exception
}