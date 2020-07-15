package com.books.order.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.books.entity.member.MemMemberInfo;
import com.books.entity.order.entity.PayMemOrder;
import com.books.entity.rule.PayCreateCardRule;
import com.books.entity.rule.PayCreateCardRuleDetail;
import com.books.member.mapper.MemMemberInfoMapper;
import com.books.order.service.PayMemberOrderService;
import com.books.pay.mapper.PayMemOrderMapper;
import com.books.rule.mapper.PayCreateCardRuleDetailMapper;
import com.books.rule.mapper.PayCreateCardRuleMapper;
import com.books.util.enums.PayOrderEnums;
import com.books.util.enums.RuleEnums;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Slf4j
@Service
public class PayMemberOrderServiceImpl implements PayMemberOrderService {

    @Autowired
    private PayMemOrderMapper payMemOrderMapper;

    @Autowired
    private MemMemberInfoMapper memMemberInfoMapper;

    @Autowired
    private PayCreateCardRuleMapper payCreateCardRuleMapper;

    @Autowired
    private PayCreateCardRuleDetailMapper payCreateCardRuleDetailMapper;

    @Override
    public PayMemOrder createMemeberOrder(Integer id, Integer goodsId) throws Exception {

        PayMemOrder paramMemOrder = new PayMemOrder();
        paramMemOrder.setAuthUserId(id);
        PayMemOrder memOrder = payMemOrderMapper.selectOne(Wrappers.query(paramMemOrder));

        PayCreateCardRuleDetail payCreateCardRuleDetail = payCreateCardRuleDetailMapper.selectById(goodsId);
        if(payCreateCardRuleDetail == null) {
            throw new RuntimeException("该活动不存在");
        }
        PayCreateCardRule payCreateCardRule = payCreateCardRuleMapper.selectById(goodsId);

        if(payCreateCardRule == null) {
            throw new RuntimeException("该规则不存在");
        }

        Date beginTime = payCreateCardRule.getBeginTime();
        Date endTime = payCreateCardRule.getEndTime();
        Date curDate = new Date();
        if(beginTime.compareTo(curDate) < 0 || endTime.compareTo(curDate) > 0) {
            throw new RuntimeException("该活动已经结束，请改日再来");
        }

        String isRenew = payCreateCardRule.getIsRenew();
        MemMemberInfo paramMemberInfo = new MemMemberInfo();
        paramMemberInfo.setAuthUserId(id);
        MemMemberInfo selMemberInfo = memMemberInfoMapper.selectOne(Wrappers.query(paramMemberInfo));

        PayMemOrder payMemOrder = null;
        //是续费会员
        if(isRenew.equals(RuleEnums.IS_RENEW_TRUE.getCode())) {
            payMemOrder = isTrueMember(payCreateCardRuleDetail ,memOrder, selMemberInfo, id);
        } else {
            payMemOrder = isFalseMember(payCreateCardRule, selMemberInfo);
        }
        return payMemOrder;
    }

    /**
     * 是续费会员的规则
     * @param payCreateCardRuleDetail
     * @param selMemberInfo
     * @return
     */
    private PayMemOrder isTrueMember(PayCreateCardRuleDetail payCreateCardRuleDetail, PayMemOrder order,  MemMemberInfo selMemberInfo, Integer authId) throws Exception {
        //如果是查询不到会员，说明是第一次注册会员
        BigDecimal nowPrice = payCreateCardRuleDetail.getNowPrice();
        PayMemOrder payMemOrder = new PayMemOrder();
        payMemOrder.setOrderType(PayOrderEnums.ORDER_TYPE_PAY_FORWARD.getCode());
        payMemOrder.setOrderStatus(PayOrderEnums.ORDER_STATUS_PRE.getCode());
        payMemOrder.setRefundStatus(PayOrderEnums.REFUND_STATUS_NOT.getCode());
        payMemOrder.setResultStatus(PayOrderEnums.RESULT_STATUS_SUCCESS.getCode());
        payMemOrder.setAuthUserId(authId);
        if(selMemberInfo == null) {
            if(order != null || !order.getOrderStatus().equals(PayOrderEnums.ORDER_STATUS_ERROR.getCode())) {
                throw new RuntimeException("请完成之前的订单");
            }
            payMemOrder.setGoodsPrice(nowPrice);
        } else {
            payMemOrder.setMemberId(selMemberInfo.getId());
        }
        payMemOrderMapper.insert(payMemOrder);
        return payMemOrder;
    }

    /**
     * 不是续费会员的规则
     * @param payCreateCardRule
     * @param selMemberInfo
     * @return
     */
    private PayMemOrder isFalseMember(PayCreateCardRule payCreateCardRule, MemMemberInfo selMemberInfo) {
        return null;
    }


}
