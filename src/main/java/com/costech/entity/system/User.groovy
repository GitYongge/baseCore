package com.costech.entity.system

import com.costech.entity.Page

/**
 * @ClassName: User
 * @description: 用户
 * @author: yangy
 * @create: 2018-09-17 15:49
 * */
class User {

    String USER_ID		//用户id
    String USERNAME	//用户名
    String PASSWORD 	//密码
    String NAME		//姓名
    String RIGHTS		//权限
    String ROLE_ID		//角色id
    String ROLE_IDS	//副职角色id
    String LAST_LOGIN	//最后登录时间
    String IP			//用户登录ip地址
    String STATUS		//状态
    Role role			//角色对象
    Page page			//分页对象
    String SKIN		//皮肤
}
