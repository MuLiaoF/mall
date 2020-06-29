package com.books.util.base;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;

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
    @SuppressWarnings("rawtypes")
	public static ResultData printErrorMessage(Logger log, String code, String printMsg) {
        log.info(printMsg);
        return ConstantUtils.printMessage(code, ConstantUtils.ERROR_MESSAGE, printMsg,null);
    }


    /**
     * 打印错误信息
     * @param log
     * @param e
     */
    @SuppressWarnings("rawtypes")
	public static ResultData printErrorMessage(Logger log, Exception e, String printMsg) {
        String message = ExceptionUtils.getStackTrace(e);
        log.info(printMsg);
        log.info(message);
        if(printMsg == null) {
            return ConstantUtils.printErrorMessage();
        }
        return ConstantUtils.printErrorMessage(printMsg);
    }

    @SuppressWarnings("rawtypes")
	public static ResultData printErrorMessage(Logger log, String printMsg) {
        log.info(printMsg);
        if(printMsg == null) {
            return ConstantUtils.printErrorMessage();
        }
        return ConstantUtils.printErrorMessage(printMsg);
    }

    @SuppressWarnings("rawtypes")
	public static ResultData printSuccessMessage(Logger log, String printMsg) {
        log.info(printMsg);
        if(printMsg == null) {
            return ConstantUtils.printErrorMessage();
        }
        return ConstantUtils.printSuccessMessage(printMsg, null);
    }

    @SuppressWarnings("rawtypes")
	public static <T> ResultData printSuccessMessage(Logger log, String printMsg , T data) {
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
