package com.books.token.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Merchants implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * 商户mid
	 */
	private Integer mid;

	/**
	 * 商户行业类型 1-餐饮
	 */
	private String mtype;

	/**
	 * 商户名称
	 */
	private String mname;

	/**
	 * 电话
	 */
	private String mphone;

	/**
	 * 邮箱
	 */
	private String memail;

	/**
	 * 商户logo
	 */
	private String logo;

	/**
	 * 商户状态1-启用（显示，商户可用）2-关闭（显示，商户不可用）3-废弃（不显示，逻辑删除）
	 */
	private Integer status;

	/**
	 * 支付系统商户号
	 */
	private String thirdMid;

	/**
	 * 代理商ID
	 */
	private String agentId;

	/**
	 * 备用1
	 */
	private String reserve1;

	/**
	 * 备用2
	 */
	private String reserve2;

	/**
	 * 备用3
	 */
	private String reserve3;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	/** 更新时间 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;

//	private int mid;
//	private String mname;
//	private String maccount;
//	private String malias;
//	private String mpwd;
//	private String salt;
//	private String memail;
//	private String mphone;
//	private String wxName;
//	private String wxNumber;
//	private String logo;
//	private int status;
//	private int isSub;
//	private int isadmin;
//	private String thirdMid;
//	private int agentId;
//	private String parentId;
//	private String mtype;
//	private String sysAppId;
//	private String templetAppId;
//	private String reserve1;
//	private String reserve2;
//	private String reserve3;
//	private String reserve4;
//	private Timestamp create_time;
//	private Timestamp update_time;
//	private Integer fid;
//	private String pay_type;
//	private BigDecimal rate;
//	private String mpid;
//	private int open_mem;//是否开通会员卡功能
//	private String card_id;
//	//add by fjr 20170607
//	private String thirdMkey; //农商行的商户秘钥，方便查询调用支付接口
//	private String onechannel;//类型值为Y代表大客户为全渠道通道类型（注：支付都走同一个通道，所谓的全渠道通道即支付宝和微信都是这个通道下的，比如富友、农商行等）
//	private String url_wm0;//快速买单url
//	//add by ws 20180917
//	private String business_type;//商户行业类型。（餐饮零费率和企事业单位零费率不同，代理商计算费率使用）
//	//add by ws 19-03-29
//	private String isSpecialRate;
//	private String specialId;



}
