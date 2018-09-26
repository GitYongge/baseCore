package com.costech.entity.system
/**
 * @ClassName: Department
 * @description: 组织机构
 * @author: yangy
 * @create: 2018-09-17 15:44
 * */
class Department {

    String NAME			    //名称
    String NAME_EN			//英文名称
    String BIANMA			//编码
    String PARENT_ID		//上级ID
    String HEADMAN			//负责人
    String TEL				//电话
    String FUNCTIONS		//部门职能
    String BZ				//备注
    String ADDRESS			//地址
    String DEPARTMENT_ID	//主键
    String target
    Department department
    List<Department> subDepartment
    Boolean hasDepartment = false
    String treeurl
    String icon

}
