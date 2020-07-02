package com.books.GoodsManage.service;

import com.books.entity.goodsInfo.GoodsInfoBean;
import com.books.entity.goodsInfo.GoodsStockNumberBean;
import com.books.util.base.ResultData;
import com.github.pagehelper.PageInfo;

/**
* @author Zhao yongbing
* @version 创建时间：2020年7月1日 下午3:15:27
* @ClassName 类名称
* @Description 类描述
*/

public interface IGoodsManageService {

	/**
	 * 添加/修改商品
	 * @param goodsInfoBean
	 * @param goodsStockNumberBean 
	 * @return
	 */
	ResultData<String> addOrupdateGoodsInfo(GoodsInfoBean goodsInfoBean, GoodsStockNumberBean goodsStockNumberBean) throws Exception;

	/**
	 * 下架/上架商品
	 * @param goodsInfoBean
	 * @return
	 */
	ResultData<String> putOrOffGoods(GoodsInfoBean goodsInfoBean) throws Exception;

	/**
	 * 查询商品信息
	 * @param goodsInfoBean
	 * @param pageSize 
	 * @param pageNum 
	 * @return
	 */
	ResultData<PageInfo<GoodsInfoBean>> findGoodsInfoList(GoodsInfoBean goodsInfoBean, Integer pageNum, Integer pageSize);


}
