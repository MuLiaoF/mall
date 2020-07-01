package com.books.token.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weupay.member.token.dao.MerchantsMapper;
import com.weupay.member.token.entity.Merchants;
import com.weupay.member.token.service.MerchantsServiceI;

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
