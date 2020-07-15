package com.books.entity.order.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PayOrderGoods {

  private long id;
  private String orderId;
  private long goodsId;
  private BigDecimal goodsPrice;
  private String goodsName;
  private long activityId;

}
