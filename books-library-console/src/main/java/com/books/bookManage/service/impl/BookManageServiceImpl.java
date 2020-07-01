package com.books.bookManage.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.books.bookManage.mapper.BookInfoLabelMapper;
import com.books.bookManage.mapper.BookInfoMapper;
import com.books.bookManage.mapper.BookInfoTypeMapper;
import com.books.bookManage.service.IBookManageService;
import com.books.entity.bookinfo.BookInfoBean;
import com.books.util.base.ConstantUtils;
import com.books.util.base.ResultData;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSONUtil;

/**
* @author Zhao yongbing
* @version 创建时间：2020年6月29日 下午1:59:41
* @ClassName 类名称
* @Description 类描述
*/

@Service
@Slf4j
public class BookManageServiceImpl implements IBookManageService{

	@Autowired
	private BookInfoMapper mapper;
	@Autowired
	private BookInfoTypeMapper bookInfoTypeMapper;
	@Autowired
	private BookInfoLabelMapper bookInfoLabelMapper;
	
	// 获取文件路径
	@Value("${upload_file_path_default_img}")
	private String defaultImgUrl;
	@Value("${upload_file_path_other_img}")
	private String otherImgUrl;
	
	@Transactional
	@Override
	public ResultData<String> uploadBookInfo(BookInfoBean bookInfo, MultipartFile[] files, MultipartFile defaultFile) throws Exception {
		ResultData<String> result =new ResultData<String>();
		HashMap<String,List<String>> otherImagMap = new HashMap<String,List<String>>();
		List<String> list = new ArrayList<String>();
		// 判断文件是否为空，空则返回失败页面
		if (files.length <= 0 || defaultFile == null) {
			result.setCode(ConstantUtils.ERROR_CODE);
			result.setSuccess(ConstantUtils.ERROR_MESSAGE);
			result.setMsg("文件为空，请重新上传");
			return result;
		}
		for (MultipartFile file : files) {
			// 获取文件存储路径（绝对路径）
			String otherPath = otherImgUrl;
			// 获取原文件名
			String fileOrgName = file.getOriginalFilename();
			String fileName = fileOrgName.split("\\.")[0];
			String extName = FileUtil.extName(fileOrgName); // 获取扩展名
			// 新文件名
			String newFileName = fileName+DateUtil.format(new Date(), "YYYYMMddhhmmss")+"."+extName;
			// 创建文件实例
			File filePath = new File(otherPath, newFileName);
			// 如果文件目录不存在，创建目录
			if (!filePath.getParentFile().exists()) {
				filePath.getParentFile().mkdirs();
				System.out.println("创建目录" + filePath);
			}
			// 写入文件
			file.transferTo(filePath);
			list.add(filePath.getPath());
		}
		otherImagMap.put("otherImgUrl", list);
		
		// 默认图片
		// 获取文件存储路径（绝对路径）
		String defaultPath = defaultImgUrl;
		// 获取原文件名
		String fileOrgName = defaultFile.getOriginalFilename();
		String fileName = fileOrgName.split("\\.")[0];
		String extName = FileUtil.extName(fileOrgName); // 获取扩展名
		// 新文件名
		String newFileName = fileName+DateUtil.format(new Date(), "YYYYMMddhhmmss")+"."+extName;
		// 创建文件实例
		File filePath = new File(defaultPath, newFileName);
		// 如果文件目录不存在，创建目录
		if (!filePath.getParentFile().exists()) {
			filePath.getParentFile().mkdirs();
			System.out.println("创建目录" + filePath);
		}
		// 写入文件
		defaultFile.transferTo(filePath);
		defaultImgUrl=filePath.getPath();
		
		bookInfo.setCreateTime(DateUtil.date());
		bookInfo.setImgUrlJson(JSONUtil.parseFromMap(otherImagMap).toString());
		bookInfo.setDefaultImgUrl(JSONUtil.toJsonStr(defaultImgUrl));
		bookInfo.setIsdel(ConstantUtils.isNotDel);
		bookInfo.setUpdateTime(DateUtil.date());
		
		mapper.insert(bookInfo);
		// insert to 图书分类关系表
		Integer[] typeIds= {1,2,3,4};
		Integer[] labelIds= {1,2,3,4};
		bookInfo.setTypeIds(typeIds);
		bookInfo.setLabelIds(labelIds);
		bookInfoTypeMapper.addBookInfoType(bookInfo);
		// insert to 图书标签关系表
		bookInfoLabelMapper.addBookInfoLabel(bookInfo);
		return result;
	}

	
}
