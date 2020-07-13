package com.books.order.service;

import com.books.entity.member.SysAuthUser;
import com.books.entity.order.entity.PayOrder;

import java.util.List;

/**
 *
 */
public interface IPayOrderService {

    /**
     * 创建订单
     * @param goodsIds 商品的主键值
     * @return 订单详情
     * @throws Exception
     */
    PayOrder createOrder(List<Integer> goodsIds, SysAuthUser user) throws Exception;
}
