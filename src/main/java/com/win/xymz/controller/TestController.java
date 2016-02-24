package com.win.xymz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.win.xymz.bean.Test;
import com.win.xymz.service.TestService;

@Controller
@RequestMapping("/test.do")
public class TestController extends BaseController{
	@Autowired
	private  TestService testService;
	
	@RequestMapping(params = "method=toLoginTestPage",method = RequestMethod.GET)
	public String toLoginTestPage(){
		return "demo/loginTest";
	}
	
	@RequestMapping(params = "method=login",method = RequestMethod.POST)
	public String login(Test user, Model model) throws Exception{
		logger.info("用户名："+user.getName()+" 密码："+user.getPassword());
		
		//插入
		/*try{
			Test insertBean=new Test();
			insertBean.setId("3");
			insertBean.setName("3");
			insertBean.setPassword("3");
			testService.add(insertBean);
		}catch(Exception e){
			e.printStackTrace();
		}*/
		
		//批量插入
		/*List<Test> list=new LinkedList<Test>();
		Test insertBean1=new Test();insertBean1.setId("4");insertBean1.setName("4");insertBean1.setPassword("4");
		Test insertBean2=new Test();insertBean2.setId("44");insertBean2.setName("44");insertBean2.setPassword("44");
		list.add(insertBean1);list.add(insertBean2);
		testService.batchAdd(list);*/
		
		
		//查询
		Test bean=testService.queryByName(user.getName());
		if(bean.getName().equals(user.getPassword())){
			model.addAttribute("username", user.getName());
			return "demo/success";
		}else{
			return "demo/error";
		}
	}
}
