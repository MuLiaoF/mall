package com.books.order.service;

import com.books.entity.member.SysAuthUser;
import com.books.entity.order.entity.PayOrder;
import com.books.request.pay.UpdateOrderReq;
import com.books.util.base.ResultData;

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

    /**
     * 更新订单失败
     * @param updateOrderReq
     * @return
     * @throws Exception
     */
    ResultData editSaveStatus(UpdateOrderReq updateOrderReq)  throws Exception;
}
