package com.win.xymz.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.win.xymz.mapperInterface.TestMapper;
import com.win.xymz.service.TestService;
import com.win.xymz.vo.Test;

@Service("testService")
public class TestServiceImpl extends BaseService implements TestService {
	@Autowired
	private TestMapper testMapper;
	
	@Override
	public Test queryByName(String name) throws Exception{
		return testMapper.queryByName(name);
	}
	
	@Override
	public void add(Test t) throws Exception{
		testMapper.add(t);
		//throw new Exception();//测试回滚
	}
	
	@Override
	public void batchAdd(List<Test> list) throws Exception{
		testMapper.batchAdd(list);
	}
	
	@Override
	public void update(Test t) throws Exception{
		testMapper.update(t);
	}
	
	@Override
	public void delete(Object id) throws Exception{
		testMapper.delete(id);
	}
	
	@Override
	public Test queryById(Object id) throws Exception{
		return testMapper.queryById(id);
	}
}
