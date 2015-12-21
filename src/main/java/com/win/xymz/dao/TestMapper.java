package com.win.xymz.dao;

import java.util.List;

import com.win.xymz.bean.Test;

public interface TestMapper {
	public Test queryByName(String name) throws Exception;
	public void add(Test t) throws Exception;
	public void batchAdd(List<Test> list) throws Exception;
	public void update(Test t) throws Exception;
	public void delete(Object id) throws Exception;
	public Test queryById(Object id) throws Exception;
}
