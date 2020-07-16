package com.books.entity.order.entity;


import lombok.Data;
import org.omg.PortableInterceptor.INACTIVE;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class PayOrder {

  private Integer id;
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
  private Timestamp payTime;
  private Timestamp createTime;
  private Timestamp updateTime;

}
