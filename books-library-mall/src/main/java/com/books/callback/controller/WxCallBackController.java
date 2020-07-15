package com.books.callback.controller;

import com.alibaba.fastjson.JSONObject;
import com.books.callback.service.CallBackService;
import com.books.order.mapper.PayOrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * @param jsonObject 微信返回参数
     */
    @RequestMapping("/v1/notice")
    public void callback(@RequestBody JSONObject jsonObject) {

        jsonObject.getJSONObject("");

    }


}
