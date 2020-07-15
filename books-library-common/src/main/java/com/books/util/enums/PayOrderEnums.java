package com.books.util.enums;


public enum  PayOrderEnums {

    /** 订单最终状态 **/
    RESULT_STATUS_ERROR("2", "支付成功"),
    RESULT_STATUS_SUCCESS("1", "支付失败"),

    /** 正向订单反向订单 **/
    ORDER_TYPE_PAY_FORWARD("0", "正向订单"),
    ORDER_TYPE_REFUND_FORWARD("1", "正向订单"),

    /** 交易状态 **/
    ORDER_STATUS_TRADING("3", "交易中"),
    ORDER_STATUS_ERROR("2", "交易失败"),
    ORDER_STATUS_SUCCESS("1", "交易成功"),
    ORDER_STATUS_PRE("0", "待交易"),

    REFUND_STATUS_NOT("0", "未退款"),
    REFUND_STATUS_PART("1", "部分退款"),
    REFUND_STATUS_FULL("2", "全额退款");

    private String code;
    private String codeMsg;


    private PayOrderEnums(String code, String codeMsg) {
        this.code = code;
        this.codeMsg = codeMsg;
    }

    public String getCode() {
        return code;
    }

    public String getCodeMsg() {
        return codeMsg;
    }
}
