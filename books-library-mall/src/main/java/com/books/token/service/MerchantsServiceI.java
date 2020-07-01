package com.books.token.service;

import com.books.token.entity.Merchants;

public interface MerchantsServiceI {

	public Merchants getMerchantsById(int id);

	int updateByPrimaryKey(Merchants record);

}
