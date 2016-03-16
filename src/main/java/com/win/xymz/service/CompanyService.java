package com.win.xymz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.win.xymz.bean.Job;
import com.win.xymz.dao.JobMapper;

/** 
 * @author 作者 Carl Zhang. E-mail: carlzhangweiwen@sina.com
 * @version 创建时间：2016年3月16日 下午11:33:51 
 * 类说明 
 */
@Service("companyService")
public class CompanyService {
	@Autowired
	private JobMapper jobMapper;
	public void insertJob(Job job){
		jobMapper.insert(job);
	}

}

