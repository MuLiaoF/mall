package com.books.token.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weupay.member.token.dao.ComVerTicMapper;
import com.weupay.member.token.entity.ComVerTic;
import com.weupay.member.token.service.ComVerTicService;

@Service
public class ComVerTicServiceImpl implements ComVerTicService {

	@Autowired
	private ComVerTicMapper comVerTicMapper;

	@Transactional(rollbackFor = Exception.class, readOnly = true)
	@Override
	public ComVerTic selectByAppid(String appid) {
		return comVerTicMapper.selectByAppid(appid);
	}

	@Override
	public int insertSelective(ComVerTic record) {
		return comVerTicMapper.insertSelective(record);
	}

	@Override
	public ComVerTic selectByPrimaryKey(Integer id) {
		return comVerTicMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(ComVerTic record) {
		return comVerTicMapper.updateByPrimaryKeySelective(record);
	}

}
