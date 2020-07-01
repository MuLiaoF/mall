package com.books.util.exception;


import com.books.util.enums.ErrorCodesEnum;

public class BussinessException extends RuntimeException{

	public static final String SocketTimeout ="SocketTimeoutException";
	public static final String NoHttpResponse ="NoHttpResponseException";

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private   Integer  errorCode;
	private   String  errorMsg;

	public BussinessException(int errorCode, String errorMsg) {
		 super((errorMsg == null ? "异常" : errorMsg.toString()));
		 this.errorCode = errorCode;
		 this.errorMsg = errorMsg;
	}
	public BussinessException(int errorCode) {
		 this.errorCode = errorCode;
	}

	public  int getErrorcode() {
		return errorCode;
	}

	public String getErrorMsg() {

		if(0 != errorCode) {

			if(errorMsg != null) {
				return errorMsg;
			}

			for (ErrorCodesEnum errorCodesEnum: ErrorCodesEnum.values()){
				if (errorCodesEnum.getErrorCode() == errorCode){
					return errorCodesEnum.getErrorMsg();
				}
			}
		}

		return errorMsg;
	}
}
