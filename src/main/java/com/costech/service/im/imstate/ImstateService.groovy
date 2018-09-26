package com.costech.service.im.imstate

import com.costech.entity.Page
import com.costech.util.PageData

/**
 * @ClassName: ImstateService
 * @description: ${description}
 * @author: yangy
 * @create: 2018-09-17 15:15
 * */
interface ImstateService {

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

    /**修改在线状态
     * @param pd
     * @throws Exception
     */
    void editOnline(PageData pd) throws Exception

    /**修改个性签名
     * @param pd
     * @throws Exception
     */
    void editAuto(PageData pd) throws Exception

    /**修改皮肤
     * @param pd
     * @throws Exception
     */
    void editSign(PageData pd) throws Exception

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

    /**通过用户名获取数据
     * @param pd
     * @throws Exception
     */
    PageData findByUsername(PageData pd) throws Exception

    /**批量删除
     * @param ArrayDATA_IDS
     * @throws Exception
     */
    void deleteAll(String[] ArrayDATA_IDS) throws Exception
}