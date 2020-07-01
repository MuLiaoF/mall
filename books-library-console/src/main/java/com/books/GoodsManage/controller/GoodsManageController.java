package com.books.GoodsManage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.books.GoodsManage.service.IGoodsManageService;
import com.books.entity.goodsInfo.GoodsInfoBean;
import com.books.entity.goodsInfo.GoodsStockNumberBean;
import com.books.util.base.ConstantUtils;
import com.books.util.base.ExceptionConstantsUtils;
import com.books.util.base.ResultData;

/**
* @author Zhao yongbing
* @version 创建时间：2020年7月1日 下午3:13:56
* @ClassName 类名称 GoodsManageController
* @Description 类描述  商品管理Controller
*/
@Controller
@RequestMapping("/goodsManageController")
public class GoodsManageController {

	@Autowired
	private IGoodsManageService service;
	
	private static final  Logger log = LogManager.getLogger(GoodsManageController.class);
	
	
	/**
	 * 查询商品信息
	 * @param goodsInfoBean
	 * @param goodsStockNumberBean
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/findGoodsInfoList", method = RequestMethod.POST)
	@ResponseBody
	public ResultData<List<GoodsInfoBean>> addOrupdateGoodsInfo(GoodsInfoBean goodsInfoBean,HttpServletRequest req) {
		ResultData<List<GoodsInfoBean>> result=null;
		try {
			result = service.findGoodsInfoList(goodsInfoBean);
		} catch (Exception e) {
			result.setCode(ConstantUtils.ERROR_CODE);
			result.setSuccess(ConstantUtils.ERROR_MESSAGE);
			result.setMsg("商品查询失败！");
			log.info(ExceptionConstantsUtils.printErrorMessage(log,e,"商品查询失败！"));
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
			result.setCode(ConstantUtils.ERROR_CODE);
			result.setSuccess(ConstantUtils.ERROR_MESSAGE);
			result.setMsg("商品编辑失败！");
			log.info(ExceptionConstantsUtils.printErrorMessage(log,e,"商品编辑失败！"));
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
			result.setCode(ConstantUtils.ERROR_CODE);
			result.setSuccess(ConstantUtils.ERROR_MESSAGE);
			if(ConstantUtils.isPut.equals(goodsInfoBean.getIsOff())) {
				result.setMsg("商品上架失败!");
				log.info(ExceptionConstantsUtils.printErrorMessage(log,e,"商品上架失败！"));
			}else {
				result.setMsg("商品下架失败!");
				log.info(ExceptionConstantsUtils.printErrorMessage(log,e,"商品下架失败！"));
			}
			
		}
		return result;
		
	} 
}
