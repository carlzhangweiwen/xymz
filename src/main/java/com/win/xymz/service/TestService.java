package com.win.xymz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.win.xymz.mapperInterface.TestMapper;
import com.win.xymz.vo.Test;

@Service("testService")
public class TestService extends BaseService {
	@Autowired
	private TestMapper testMapper;
	
	public Test queryByName(String name) throws Exception{
		return testMapper.queryByName(name);
	}
	
	public void add(Test t) throws Exception{
		testMapper.add(t);
		//throw new Exception();//测试回滚
	}
	
	public void batchAdd(List<Test> list) throws Exception{
		testMapper.batchAdd(list);
	}
	
	public void update(Test t) throws Exception{
		testMapper.update(t);
	}
	
	public void delete(Object id) throws Exception{
		testMapper.delete(id);
	}
	
	public Test queryById(Object id) throws Exception{
		return testMapper.queryById(id);
	}
}
