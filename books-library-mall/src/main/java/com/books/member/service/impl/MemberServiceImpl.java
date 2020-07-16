package com.books.member.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.books.entity.member.*;
import com.books.entity.order.PayMemOrder;
import com.books.member.mapper.MemMemberInfoMapper;
import com.books.member.mapper.MemberAccountMapper;
import com.books.member.mapper.MemberBonusMapper;
import com.books.member.mapper.MemberDepositMapper;
import com.books.member.service.IMemberService;
import com.books.pay.mapper.PayMemOrderMapper;
import com.books.response.rule.CardRuleSelRsp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author feng
 * @version 1.0
 * @date 2020/7/15 16:23
 */
@Service
@Slf4j
public class MemberServiceImpl implements IMemberService {

    @Autowired
    private MemberBonusMapper memberBonusMapper;

    @Autowired
    private MemberAccountMapper memberAccountMapper;

    @Autowired
    private MemMemberInfoMapper memMemberInfoMapper;

    @Autowired
    private MemberDepositMapper memberDepositMapper;

    @Autowired
    private PayMemOrderMapper payMemOrderMapper;

    @Override
    @Transactional
    public MemMemberInfo regit(SysAuthUser user) throws Exception {

        Integer userId = user.getId();
        MemMemberInfo queryMemInfo = new MemMemberInfo();
        queryMemInfo.setAuthUserId(userId);
        MemMemberInfo selMemInfo = memMemberInfoMapper.selectOne(Wrappers.query(queryMemInfo));
        if(selMemInfo != null) {
            throw  new RuntimeException("该用户已经是会员");
        }

        PayMemOrder paramPayMemOrder = new PayMemOrder();
        paramPayMemOrder.setAuthUserId(userId);
        PayMemOrder payMemOrder = payMemOrderMapper.selectOne(Wrappers.query(paramPayMemOrder));
        String resultStatus = payMemOrder.getResultStatus();
        if(payMemOrder == null) {
            throw  new RuntimeException("订单创建失败");
        }
        if(!"1".equals(resultStatus)) {
            throw  new RuntimeException("订单支付异常");
        }
        //创建会员
        MemMemberInfo memMemberInfo = createMember(user);
        return memMemberInfo;
    }

    /**
     * 根据普通用户信息创建会员信息
     * @param user
     * @return
     */
    private MemMemberInfo createMember(SysAuthUser user) {

        Integer id = user.getId();
        String unionid = user.getUnionid();
        String openid = user.getOpenid();
        String gender = user.getGender();
        String city = user.getCity();
        String nickName = user.getNickName();

        //创建会员信息
        MemMemberInfo memMemberInfo = new MemMemberInfo();
        memMemberInfo.setAuthUserId(id);
        memMemberInfo.setUnionid(unionid);
        memMemberInfo.setOpenId(openid);
        memMemberInfo.setSex(gender);
        memMemberInfo.setCity(city);
        memMemberInfo.setWxName(nickName);
        memMemberInfo.setMemCode("10101010");
        memMemberInfo.setCreateTime(new Date());
        //创建会员账户
        MemAccount memAccount = new MemAccount();
        memAccount.setMemCardCode(memMemberInfo.getMemCode());
        memAccount.setActualBalance(new BigDecimal(0));
        memAccount.setAvailableBalance(new BigDecimal(0));
        memAccount.setCreateTime(new Date());
        //创建会员积分
        MemBonus memBonus = new MemBonus();
        memBonus.setAccountBonus(new BigDecimal(0));
        memBonus.setCumTransAmt(new BigDecimal(0));
        memBonus.setCreateTime(new Date());
        memBonus.setMemCardCode(memMemberInfo.getMemCode());

        //创建会员押金
        MemDeposit memDeposit = new MemDeposit();
        memDeposit.setMemCode(memMemberInfo.getMemCode());
        memDeposit.setAllDeposit(new BigDecimal(0));
        memDeposit.setRealDeposit(new BigDecimal(0));
        memDeposit.setCreateTime(new Date());
        memDeposit.setIsDel(0);


        memMemberInfoMapper.insert(memMemberInfo);
        memberAccountMapper.insert(memAccount);
        memberBonusMapper.insert(memBonus);
        memberDepositMapper.insert(memDeposit);

        return memMemberInfo;
    }
}
