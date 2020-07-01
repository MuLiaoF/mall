package com.books.token.service;

import com.books.entity.token.AccessToken;

import java.util.List;

public interface AccessTokenService {
	
	int insertSelective(AccessToken record);

    int updateByPrimaryKeySelective(AccessToken accessToken);

    List<AccessToken> selectAll();

    List<AccessToken> selectWithExpiresTime(Long expiresTime);

	int batchUpdateWithId(List<AccessToken> accessTokenCaches);
	
	AccessToken selectByCondition(AccessToken accessToken);
	
	AccessToken selectByPrimaryKey(Integer id);

}
