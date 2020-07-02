package com.books.GoodsManage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.books.GoodsManage.mapper.GoodsInfoMapper;
import com.books.GoodsManage.mapper.GoodsStockNumberMapper;
import com.books.GoodsManage.service.IGoodsManageService;
import com.books.entity.goodsInfo.GoodsInfoBean;
import com.books.entity.goodsInfo.GoodsStockNumberBean;
import com.books.util.base.ConstantUtils;
import com.books.util.base.ExceptionConstantsUtils;
import com.books.util.base.ResultData;

import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;

/**
* @author Zhao yongbing
* @version 创建时间：2020年7月1日 下午3:16:03
* @ClassName 类名称
* @Description 类描述
*/
@Service
@Slf4j
public class GoodsManageServiceImpl implements IGoodsManageService {

	@Autowired
	private GoodsInfoMapper goodsInfoMapper;
	@Autowired
	private GoodsStockNumberMapper goodsStockNumberMapper;
	
	@Transactional
	@Override
	public ResultData<String> addOrupdateGoodsInfo(GoodsInfoBean goodsInfoBean,GoodsStockNumberBean goodsStockNumberBean) throws Exception{
		
		String printMsg = "";
		
		// 修改
		if(goodsInfoBean.getId() != null) {
			goodsInfoMapper.updateById(goodsInfoBean);
			goodsStockNumberBean.setGoodsId(goodsInfoBean.getId());
			if(goodsStockNumberBean.getStockNumber() == null) {
				// 删除
				goodsStockNumberBean.setIsdel(ConstantUtils.isDel);
			}
			goodsStockNumberMapper.updateById(goodsStockNumberBean);  // 保存库存数
			printMsg = "商品修改成功!";
		}else {
			// 新增
			goodsInfoBean.setIsdel(ConstantUtils.isNotDel);
			if(ConstantUtils.isPut.equals(goodsInfoBean.getIsOff())) {
				goodsInfoBean.setIsOff(ConstantUtils.isPut);   // 快速上架
				goodsInfoBean.setPutDate(DateUtil.date());
			}else {
				goodsInfoBean.setIsOff(ConstantUtils.isOff);   // 下架
			}
			
			goodsInfoMapper.insert(goodsInfoBean);
			goodsStockNumberBean.setGoodsId(goodsInfoBean.getId());
			goodsStockNumberBean.setIsdel(ConstantUtils.isNotDel);
			goodsStockNumberMapper.insert(goodsStockNumberBean);  // 保存库存数
			
			printMsg = "商品添加成功!!";
		}
		return ExceptionConstantsUtils.printSuccessMessage(log, printMsg);
	}

	
	@Override
	public ResultData<String> putOrOffGoods(GoodsInfoBean goodsInfoBean) throws Exception {
		String printMsg = "";
		if(ConstantUtils.isPut.equals(goodsInfoBean.getIsOff())) {
			goodsInfoBean.setOffDate(DateUtil.date());
			goodsInfoBean.setIsOff(null);
			printMsg = "商品上架成功!";
		}else {
			goodsInfoBean.setOffDate(DateUtil.date());
			printMsg = "商品下架成功!";
		}
		goodsInfoMapper.updateById(goodsInfoBean);
		
		return ExceptionConstantsUtils.printSuccessMessage(log, printMsg);
	}


	@Override
	public ResultData<List<GoodsInfoBean>> findGoodsInfoList(GoodsInfoBean goodsInfoBean) {
		
		List<GoodsInfoBean> list  = goodsInfoMapper.findGoodsInfoList(goodsInfoBean);
		
		return ExceptionConstantsUtils.printSuccessMessage(log,"商品查询成功", list);
	}

}
