package com.books.member.service.impl;

import com.books.member.mapper.IndexMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.member.service.IndexService;

@Service
public class IndexServiceImpl implements IndexService {

	
	@Autowired
	private IndexMapper indexMapper;
	
	
	@Override
	public Member demo() {
		// TODO Auto-generated method stub
		return indexMapper.selectById(1);
	}

	@Override
	public Member demo2() {
		return indexMapper.select(1);
	}

}
