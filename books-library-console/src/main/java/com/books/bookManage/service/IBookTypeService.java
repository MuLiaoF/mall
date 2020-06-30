package com.books.bookManage.service;

import com.books.entity.booktype.BookTypeBean;
import com.books.util.base.ResultData;

/**
 * @Auther Wang zhe
 * @Version
 * @ClassName IBookTypeService
 * @Description 业务层图书类型CRUD接口
 */
public interface IBookTypeService {
    /**
     * 添加一个图书类型
     * @param bookTypeBean 图书类型
     * @return
     */
    void addOneBookType(BookTypeBean bookTypeBean);
    /**
     * 根据ID删除一个图书类型
     * @param id 图书类型ID
     */
    ResultData<String> deleteBookTypeById(int id);
    /**
     * 根据图书类型名称删除
     * @param type_name 图书类型名称
     */
    ResultData<String> deleteBookTypeByType(String type_name);
}
