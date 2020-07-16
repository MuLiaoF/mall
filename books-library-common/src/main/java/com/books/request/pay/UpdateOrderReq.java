package com.books.request.pay;

import lombok.Data;

import java.util.Date;

/**
 * 会员购卡订单对象 pay_buy_card_order
 * @author zye
 * @date 2020-06-20
 */
@Data
public class UpdateOrderReq {
    private static final long serialVersionUID = 1L;



    /**
     * 商户id
     */
    private Integer mid;


    /**
     * 会员平台，通道订单表的订单id
     */
    private String outTradeNo;

    /**
     * 购卡订单id
     */
    private String orderId;

    /**
     * 会员平台，通道订单表的订单id
     */
    private String channelOrderId;

    /**
     * 会员id
     */
    private Integer memberId;


    /**
     * 会员购卡来源
     */
    private String source;

    /**
     * 支付场景(免费/付费)
     */
    private String scene;

    /**
     * 订单最终结果状态,成功1或失败0
     */
    private String resultStatus;

    /**
     * 订单交易状态（0 待交易，3 交易中，1 交易成功，2 交易失败、）
     */
    private String orderStatus;

    /**
     * 支付订单标识是否退款状态（0未退， 1 部分，2 全额或退款结束）
     */
    private String refundStatus;

    /**
     * 支付时间
     */
    private Date payTime;



}
