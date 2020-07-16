package com.books.entity.order.requset;

import lombok.Data;

import java.util.List;

@Data
public class PayOrderPreReq {


    private List<Integer> goodsIds;

}
