package com.books.rule.service;

import com.books.response.rule.CardRuleSelRsp;

import java.util.List;

/**
 * @author feng
 * @version 1.0
 * @date 2020/7/15 16:25
 */
public interface IRuleService {

    /**
     * 获取会员商品列表
     * @return
     * @throws Exception
     */
    List<CardRuleSelRsp> getMemberGoodsList() throws Exception;
}
