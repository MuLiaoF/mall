package com.books.token.service;

import com.books.token.entity.ComVerTic;

public interface ComVerTicService {

	ComVerTic selectByAppid(String appid);

	int insertSelective(ComVerTic record);

	ComVerTic selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(ComVerTic record);

}
