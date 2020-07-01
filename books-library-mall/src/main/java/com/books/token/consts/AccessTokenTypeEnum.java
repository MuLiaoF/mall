package com.books.token.consts;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AccessTokenTypeEnum {
	/**
	 * 普通服务商
	 */
	ONE(1),
	/**
	 * 小微服务商
	 */
	TWO(2),
	/**
	 * 全渠道大商户
	 */
	THREE(3),
	/**
	 * 普通商户
	 */
	FOUR(4), FOUR_ONE(41), FOUR_TWO(42), FIVE(5), SIX(6), SEVEN(7);

	private int value;

}
