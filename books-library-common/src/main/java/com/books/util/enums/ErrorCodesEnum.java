package com.books.util.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * 异常枚举类
 * @author baijiao 20200606
 */
public enum ErrorCodesEnum {
    /************操作成功**************/
    SUCCESS_CODE(200, "操作成功"),

    /************系统类错误码**************/
    ERROR_CODE_SERVER_ERROR(20001, "服务器内部错误，请联系管理员"),
    ERROR_CODE_REQUEST_MORE(20002, "请求太频繁"),
    ERROR_CODE_NO_SERVICE_ERROR(20003, "没有找到微服务，请检查微服务状态"),
    ERROR_CODE_API_ERROR(20004, "微服务之间调用异常"),
    ERROR_SMS_SEND_ERROR(20005, "短信发送异常"),
    ERROR_CODE_SAVE_ERROR(20006, "保存失败"),
    ERROR_CODE_DELETE_ERROR(20007, "删除失败"),
    ERROR_CODE_UPDATE_ERROR(20008, "更新失败"),
    ERROR_CODE_QUERY_ERROR(20009, "查询失败"),
    ERROR_CODE_THIRD_REQUEST_NULL_ERROR(20010, "第三方返回结果为空"),
    ERROR_CODE_DATA_NULL(20011, "请求资源不存在"),

    /************鉴权类错误码**************/
    ERROR_CODE_AUTH_ERROR(20015, "鉴权失败"),
    ERROR_MID_NOT_HOST(20013, "商户ID为空"),
    ERROR_TOKEN_AUTH_ERROR(20014, "Token验证非法异常"),
    ERROR_CODE_NO_AUTH(20016, "没有找到鉴权信息，可能没有进行过鉴权"),
    ERROR_CODE_NO_ACCESS_AUTH(20017, "权限不足，检查自己的权限配置"),
    ERROR_CODE_NOT_HOST(20018, "用户ID为空"),
    ERROR_CODE_AUTH_ERROR_TIMES_ERROR(20019, "登录错误次数过多，请10分钟后再试"),

    ERROR_CODE_AUTH_ERROR_SERVICE(70000,"会员服务不可用"),
    /**
     * 参数校验异常
     */
    ERROR_CODE_HEADER_ERROR(20021,"header参数不足，缺少必要的header内容"),
    ERROR_CODE_PARAM_NULL(20022,"参数不足，有些必传参数没有传入"),
    ERROR_CODE_PARAM_INVALID(20023,"参数不合法，请检查参数格式"),
    ERROR_CODE_PARAM_EQUAL(20024,"参数长度错误"),
    ERROR_CODE_PARAM_MAX(20025,"参数超长"),
    ERROR_CODE_PARAM_MIN(20026,"参数太短"),
    ERROR_CODE_PARAM_SPECIAL(20027,"参数包含特殊字符"),
    ERROR_CODE_PARAM_CHINESE(20028,"参数包含中文"),
    ERROR_CODE_PARAM_EMAIL(20029,"邮箱地址错误"),
    ERROR_CODE_PARAM_IP(20030,"IP格式错误"),
    ERROR_CODE_PARAM_NUMBER(20031,"数字格式错误"),
    ERROR_CODE_PARAM_PHONE(20032,"电话号码格式错误"),
    ERROR_CODE_PARAM_DATE(20133,"出生日期格式错误"),
    ERROR_CODE_PARAM_URL(20034,"URL格式错误"),
    ERROR_CODE_PARAM_BIRTHDAY(20035,"出生日期格式错误"),
    ERROR_CODE_PARAM_SEX(20036,"性别格式错误"),
    ERROR_CODE_PARAM_PASSWD(20037,"密码错误"),

    ERROR_TYPE_PARAM_PLATFORM(20038,"登录平台不能为空"),
    ERROR_TYPE_PARAM_USER(20039,"用户类型不能为空"),


    ERROR_CODE_PARAM_USER(20040,"用户不存在"),
    ERROR_CODE_PARAM_USER_STOP(20041,"该用户已经被停用"),

