package com.books.response.rule;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author feng
 */
@Data
public class CardRuleSelRsp {


    /**
     * 主键(商户会员卡开卡规则表)
     */
    private Integer id;

    /**
     * 规则名称
     */
    //(name = "规则名称")
    private String ruleName;


    /**
     * 开卡规则（免费，付费）
     */
    //(name = "开卡规则", readConverterExp = "免=费，付费")
    private String type;

    /**
     * 原价
     */
    //(name = "原价")
    private BigDecimal costPrice;

    /**
     * 现价
     */
    //(name = "现价")
    private BigDecimal nowPrice;


    /**
     * $column.columnComment
     */
    //(name = "是否可用")
    private String bonus;

    /**
     * $column.columnComment
     */
    //(name = "是否可用")
    private String balance;


    /**
     * 活动名称
     */
    private String activityName;


    /**
     * 活动ID
     */
    private Integer activityId;
}
