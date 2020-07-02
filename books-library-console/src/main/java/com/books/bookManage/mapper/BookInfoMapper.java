package com.books.bookManage.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.books.entity.bookinfo.BookInfoBean;
import com.books.entity.booktype.BookTypeBean;

/**
* @author Zhao yongbing
* @version 创建时间：2020年6月29日 下午8:38:08
* @ClassName 类名称
* @Description 类描述
*/


public interface BookInfoMapper  extends BaseMapper<BookInfoBean>{

	/**
	 * 查询图书信息list
	 * @param bookInfo
	 * @return
	 */
	List<BookInfoBean> findBookInfoList(BookInfoBean bookInfo);
	
	List<BookTypeBean> getBookTypeById(Integer id);
	
}
