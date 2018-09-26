package com.costech.entity.system
/**
 * @ClassName: Menu
 * @description: 菜单
 * @author: yangy
 * @create: 2018-09-17 15:47
 * */
class Menu {

    String MENU_ID		//菜单ID
    String MENU_NAME	//菜单名称
    String MENU_URL	    //链接
    String PARENT_ID	//上级菜单ID
    String MENU_ORDER	//排序
    String MENU_ICON	//图标
    String MENU_TYPE	//类型
    String MENU_STATE	//菜单状态

    String target
    Menu parentMenu
    List<Menu> subMenu
    Boolean hasMenu = false
}