    /**
     * 会员业务异常
     */
    MEMBER_SERVICE_ERROR(30000, "会员服务异常"),
    MEMBER_RECEIVE_ERROR(30001, "该会员信息不存在"),
    MEMBER_NOT_UNCLAIMED_ERROR(30002, "待领取会员卡不存在"),
    MEMBER_HAVE_TO_RECEIVE_ERROR(30003, "已是会员不能重复申请"),
    MERCHANT_EXIST_AVALIABLE_CARD(30004, "商户已有可用会员卡"),
    MERCHANT_CARD_PARAM_ERROR(30005, "会员卡类型参数有误"),
    MERCHANT_CARD_STOCK_EXHAUST(30006, "该种会员卡无库存"),

    MERBER_CARD_TYPE_NULL(30007, "会员卡类型不能为空"),
    MERCHANT_NAME_NULL(30008, "商户名称不能为空"),
    MERBER_CARD_NAME_NULL(30009, "会员卡名称不能为空"),
    MERBER_OPR_NOTICE_NULL(30010, "操作提示不能为空"),
    MERBER_CARD_QUANTITY_EMPTY(30011, "会员卡库存不能为空"),
    MERBER_CARD_DISCOUNT_ERROR(30012, "输入的折扣有误"),
    MERBER_FANS_NULL_ERROR(30012, "该粉丝信息不存在"),

    //add by jh 2020-06-17
    MERBER_TOKEN_NULL_ERROR(30015, "该商户的token信息不存在"),
    MERBER_FAIL_CARD_ERROR(30016, "上传微信会员卡失败"),
    MERBER_CODE_CARD_ERROR(30017, "批量导入会员号失败"),
    MERBER_STOCK_CARD_ERROR(30018, "更新库存失败"),
    MERBER_NOT_EXIST(30019, "未查到会员信息"),

    /**
     * 支付业务异常
     */
    PAY_SERVICE_ERROR(40001, "支付服务异常"),
    PAY_FEE_ERROR(40002, "输入金额必须大于0"),
    PAY_WAY_NOT_EXIST(40003, "请求类型无效"),
    PAY_MDCODE_MEMBER_ERROR(40005, "会员支付码对应会员不存在"),
    PAY_MEMCODE_PAYCODE_NOT_PAIR(40006, "会员付款码与输入会员卡号不一致"),
    PAY_MEMBER_MICROPAY_FAIL(40007, "会员付款码支付失败"),
    PAY_WD_SYSTEM_FAIL(40008, "调万鼎支付系统支付失败"),
    PAY_CASH_FAIL(40009, "现金支付失败"),
    PAY_TRANSACTION_FAILURES_ERROR(40007, "支付交易失败"),
    PAY_MDCODE_INVALID(40008, "会员支付码无效"),

    /**
     * 卡卷业务异常
     */
    CARD_SERVICE_ERROR(50001, "支付服务异常"),

    /**
     * 后台系统业务异常
     */
    SYSTEM_SERVICE_ERROR(60001, "后台系统服务异常");

    private int errorCode = 200;
    private String errorMsg = "";

    private ErrorCodesEnum(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    private static List<ErrorCodesEnum> scenceList = new ArrayList<ErrorCodesEnum>();

    static {
        ErrorCodesEnum[] values = ErrorCodesEnum.values();
        for (ErrorCodesEnum scence : values) {
            scenceList.add(scence);
        }
    }

    public static List<ErrorCodesEnum> getAllRateCode() {
        return scenceList;
    }

    //add by wangsen
    public static ErrorCodesEnum getValueByErrorCodes(Integer errorCode) {
        ErrorCodesEnum resutl = null;
        for(ErrorCodesEnum key:scenceList){
            /*if(key.getErrorCode().equals(errorCode)){
        for(ErrorCodesEnum key:scenceList){
            if(key.getErrorCode().equals(errorCode)){
        for (ErrorCodesEnum key : scenceList) {
            if (key.getErrorCode() == errorCode) {
                resutl = key;
                break;
            }*/
        }
        return resutl;
    }

}
