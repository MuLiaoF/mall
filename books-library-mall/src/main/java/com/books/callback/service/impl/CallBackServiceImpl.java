package com.books.callback.service.impl;

import com.books.callback.service.CallBackService;
import com.books.order.service.IPayOrderService;
import com.books.request.pay.UpdateOrderReq;
import com.books.util.base.ExceptionConstantsUtils;
import com.books.util.base.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Slf4j
@Service
public class CallBackServiceImpl implements CallBackService {

    @Autowired
    private IPayOrderService payOrderService;

    @Override
    public ResultData updateOrder(Map<String, Object> param) {


        try {
            UpdateOrderReq updateOrderReq = new UpdateOrderReq();

            updateOrderReq.setOrderId(String.valueOf(param.get("terminal_trace")));

            updateOrderReq.setChannelOrderId(String.valueOf(param.get("channel_trade_no")));

            String returnCode = String.valueOf(param.get("return_code"));

            String resultCode = String.valueOf(param.get("result_code"));

            updateOrderReq.setSource(String.valueOf(param.get("return_msg")));
            updateOrderReq.setOutTradeNo(String.valueOf(param.get("out_trade_no")));
            updateOrderReq.setPayTime(new Date());
            if ("01".equals(returnCode)) {
                updateOrderReq.setResultStatus("1");
            }
            if ("01".equals(resultCode)) {
                updateOrderReq.setOrderStatus("1");
            } else {
                //未知
                updateOrderReq.setOrderStatus("3");
            }
            log.info("交易消息：" + String.valueOf(param.get("return_msg")));
            ResultData jsonResponse = payOrderService.editSaveStatus(updateOrderReq);
            return jsonResponse;
        } catch (RuntimeException e) {
            log.error("update order pay status error", e);
            return ExceptionConstantsUtils.printErrorMessage(log, e, "更新订单失败");
        }

    }


}
