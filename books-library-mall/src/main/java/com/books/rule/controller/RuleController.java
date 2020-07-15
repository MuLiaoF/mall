package com.books.rule.controller;

import com.books.response.rule.CardRuleSelRsp;
import com.books.rule.service.IRuleService;
import com.books.util.base.ExceptionConstantsUtils;
import com.books.util.base.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author feng
 * @version 1.0
 * @date 2020/7/15 16:24
 */
@RestController
@RequestMapping("/rule")
@Slf4j
public class RuleController {

    @Autowired
    private IRuleService ruleService;


    /**
     * 查询会员商品列表
     * @return
     */
    @GetMapping("/v1/mem/goods/list")
    public ResultData memberGoodsList() {
        List<CardRuleSelRsp> cardRuleSelRsp = null;
        try {
            cardRuleSelRsp = ruleService.getMemberGoodsList();
        } catch (Exception e) {
            return ExceptionConstantsUtils.printErrorMessage(log, e,"获取付费列表异常");
        }
        return ExceptionConstantsUtils.printSuccessMessage(log, "获取付费列表异常", cardRuleSelRsp);
    }

}
