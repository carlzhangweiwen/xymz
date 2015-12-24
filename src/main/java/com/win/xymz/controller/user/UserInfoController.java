package com.win.xymz.controller.user;


import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.win.xymz.common.util.AjaxReturnInfo;

/** 
 * @author 作者 Carl Zhang. E-mail: carlzhangweiwen@sina.com
 * @version 创建时间：2015年12月23日 下午9:16:02 
 * 类说明 
 */
@Controller
public class UserInfoController {
	
	/**
	 * 请求数据库，如果登录密码正确，则返回加过密的token
	 * @return
	 */
	@RequestMapping(value="/login.json", method=RequestMethod.GET)
	public Map<String,Object> login(){
		AjaxReturnInfo res = new AjaxReturnInfo();
		res.add("username", "carl");
		return res.getReturnMap();
	}
	
}

