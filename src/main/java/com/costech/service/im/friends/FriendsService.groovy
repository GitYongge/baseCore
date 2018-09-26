package com.costech.service.im.friends

import com.costech.entity.Page
import com.costech.util.PageData

/**
 * @ClassName: FriendsService
 * @description: ${description}
 * @author: yangy
 * @create: 2018-09-17 13:41
 * */
interface FriendsService {

/**新增
 * @param pd
 * @throws Exception
 */
    void save(PageData pd) throws Exception;

    /**删除
     * @param pd
     * @throws Exception
     */
    void delete(PageData pd) throws Exception;

    /**拉黑
     * @param pd
     * @throws Exception
     */
    void pullblack(PageData pd) throws Exception;

    /**修改
     * @param pd
     * @throws Exception
     */
    void edit(PageData pd) throws Exception;

    /**修改同意状态
     * @param pd
     * @throws Exception
     */
    void editAllow(PageData pd) throws Exception;

    /**列表
     * @param page
     * @throws Exception
     */
    List<PageData> list(Page page) throws Exception;

    /**列表(全部自己的好友)
     * @param pd
     * @throws Exception
     */
    List<PageData> listAll(PageData pd) throws Exception;

    /**列表(添加好友页面检索好友)
     * @param pd
     * @throws Exception
     */
    List<PageData> listAllToSearch(PageData pd) throws Exception;

    /**列表(全部全部有自己好友的用户)
     * @param pd
     * @throws Exception
     */
    List<PageData> listAllFri(PageData pd) throws Exception;

    /**通过id获取数据
     * @param pd
     * @throws Exception
     */
    PageData findById(PageData pd) throws Exception;

    /**获取某个好友详细信息
     * @param pd
     * @throws Exception
     */
    PageData getTheFriend(PageData pd) throws Exception;

    /**获取我的某个好友
     * @param pd
     * @throws Exception
     */
    PageData findMyFriend(PageData pd) throws Exception;

    /**批量删除
     * @param ArrayDATA_IDS
     * @throws Exception
     */
    void deleteAll(String[] ArrayDATA_IDS) throws Exception;
}