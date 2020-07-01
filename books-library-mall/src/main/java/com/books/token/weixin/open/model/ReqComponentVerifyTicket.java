package com.books.token.weixin.open.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 
 * @author liaoxiang
 * @date 2018/05/08
 * @see https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&id=open1453779503&token=&lang=zh_CN
 */
@Data
@AllArgsConstructor
public class ReqComponentVerifyTicket {

	/**
	 * 第三方平台appid
	 */
	private String AppId;

	/**
	 * 时间戳
	 */
	private String CreateTime;

	/**
	 * component_verify_ticket
	 */
	private String InfoType;

	/**
	 * Ticket内容
	 */
	private String ComponentVerifyTicket;

}
