package com.books.token.service;

import com.books.token.entity.AuthorInfo;

import java.util.Map;


public interface AuthorInfoServiceI {

	int insert(AuthorInfo record);
	AuthorInfo queryByPrimaryKey(int id);
	
	AuthorInfo queryByAppid(Map<String, Object> condition);
	
	int selectAuthorInfoCount(Map<String, Object> condition);
}