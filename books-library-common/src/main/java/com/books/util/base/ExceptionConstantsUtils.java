package com.books.util.base;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;

/**
* @author Zhao yongbing
* @version 创建时间：2020年6月29日 下午1:59:41
* @ClassName 类名称 ExceptionConstantsUtils
* @Description 类描述 统一异常工具类
*/

public class ExceptionConstantsUtils {

    /**
      * 打印错误信息
     * @param log
     * @param e
     */
	public static <T> ResultData<T> printErrorMessage(Logger log, Integer code, String printMsg) {
        log.info(printMsg);
        return ConstantUtils.printMessage(code, ConstantUtils.ERROR_MESSAGE, printMsg,null);
    }


    /**
     * 打印错误信息
     * @param log
     * @param e
     */
	public static <T> ResultData<T> printErrorMessage(Logger log, Exception e, String printMsg) {
        String message = ExceptionUtils.getStackTrace(e);
        log.info(printMsg);
        log.info(message);
        if(printMsg == null) {
            return ConstantUtils.printErrorMessage();
        }
        return ConstantUtils.printErrorMessage(printMsg);
    }

	public static <T> ResultData<T> printErrorMessage(Logger log, String printMsg) {
        log.info(printMsg);
        if(printMsg == null) {
            return ConstantUtils.printErrorMessage();
        }
        return ConstantUtils.printErrorMessage(printMsg);
    }

	public static <T> ResultData<T> printSuccessMessage(Logger log, String printMsg) {
        log.info(printMsg);
        if(printMsg == null) {
            return ConstantUtils.printErrorMessage();
        }
        return ConstantUtils.printSuccessMessage(printMsg, null);
    }

	public static <T> ResultData<T> printSuccessMessage(Logger log, String printMsg , T data) {
        log.info(printMsg);
        if(printMsg == null) {
            return ConstantUtils.printErrorMessage();
        }
        return ConstantUtils.printSuccessMessage(printMsg, data);
    }

    /**
     * 打印错误信息
     * @param log
     * @param e
     */
    public static void printSysErrorMessage(Logger log, Exception e, String printMsg) {
        String message = ExceptionUtils.getStackTrace(e);
        log.info(message);
        log.info(printMsg);
    }

    /**
      * 打印错误信息
     * @param log
     * @param printMsg
     */
    public static void printSysErrorMessage(Logger log, String printMsg) {
        log.info(printMsg);
        log.info(printMsg);
    }

}
