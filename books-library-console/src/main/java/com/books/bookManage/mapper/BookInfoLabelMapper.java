package com.books.bookManage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.books.entity.bookinfo.BookInfoBean;
import com.books.entity.bookinfo.BookInfoLabelBean;

/**
* @author Zhao yongbing
* @version 创建时间：2020年6月30日 下午10:23:51
* @ClassName 类名称
* @Description 类描述
*/

public interface BookInfoLabelMapper extends BaseMapper<BookInfoLabelBean>{

	/**
	 * 添加 图书-标签关系
	 * @param bookInfo
	 */
	void addBookInfoLabel(BookInfoBean bookInfo);

}
