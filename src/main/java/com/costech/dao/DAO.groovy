package com.costech.dao
/**
 * @ClassName: DAO
 * @description:
 * @author: yangy
 * @create: 2018-09-17 11:18
 * */
interface DAO {
/**
 * 保存对象
 * @param str
 * @param obj
 * @return
 * @throws Exception
 */
    Object save(String str, Object obj) throws Exception

    /**
     * 修改对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    Object update(String str, Object obj) throws Exception

    /**
     * 删除对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    Object delete(String str, Object obj) throws Exception

    /**
     * 查找对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    Object findForObject(String str, Object obj) throws Exception

    /**
     * 查找对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    Object findForList(String str, Object obj) throws Exception

    /**
     * 查找对象封装成Map
     * @param sql
     * @param obj
     * @param key
     * @param value
     * @return
     * @throws Exception
     */
    Object findForMap(String sql, Object obj, String key) throws Exception
}