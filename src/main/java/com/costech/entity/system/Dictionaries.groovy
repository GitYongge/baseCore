package com.costech.entity.system
/**
 * @ClassName: Dictionaries
 * @description: 数据字典
 * @author: yangy
 * @create: 2018-09-17 15:46
 * */
class Dictionaries {

    String NAME			    //名称
    String NAME_EN			//英文名称
    String BIANMA			//编码
    String ORDER_BY		    //排序
    String PARENT_ID		//上级ID
    String BZ				//备注
    String TBSNAME			//关联表
    String DICTIONARIES_ID	//主键
    String target
    Dictionaries dict
    List<Dictionaries> subDict
    Boolean hasDict = false
    String treeurl
}
