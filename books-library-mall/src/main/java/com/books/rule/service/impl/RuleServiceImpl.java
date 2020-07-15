package com.books.rule.service.impl;

import com.books.response.rule.CardRuleSelRsp;
import com.books.rule.mapper.PayCreateCardRuleMapper;
import com.books.rule.service.IRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author feng
 * @version 1.0
 * @date 2020/7/15 16:26
 */
@Service
public class RuleServiceImpl implements IRuleService {

    @Autowired
    private PayCreateCardRuleMapper payCreateCardRuleMapper;

    @Override
    public List<CardRuleSelRsp> getMemberGoodsList() throws Exception {
        List<CardRuleSelRsp> cardRuleSelRsps = payCreateCardRuleMapper.selectPayCreateCardRule();
        return cardRuleSelRsps;
    }
}
