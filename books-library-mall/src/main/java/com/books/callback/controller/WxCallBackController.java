package com.books.callback.controller;

import com.alibaba.fastjson.JSONObject;
import com.books.callback.service.CallBackService;
import com.books.order.mapper.PayOrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/callbock")
public class WxCallBackController {

    @Autowired
    private PayOrderMapper payOrderMapper;

    @Autowired
    private CallBackService callBackService;

    /**
     * 微信回调通知
     * @param param 微信返回参数
     */
    @RequestMapping("/v1/notice")
    public Map<String, Object> callback(@RequestBody Map<String, Object> param) {

        log.info("update order status start ... param : " + param.toString());
        Map<String, Object> success = new HashMap<>(8);
        try {
            if ("01".equals(param.get("return_code"))) {
                log.info("订单回调成功 success");
            } else if ("02".equals(param.get("return_code"))) {
                log.error(param.get("return_msg").toString());
            } else {
                log.error("unknow error >>>>>");
                success.put("return_code", "02");
                success.put("return_msg", "unknow error");
                return success;
            }
            callBackService.updateOrder(param);
            log.error("update order finish ...");
            success.put("return_code", "01");
            return success;
        } catch (Exception e) {
            log.error("errors in update order or create card ", e);
            success.put("return_code", "02");
            success.put("return_msg", "errors in update order or create card");
            return success;

        }
    }


}
