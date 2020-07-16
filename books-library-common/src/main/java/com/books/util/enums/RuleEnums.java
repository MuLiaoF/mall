package com.books.util.enums;

public enum  RuleEnums {

    /**  删除标识 **/
    IS_RENEW_FALSE("0", "不是续费会员"),
    IS_RENEW_TRUE("1", "是续费会员");

    private String code;
    private String codeMsg;

    private RuleEnums(String errorCode, String codeMsg) {
        this.code = errorCode;
        this.codeMsg = codeMsg;
    }

    public String getCode() {
        return this.code;
    }

    public String getCodeMsg() {
        return this.codeMsg;
    }

}
