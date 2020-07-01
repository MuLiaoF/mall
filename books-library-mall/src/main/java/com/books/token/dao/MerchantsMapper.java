package com.books.token.dao;

import com.books.token.entity.Merchants;
import org.apache.ibatis.annotations.Param;

public interface MerchantsMapper {

	Merchants selectByPrimaryKey(int id);

	int updateByPrimaryKey(@Param("merchants") Merchants record);

}