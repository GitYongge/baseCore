package com.costech.maintest

import com.github.pagehelper.PageHelper
import org.junit.runner.RunWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
 * @ClassName: BaseJunit4Test
 * @description: ${description}
 * @author: yangy
 * @create: 2018-09-26 10:51
 * */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:ApplicationContext-*.xml")
class BaseJunit4Test {

    @org.junit.Test
    void Test(){
        PageHelper.startPage(0,1)

        println("测试")
    }
}
