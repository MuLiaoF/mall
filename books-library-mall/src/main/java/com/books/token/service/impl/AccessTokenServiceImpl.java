package com.books.token.service.impl;

import com.books.entity.token.AccessToken;
import com.books.token.dao.AccessTokenMapper;
import com.books.token.service.AccessTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
	public List<AccessToken> selectAll() {
		return accessTokenMapper.selectAll();
	}

	@Transactional(rollbackFor = Exception.class, readOnly = true)
	@Override
	public List<AccessToken> selectWithExpiresTime(Long expiresTime) {
		return accessTokenMapper.selectWithExpiresTime(expiresTime);
	}

	@Transactional(rollbackFor = Exception.class, readOnly = false)
	@Override
	public int batchUpdateWithId(List<AccessToken> accessTokenCaches) {
		int count = 0;
		for (AccessToken accessTokenCache : accessTokenCaches) {
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
