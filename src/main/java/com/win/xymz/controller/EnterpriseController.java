package com.win.xymz.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.win.xymz.bean.Job;
import com.win.xymz.common.util.AjaxReturnInfo;
import com.win.xymz.service.CompanyService;

/** 
 * @author 作者 Carl Zhang. E-mail: carlzhangweiwen@sina.com
 * @version 创建时间：2016年2月25日 上午12:22:54 
 * 类说明 
 */
@Controller
public class EnterpriseController {
	@Autowired
	private  CompanyService companyService;

	/**
	 * 发布兼职
	 * @param job
	 */
	@RequestMapping(value = "/toReleaseJobs.json")
	public Map<String,Object> toReleaseJobs(Job job){
		System.out.println(job);
		AjaxReturnInfo ajaxReturnInfo = new AjaxReturnInfo();
		companyService.insertJob(job);
		
		return ajaxReturnInfo.getReturnMap();
	}
	
	/**
	 * 我发布的兼职
	 * @return
	 */
	public List<Job> releaseedJobs(){
		return null;
	}
	

}

