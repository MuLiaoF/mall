package com.books.order.service.impl;

import com.books.book.mapper.BookInfoMapper;
import com.books.entity.bookinfo.BookInfoBean;
import com.books.entity.goodsInfo.GoodsInfoBean;
import com.books.entity.member.SysAuthUser;
import com.books.entity.order.entity.PayOrder;
import com.books.entity.order.entity.PayOrderGoods;
import com.books.goods.mapper.GoodsInfoMapper;
import com.books.order.mapper.PayOrderGoodsMapper;
import com.books.order.mapper.PayOrderMapper;
import com.books.order.service.IPayOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author feng
 */
@Slf4j
@Service
public class PayOrderServiceImpl implements IPayOrderService {

    @Autowired
    private PayOrderMapper payOrderMapper;

    @Autowired
    private PayOrderGoodsMapper payOrderGoodsMapper;

    @Autowired
    private GoodsInfoMapper goodsInfoMapper;

    /**
     * 创建订单，
     * 首先查询商品是否存在，存在则开始计算金额
     * 如果不存在则返回错误信息
     * 如果商品存在则
     * @param goodsIds 商品的主键值
     * @return
     * @throws Exception
     */
    @Override
    @Transactional
    public PayOrder createOrder(List<Integer> goodsIds, SysAuthUser user) throws Exception {

        List<GoodsInfoBean> goodsInfoBeans = goodsInfoMapper.selectBatchIds(goodsIds);

        if(goodsInfoBeans == null || goodsInfoBeans.size() != goodsIds.size()) {
            throw new RuntimeException("当前书信息不存在");
        }

        PayOrder payOrder = new PayOrder();
        payOrder.setAuthUserId(user.getId());
        //支付订单
        payOrder.setOrderType("0");
        //微信支付
        payOrder.setPayWay("WX");
        //订单ID
        payOrder.setOrderId(UUID.randomUUID().toString().replace("-", ""));

        payOrder.setFrontUrl("微信回调地址");

        BigDecimal goodsPriceSum = new BigDecimal("0");
        BigDecimal oldPriceSum = new BigDecimal("0");


        List<PayOrderGoods> orderGoods = new ArrayList<>();

        for (GoodsInfoBean goodsInfoBean : goodsInfoBeans) {

            BigDecimal benefitPrice = goodsInfoBean.getBenefitPrice();
            BigDecimal oldPrice = goodsInfoBean.getOldPrice();

            goodsPriceSum = goodsPriceSum.add(benefitPrice);
            oldPriceSum = oldPriceSum.add(oldPrice);


            PayOrderGoods payOrderGoods = new PayOrderGoods();
            payOrderGoods.setGoodsId(goodsInfoBean.getId());
            payOrderGoods.setGoodsPrice(benefitPrice);
            payOrderGoods.setOrderId(payOrder.getOrderId());


            orderGoods.add(payOrderGoods);
        }


        payOrder.setAmount(goodsPriceSum);

        payOrderMapper.insert(payOrder);
        payOrderGoodsMapper.insertBatch(orderGoods);
        return payOrder;
    }
}
