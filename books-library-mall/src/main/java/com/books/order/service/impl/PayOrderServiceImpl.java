package com.books.order.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
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
import com.books.request.pay.UpdateOrderReq;
import com.books.util.base.ExceptionConstantsUtils;
import com.books.util.base.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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


    @Override
    public ResultData editSaveStatus(UpdateOrderReq updateOrderReq) throws Exception {
        String orderId = updateOrderReq.getOrderId();
        PayOrder paramPayOrder = new PayOrder();
        paramPayOrder.setOrderId(orderId);
        PayOrder payOrder = payOrderMapper.selectOne(Wrappers.query(paramPayOrder));
        
        if (payOrder == null){
            return ExceptionConstantsUtils.printSuccessMessage(log, "", 0);
        }
        //已支付成功的订单不再更新订单状态
        String status = payOrder.getOrderStatus();
        if ("1".equals(status)){
            return ExceptionConstantsUtils.printSuccessMessage(log, "", 1);
        }

        return  ExceptionConstantsUtils.printSuccessMessage(log, "更新订单" , updateBuyOrder(payOrder,updateOrderReq));
    }


    public int updateBuyOrder(PayOrder payChannelOrder,  UpdateOrderReq updateOrderReq) {
        Timestamp date = new Timestamp(System.currentTimeMillis());
        String orderId = payChannelOrder.getOrderId();
        String orderStatus = updateOrderReq.getOrderStatus();
        String resultStatus = updateOrderReq.getResultStatus();
        String channelOrderId = updateOrderReq.getChannelOrderId();
        Date payTime = updateOrderReq.getPayTime();

        payChannelOrder.setChannelOrderId(channelOrderId);
        //payChannelOrder.setStatus(orderStatus);
        payChannelOrder.setOrderStatus(orderStatus);
        payChannelOrder.setResultStatus(resultStatus);
        payChannelOrder.setOutTradeNo(updateOrderReq.getOutTradeNo());
        payChannelOrder.setPayTime(new Timestamp(payTime.getTime()));
        payChannelOrder.setUpdateTime(date);
        //调支付系统下单记录
        int i = payOrderMapper.update(payChannelOrder, Wrappers.update(payChannelOrder));
        log.info("更新购卡第三方通道订单{}!orderId:{}", i > 0 ? "成功" : "失败", orderId);

        //下单
        PayOrder payBuyCardOrder = new PayOrder();
        payBuyCardOrder.setOrderId(orderId);
        payBuyCardOrder.setChannelOrderId(channelOrderId);
        payBuyCardOrder.setOrderStatus(orderStatus);
        payBuyCardOrder.setResultStatus(resultStatus);
        payBuyCardOrder.setUpdateTime(date);
        //int i = payBuyCardOrderMapper.updatePayBuyCardOrderStatus(payBuyCardOrder);
        log.info("更新购卡订单{}!orderId:{}", i > 0 ? "成功" : "失败", orderId);

        return i;
    }
}
