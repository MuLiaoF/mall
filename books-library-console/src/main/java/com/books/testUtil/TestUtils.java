package com.books.testUtil;

import java.util.Date;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

/**
* @author Zhao yongbing
* @version 创建时间：2020年6月29日 下午1:59:41
* @ClassName 类名称 TestUtils
* @Description 类描述  hutool工具测试类
*/

public class TestUtils {

	public static void main(String[] args) {
		String newFileName = DateUtil.format(new Date(), "YYYYMMddhhmmss");
		DateTime date = DateUtil.date();
		System.out.println(newFileName);
		System.out.println(date);
	}
}
