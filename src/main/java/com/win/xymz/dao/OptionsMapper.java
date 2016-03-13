package com.win.xymz.dao;

import com.win.xymz.bean.Options;

public interface OptionsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Options record);

    int insertSelective(Options record);

    Options selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Options record);

    int updateByPrimaryKey(Options record);
}