package com.books.entity.rule;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 商户开卡活动具体规则对象 pay_create_card_rule_detail
 * @author zye
 * @date 2020-06-20
 */
@Data
public class PayCreateCardRuleDetail {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private Integer id;

    /**
     * $column.columnComment
     */
    //(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer mid;

    /**
     * $column.columnComment
     */
    //(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer ruleId;

    /**
     * 会员卡id
     */
    //(name = "会员卡id")
    private String cardId;

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
    //(name = "现价")
    private BigDecimal exp;

    /**
     * 是否可用
     */
    //(name = "是否可用")
    private String isOpen;

    /**
     * $column.columnComment
     */
    //(name = "是否可用")
    private String des;

    /**
     * $column.columnComment
     */
    //(name = "是否可用")
    private Integer gradeId;

    /**
     * $column.columnComment
     */
    //(name = "是否可用")
    private String type;

    /**
     * $column.columnComment
     */
    //(name = "是否可用")
    private Integer couponCardId;

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
     * 修改后的夫级活动ID
     */
    private Integer pid;

    /**
     * 删除标记
     */
    private Integer isDel;

    /**
     * 活动名称
     */
    private String activityName;

}
