package com.costech.entity.system
/**
 * @ClassName: Role
 * @description: 角色
 * @author: yangy
 * @create: 2018-09-17 15:48
 * */
class Role {
    String ROLE_ID		//ID
    String ROLE_NAME	//名称
    String RIGHTS		//权限(存放的除权后的菜单ID)控制菜单显示
    String PARENT_ID	//上级ID
    String ADD_QX		//新增权限(存放的除权后的菜单ID)有新增权限的菜单ID
    String DEL_QX		//删除权限(存放的除权后的菜单ID)有删除权限的菜单ID
    String EDIT_QX		//修改权限(存放的除权后的菜单ID)有修改权限的菜单ID
    String CHA_QX		//查看权限(存放的除权后的菜单ID)有查看权限的菜单ID
    String RNUMBER		//编号(在处理类中新增的时候自动生成)
}
