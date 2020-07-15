package com.books.entity.rule;

import lombok.Data;

import java.util.Date;

/**
 * 商户开卡活动对象 pay_create_card_rule
 * @author zye
 * @date 2020-06-20
 */
@Data
public class PayCreateCardRule {
    private static final long serialVersionUID = 1L;

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
     * 会员卡cardid
     */
    //(name = "会员卡cardid")
    private String cardId;

    /**
     * 开卡规则（免费，付费）
     */
    //(name = "开卡规则", readConverterExp = "免=费，付费")
    private String type;

    /**
     * 商户id
     */
    //(name = "商户id")
    private Integer mid;

    /**
     * 门店i都
     */
    //(name = "门店i都")
    private Integer sid;

    /**
     * 状态：
     */
    //(name = "状态：")
    private String status;

    /**
     * 是否续费会员 0否   1是
     */
    //(name = "是否续费会员 0否   1是")
    private String isRenew;

    /**
     * 是否删除 0 未删除 1 删除
     */
    //(name = "是否删除 0 未删除 1 删除")
    private String isDel;

    /**
     * 生效时间
     */
    //(name = "生效时间", width = 30, dateFormat = "yyyy-MM-dd")

    private Date beginTime;

    /**
     * 结束时间
     */
    //(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /**
     * 备用字段1
     */
    //(name = "备用字段1")
    private String reserve1;

    /**
     * 备用字段2
     */
    //(name = "备用字段2")
    private String reserve2;


    /**
     * 创建时间
     */
    private Date createTime;
}
