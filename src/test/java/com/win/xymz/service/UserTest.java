package com.win.xymz.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.win.xymz.dao.TestMapper;

public class UserTest {

private TestService userService;
private TestMapper testMapper;
	
	@Before
	public void before(){                                                                    
		//使用"spring.xml"和"spring-mybatis.xml"这两个配置文件创建Spring上下文
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:spring-mvc.xml"
				,"classpath:spring-mybatis.xml"});
       // ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring-mvc.xml","spring-mybatis.xml"});
        //从Spring容器中根据bean的id取出我们要使用的userService对象
        userService = (TestService) context.getBean("testService");
        
        testMapper=(TestMapper)context.getBean("testMapper");
	}
	
	@Test
	public void addUser(){
//		user.setMobilephone("15711698981");
//		user.setPassword("123456");
		try {
			System.out.println(userService.queryByName("1"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
