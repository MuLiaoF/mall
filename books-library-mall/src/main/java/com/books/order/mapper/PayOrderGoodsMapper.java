package com.books.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.books.entity.order.entity.PayOrderGoods;

import java.util.List;

public interface PayOrderGoodsMapper extends BaseMapper<PayOrderGoods> {


    int insertBatch(List<PayOrderGoods> payOrderGoods);


}
