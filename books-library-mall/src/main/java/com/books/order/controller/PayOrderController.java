package com.books.order.controller;

import com.books.entity.member.SysAuthUser;
import com.books.entity.order.entity.PayOrder;
import com.books.entity.order.requset.PayOrderPreReq;
import com.books.order.service.IPayOrderService;
import com.books.util.base.ExceptionConstantsUtils;
import com.books.util.base.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 支付订单
 * @author fengx
 */
@RestController
@Slf4j
@RequestMapping("/pay/order")
public class PayOrderController {

    @Autowired
    private IPayOrderService iPayOrderService;

    /**
     * 支付预下单
     * @return
     */
    @PostMapping("/v1/pre")
    public ResultData payOrderPre(@RequestBody PayOrderPreReq payOrderPreReq, HttpSession session) {

        SysAuthUser user = (SysAuthUser) session.getAttribute("user");

        List<Integer> goodsIds = payOrderPreReq.getGoodsIds();

        if(goodsIds == null || goodsIds.size() == 0) {
            return ExceptionConstantsUtils.printErrorMessage(log, "商品ID不能为空");
        }

        PayOrder payOrder = null;
        try {
            payOrder = iPayOrderService.createOrder(goodsIds, user);
        } catch (Exception e) {
            return ExceptionConstantsUtils.printErrorMessage(log, e , "创建订单失败");
        }

        return ExceptionConstantsUtils.printSuccessMessage(log , "支付订单创建成功" , payOrder);
    }


}
