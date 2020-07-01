package com.books.token.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weupay.member.token.dao.AccessTokenMapper;
import com.weupay.member.token.entity.AccessToken;
import com.weupay.member.token.service.AccessTokenService;

@Service
public class AccessTokenServiceImpl implements AccessTokenService {

	@Autowired
	private AccessTokenMapper accessTokenMapper;

	@Transactional(rollbackFor = Exception.class, readOnly = false)
	@Override
	public int updateByPrimaryKeySelective(AccessToken accessToken) {
		return accessTokenMapper.updateByPrimaryKeySelective(accessToken);
	}

	@Transactional(rollbackFor = Exception.class, readOnly = true)
	@Override
	public List<com.weupay.member.token.weixin.common.bean.AccessToken> selectAll() {
		return accessTokenMapper.selectAll();
	}

	@Transactional(rollbackFor = Exception.class, readOnly = true)
	@Override
	public List<com.weupay.member.token.weixin.common.bean.AccessToken> selectWithExpiresTime(Long expiresTime) {
		return accessTokenMapper.selectWithExpiresTime(expiresTime);
	}

	@Transactional(rollbackFor = Exception.class, readOnly = false)
	@Override
	public int batchUpdateWithId(List<com.weupay.member.token.weixin.common.bean.AccessToken> accessTokenCaches) {
		int count = 0;
		for (com.weupay.member.token.weixin.common.bean.AccessToken accessTokenCache : accessTokenCaches) {
			count += accessTokenMapper.updateWithId(accessTokenCache);
		}
		return count;
	}

	@Override
	public AccessToken selectByCondition(AccessToken accessToken) {
		return accessTokenMapper.selectByCondition(accessToken);
	}

	@Override
	public int insertSelective(AccessToken record) {
		return accessTokenMapper.insertSelective(record);
	}

	@Override
	public AccessToken selectByPrimaryKey(Integer id) {
		return accessTokenMapper.selectByPrimaryKey(id);
	}

}
