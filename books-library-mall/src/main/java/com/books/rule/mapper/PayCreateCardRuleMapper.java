package com.books.rule.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.books.entity.rule.PayCreateCardRule;
import com.books.response.rule.CardRuleSelRsp;

import java.util.List;

/**
 * 商户开卡活动Mapper接口
 * @author zye
 * @date 2020-06-20
 */
public interface PayCreateCardRuleMapper extends BaseMapper<PayCreateCardRule> {


    /**
     * 查询会员开卡规则
     */
    List<CardRuleSelRsp> selectPayCreateCardRule();

}
