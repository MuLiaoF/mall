package com.books.token.dao;

import java.util.List;

import com.books.entity.token.AccessToken;
import org.apache.ibatis.annotations.Param;


public interface AccessTokenMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(AccessToken record);

	int insertSelective(AccessToken record);

	AccessToken selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(AccessToken record);

	int updateByPrimaryKey(AccessToken record);

	List<AccessToken> selectAll();

	List<AccessToken> selectWithExpiresTime(
            @Param("expiresTime") Long expiresTime);

	int updateWithId(AccessToken accessTokenCache);

	AccessToken selectByCondition(AccessToken record);
}
