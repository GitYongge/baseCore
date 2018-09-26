package com.costech.service.im.qgroup

import com.costech.entity.Page
import com.costech.util.PageData

/**
 * @ClassName: QgroupService
 * @description: 群组接口
 * @author: yangy
 * @create: 2018-09-17 15:24
 * */
interface QgroupService {

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

    /**列表(全部)
     * @param pd
     * @throws Exception
     */
    List<PageData> listAll(PageData pd)throws Exception

    /**群检索列表
     * @param pd
     * @throws Exception
     */
    List<PageData> searchListAll(PageData pd)throws Exception

    /**我在的全部群列表
     * @param pd
     * @throws Exception
     */
    List<PageData> mylistAll(PageData pd)throws Exception

    /**通过id获取数据
     * @param pd
     * @throws Exception
     */
    PageData findById(PageData pd)throws Exception

    /**删除图片
     * @param pd
     * @throws Exception
     */
    void delTp(PageData pd)throws Exception

}