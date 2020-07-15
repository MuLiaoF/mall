package com.books.entity.order.entity;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class PayOrder {

  private long id;
  private long mid;
  private long sid;
  private String orderId;
  private String outTradeNo;
  private String channelOrderId;
  private String channel;
  private BigDecimal amount;
  private String orderType;
  private String parentId;
  private String payWay;
  private String payType;
  private String status;
  private String scene;
  private String frontUrl;
  private String resultStatus;
  private String orderStatus;
  private String refundStatus;
  private long authUserId;
  private java.sql.Timestamp payTime;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;

}
