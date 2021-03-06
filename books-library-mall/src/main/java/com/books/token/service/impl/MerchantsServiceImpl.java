package com.books.token.service.impl;

import com.books.token.mapper.MerchantsMapper;
import com.books.token.entity.Merchants;
import com.books.token.service.MerchantsServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = Exception.class)
@Service("merchantService")
public class MerchantsServiceImpl implements MerchantsServiceI {
	@Autowired
	private MerchantsMapper merchantsMapper;

	@Override
	public Merchants getMerchantsById(int id) {
		return merchantsMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(Merchants record) {
		return merchantsMapper.updateByPrimaryKey(record);
	}

}
