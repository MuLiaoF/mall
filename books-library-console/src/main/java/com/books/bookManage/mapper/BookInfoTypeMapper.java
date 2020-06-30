package com.books.bookManage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.books.entity.bookinfo.BookInfoBean;
import com.books.entity.bookinfo.BookInfoTypeBean;

/**
* @author Zhao yongbing
* @version 创建时间：2020年6月30日 下午6:42:53
* @ClassName 类名称
* @Description 类描述
*/

public interface BookInfoTypeMapper extends BaseMapper<BookInfoTypeBean>{

	/**
	 * 插入图书-类型关系
	 * @param typeIds
	 * @param bookId
	 */
	void addBookInfoType(BookInfoBean bookInfo);

}
