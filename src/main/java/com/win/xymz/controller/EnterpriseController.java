package com.win.xymz.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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
	private Logger logger = LogManager.getLogger(EnterpriseController.class);
	@Autowired
	private  CompanyService companyService;

	/**
	 * 发布兼职
	 * @param job
	 */
	@RequestMapping(value = "/toReleaseJobs.json")
	public Map<String,Object> toReleaseJobs(Job job){
		logger.info("===============job:"+job);
		AjaxReturnInfo ajaxReturnInfo = new AjaxReturnInfo();
		companyService.insertJob(job);
		
		return ajaxReturnInfo.getReturnMap();
	}
	
	/**
	 * 我发布的兼职
	 * @return
	 */
	@RequestMapping(value = "/getReleaseJobs.json")
	public Map<String,Object> releaseedJobs(){
		AjaxReturnInfo ajaxReturnInfo = new AjaxReturnInfo();
		List<Job> jobs= companyService.getByCompanyId(1);
		logger.info("job list : "+jobs);
		ajaxReturnInfo.add("jobLIST", jobs);
		return ajaxReturnInfo.getReturnMap();
	}
	

}

