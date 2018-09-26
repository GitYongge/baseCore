package com.costech.service.im.iqgroup

import com.costech.entity.Page
import com.costech.util.PageData

/**
 * @ClassName: IQgroupService
 * @description: 我在的群组接口
 * @author: yangy
 * @create: 2018-09-17 14:00
 * */
interface IQgroupService {

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

    /**列表
     * @param page
     * @throws Exception
     */
    List<PageData> list(Page page)throws Exception

    /**列表(全部群成员)带分页
     * @param page
     * @throws Exception
     */
    List<PageData> memberslistPage(Page page)throws Exception

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

    /**判断我是否在某群
     * @param pd
     * @throws Exception
     */
    PageData findByIdandQid(PageData pd)throws Exception

    /**批量删除
     * @param ArrayDATA_IDS
     * @throws Exception
     */
    void deleteAll(String[] ArrayDATA_IDS)throws Exception
}
