package com.books.order.service;

import com.books.entity.order.entity.PayMemOrder;

public interface PayMemberOrderService {

    /**
     * 创建购买会员订单
     * @param id
     * @param goodsId
     * @return
     * @throws Exception
     */
    PayMemOrder createMemeberOrder(Integer id, Integer goodsId) throws Exception;
}
