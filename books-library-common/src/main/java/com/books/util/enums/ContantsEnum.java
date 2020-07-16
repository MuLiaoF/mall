package com.books.util.enums;

public enum  ContantsEnum {

    /**  删除标识 **/
    IS_DEL_FALSE("0", "未删除"),
    IS_DEL_TRUE("1", "删除");


    private String code;
    private String codeMsg;

    private ContantsEnum(String errorCode, String codeMsg) {
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
