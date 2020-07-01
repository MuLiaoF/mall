package com.books.token.dao;

import com.books.token.entity.ComVerTic;
import org.apache.ibatis.annotations.Param;

public interface ComVerTicMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(ComVerTic record);

	int insertSelective(ComVerTic record);

	ComVerTic selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(ComVerTic record);

	int updateByPrimaryKey(ComVerTic record);

	ComVerTic selectByAppid(@Param("appid") String appid);
}