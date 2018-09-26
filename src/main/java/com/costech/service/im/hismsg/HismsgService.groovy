package com.costech.service.im.hismsg

import com.costech.entity.Page
import com.costech.util.PageData

/**
 * @ClassName: HismsgService
 * @description: 聊天记录接口
 * @author: yangy
 * @create: 2018-09-17 13:48
 * */
interface HismsgService {

    /**新增
     * @param pd
     * @throws Exception
     */
    void save(PageData pd) throws Exception

    /**删除
     * @param pd
     * @throws Exception
     */
    void delete(PageData pd) throws Exception

    /**修改
     * @param pd
     * @throws Exception
     */
    void edit(PageData pd) throws Exception

    /**列表
     * @param page
     * @throws Exception
     */
    List<PageData> list(Page page) throws Exception

    /**列表(全部全部未读消息)
     * @param pd
     * @throws Exception
     */
    List<PageData> listAllnoread(PageData pd) throws Exception

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