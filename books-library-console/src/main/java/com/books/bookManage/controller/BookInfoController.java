package com.books.bookManage.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.books.bookManage.service.IBookManageService;
import com.books.entity.bookinfo.BookInfoBean;
import com.books.util.base.ExceptionConstantsUtils;
import com.books.util.base.ResultData;

import lombok.extern.slf4j.Slf4j;

/**
* @author Zhao yongbing
* @version 创建时间：2020年6月29日 下午1:59:41
* @ClassName 类名称 BookInfoController
* @Description 类描述 图书信息上传接口
*/

@Controller
@RequestMapping("/bookInfoController")
@Slf4j
public class BookInfoController {

	
	@Autowired
	private IBookManageService service;
	// 获取文件路径
	@Value("upload_file_path_default_img")
	public String defaultImgUrl;
	@Value("upload_file_path_other_img")
	public String otherImgUrl;

	/**
	 * 
	 * @param bookInfo
	 * @param files 图片文件
	 * @param defaultFile 默认图片文件
	 */
	@RequestMapping("/uploadBookInfo")
	@ResponseBody
	public ResultData<String> uploadBookInfo(BookInfoBean bookInfo,MultipartFile[] files,MultipartFile defaultFile,HttpServletRequest req) {
		ResultData<String> result=null;
		try {
			result = service.uploadBookInfo(bookInfo,files,defaultFile);
		} catch (Exception e) {
			return ExceptionConstantsUtils.printErrorMessage(log, e ,"写入文件异常！！！");
		}
		return result;
		
	}
}
