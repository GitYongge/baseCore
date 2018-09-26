package com.costech.service.im.friends.impl

import com.costech.dao.DaoSupport
import com.costech.entity.Page
import com.costech.service.im.friends.FriendsService
import com.costech.util.PageData
import org.springframework.stereotype.Service

import javax.annotation.Resource

/**
 * @ClassName: FriendsServiceImpl
 * @description: 好友管理
 * @author: yangy
 * @create: 2018-09-17 13:43
 * */
@Service("friendsService")
class FriendsServiceImpl implements FriendsService {

    @Resource(name = "daoSupport")
    private DaoSupport dao

    /**新增
     * @param pd
     * @throws Exception
     */
    void save(PageData pd) throws Exception {
        dao.save("FriendsMapper.save", pd)
    }

    /**删除
     * @param pd
     * @throws Exception
     */
    void delete(PageData pd) throws Exception {
        dao.delete("FriendsMapper.delete", pd)
    }

    /**拉黑
     * @param pd
     * @throws Exception
     */
    void pullblack(PageData pd) throws Exception {
        dao.delete("FriendsMapper.pullblack", pd)
    }

    /**修改
     * @param pd
     * @throws Exception
     */
    void edit(PageData pd) throws Exception {
        dao.update("FriendsMapper.edit", pd)
    }

    /**修改同意状态
     * @param pd
     * @throws Exception
     */
    void editAllow(PageData pd) throws Exception {
        dao.update("FriendsMapper.editAllow", pd)
    }

    /**列表
     * @param page
     * @throws Exception
     */
    List<PageData> list(Page page) throws Exception {
        return (List<PageData>) dao.findForList("FriendsMapper.datalistPage", page)
    }

    /**列表(全部自己的好友)
     * @param pd
     * @throws Exception
     */
    List<PageData> listAll(PageData pd) throws Exception {
        return (List<PageData>) dao.findForList("FriendsMapper.listAll", pd)
    }

    /**列表(添加好友页面检索好友)
     * @param pd
     * @throws Exception
     */
    List<PageData> listAllToSearch(PageData pd) throws Exception {
        return (List<PageData>) dao.findForList("FriendsMapper.listAllToSearch", pd)
    }

    /**列表(全部全部有自己好友的用户)
     * @param pd
     * @throws Exception
     */
    List<PageData> listAllFri(PageData pd) throws Exception {
        return (List<PageData>) dao.findForList("FriendsMapper.listAllFri", pd)
    }

    /**通过id获取数据
     * @param pd
     * @throws Exception
     */
    PageData findById(PageData pd) throws Exception {
        return (PageData) dao.findForObject("FriendsMapper.findById", pd)
    }

    /**获取某个好友详细信息
     * @param pd
     * @throws Exception
     */
    PageData getTheFriend(PageData pd) throws Exception {
        return (PageData) dao.findForObject("FriendsMapper.getTheFriend", pd)
    }

    /**获取我的某个好友
     * @param pd
     * @throws Exception
     */
    PageData findMyFriend(PageData pd) throws Exception {
        return (PageData) dao.findForObject("FriendsMapper.findMyFriend", pd)
    }

    /**批量删除
     * @param ArrayDATA_IDS
     * @throws Exception
     */
    void deleteAll(String[] ArrayDATA_IDS) throws Exception {
        dao.delete("FriendsMapper.deleteAll", ArrayDATA_IDS)
    }
}
