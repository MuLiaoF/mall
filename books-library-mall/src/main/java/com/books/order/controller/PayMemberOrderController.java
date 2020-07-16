package com.books.order.controller;

import com.books.entity.order.entity.PayMemOrder;
import com.books.order.service.PayMemberOrderService;
import com.books.pay.mapper.PayMemOrderMapper;
import com.books.request.member.PayMemberOrderReq;
import com.books.util.base.ExceptionConstantsUtils;
import com.books.util.base.ResultData;
import com.books.util.token.TokenEntity;
import com.books.util.token.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@Slf4j
@RequestMapping("/pay")
public class PayMemberOrderController {

    @Autowired
    private PayMemberOrderService payMemberOrderService;


    @PostMapping("/v1/member/order/pre")
    public ResultData payMemOrder(@RequestBody PayMemberOrderReq payMemberOrderReq, HttpServletRequest request) {
        TokenEntity sessionUser = TokenUtil.getSessionUser(request);
        Integer id = sessionUser.getId();
        Integer goodsId = payMemberOrderReq.getGoodsId();
        PayMemOrder payMemOrder = null;
        try {
            payMemOrder = payMemberOrderService.createMemeberOrder(id ,goodsId);
        } catch (Exception e) {
            return ExceptionConstantsUtils.printErrorMessage(log, e , "创建订单异常");
        }

        return ExceptionConstantsUtils.printSuccessMessage(log, "创建订单成功", payMemOrder);
    }


}
