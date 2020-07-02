package com.books.GoodsManage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.books.GoodsManage.service.IGoodsManageService;
import com.books.entity.goodsInfo.GoodsInfoBean;
import com.books.entity.goodsInfo.GoodsStockNumberBean;
import com.books.util.base.ConstantUtils;
import com.books.util.base.ExceptionConstantsUtils;
import com.books.util.base.ResultData;
import com.github.pagehelper.PageInfo;

import lombok.extern.slf4j.Slf4j;

/**
* @author Zhao yongbing
* @version 创建时间：2020年7月1日 下午3:13:56
* @ClassName 类名称 GoodsManageController
* @Description 类描述  商品管理Controller
*/
@Controller
@RequestMapping("/goodsManageController")
@Slf4j
public class GoodsManageController {

	@Autowired
	private IGoodsManageService service;

	/**
	 * 查询商品信息
	 * @param pageNum 
	 * @param pageSize
	 * @param goodsInfoBean
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/findGoodsInfoList", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<PageInfo<GoodsInfoBean>> addOrupdateGoodsInfo(
			@RequestParam(required = false,defaultValue = "1")Integer pageNum,
			@RequestParam(required = false,defaultValue = "20")Integer pageSize,
			GoodsInfoBean goodsInfoBean,HttpServletRequest req) {
		ResultData<PageInfo<GoodsInfoBean>> result=null;
		try {
			result = service.findGoodsInfoList(goodsInfoBean, pageNum, pageSize);
		} catch (Exception e) {
			return ExceptionConstantsUtils.printErrorMessage(log, e, "商品查询失败！");
		}
		return result;
		
	} 
	/**
	 * 添加/修改/删除商品
	 * @param goodsInfoBean
	 * @param goodsStockNumberBean
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/addOrupdateGoodsInfo", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<String> addOrupdateGoodsInfo(GoodsInfoBean goodsInfoBean,GoodsStockNumberBean goodsStockNumberBean,HttpServletRequest req) {
		ResultData<String> result=null;
		try {
			result = service.addOrupdateGoodsInfo(goodsInfoBean,goodsStockNumberBean);
		} catch (Exception e) {
			return ExceptionConstantsUtils.printErrorMessage(log,e,"商品编辑失败！");
		}
		return result;
		
	} 
	
	/**
	 * 上架/下架商品
	 * @param goodsInfoBean
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/putOrOffGoods", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<String> putOrOffGoods(GoodsInfoBean goodsInfoBean,HttpServletRequest req) {
		ResultData<String> result=null;
		try {
			result = service.putOrOffGoods(goodsInfoBean);
		} catch (Exception e) {
			if(ConstantUtils.isPut.equals(goodsInfoBean.getIsOff())) {
				ExceptionConstantsUtils.printErrorMessage(log,e,"商品上架失败！");
			}else {
				ExceptionConstantsUtils.printErrorMessage(log,e,"商品下架失败！");
			}
		}
		return result;
		
	} 
}
