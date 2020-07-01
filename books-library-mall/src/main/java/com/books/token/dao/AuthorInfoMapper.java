package com.books.token.dao;

import com.books.token.entity.AuthorInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface AuthorInfoMapper {

	int insert(@Param("authorInfo") AuthorInfo record);

	AuthorInfo selectByPrimaryKey(int id);

	AuthorInfo selectByAppid(@Param("condition") Map<String, Object> condition);

	int selectAuthorInfoCount(@Param("condition") Map<String, Object> condition);

}
