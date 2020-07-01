package com.books.GoodsManage.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.books.entity.goodsInfo.GoodsInfoBean;

/**
* @author Zhao yongbing
* @version 创建时间：2020年7月1日 下午4:08:24
* @ClassName 类名称
* @Description 类描述
*/

public interface GoodsInfoMapper extends BaseMapper<GoodsInfoBean> {

	List<GoodsInfoBean> findGoodsInfoList(GoodsInfoBean goodsInfoBean);

}
