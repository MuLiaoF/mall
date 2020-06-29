package com.books.bookManage.service;

import org.springframework.web.multipart.MultipartFile;

import com.books.entity.bookinfo.BookInfoBean;
import com.books.util.base.ResultData;

/**
* @author Zhao yongbing
* @version 创建时间：2020年6月29日 下午1:59:08
* @ClassName 类名称
* @Description 类描述
*/

public interface IBookManageService {

	/**
	 * 上传图书信息
	 * @param bookInfo
	 * @param files
	 * @param defaultFile
	 * @return
	 */
	ResultData<String> uploadBookInfo(BookInfoBean bookInfo, MultipartFile[] files, MultipartFile defaultFile) throws Exception;

}
