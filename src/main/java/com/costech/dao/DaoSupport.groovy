package com.costech.dao

import org.mybatis.spring.SqlSessionTemplate
import org.springframework.stereotype.Repository

import javax.annotation.Resource

/**
 * @ClassName: DaoSupport
 * @description: ${description}
 * @author: yangy
 * @create: 2018-09-17 11:18
 * */
@Repository("daoSupport")
class DaoSupport implements DAO {

    @Resource(name = "sqlSessionTemplate")
    private SqlSessionTemplate sqlSessionTemplate

    /**
     * 新增对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    Object save(String str, Object obj) throws Exception {
        return sqlSessionTemplate.insert(str,obj)
    }

    /**
     * 修改对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    Object update(String str, Object obj) throws Exception {
        return sqlSessionTemplate.update(str,obj)
    }

    /**
     * 删除对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    Object delete(String str, Object obj) throws Exception {
        return sqlSessionTemplate.delete(str,obj)
    }

    /**
     * 查找对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    Object findForObject(String str, Object obj) throws Exception {
        return sqlSessionTemplate.selectOne(str,obj)
    }

    /**
     *  查找List对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    Object findForList(String str, Object obj) throws Exception {
        return sqlSessionTemplate.selectList(str,obj)
    }

    /**
     *
     * @param sql
     * @param obj
     * @param key
     * @param value
     * @return
     * @throws Exception
     */
    Object findForMap(String sql, Object obj, String key) throws Exception {
        return sqlSessionTemplate.selectMap(sql,obj,key)
    }


}
