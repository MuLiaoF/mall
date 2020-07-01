package com.books.token.service.impl;

import com.books.token.mapper.AuthorInfoMapper;
import com.books.token.entity.AuthorInfo;
import com.books.token.service.AuthorInfoServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Transactional(rollbackFor = Exception.class)
@Service("authorInfoService")
public class AuthorInfoServiceImpl implements AuthorInfoServiceI {
	
	@Autowired
	private AuthorInfoMapper authorInfoMapper;
	@Override
	public int insert(AuthorInfo record) {
		
		return authorInfoMapper.insert(record);
	}
	@Override
	public AuthorInfo queryByPrimaryKey(int id) {
		
		return authorInfoMapper.selectByPrimaryKey(id);
	}
	@Override
	public AuthorInfo queryByAppid(Map<String,Object> condition) {
		
		return authorInfoMapper.selectByAppid(condition);
	}
	@Override
	public int selectAuthorInfoCount(Map<String,Object> condition) {
		return authorInfoMapper.selectAuthorInfoCount(condition);
	}
	

		

}
