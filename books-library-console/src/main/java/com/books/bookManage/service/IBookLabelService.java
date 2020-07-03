package com.books.bookManage.service;

import com.books.entity.booklabel.BookLabelBean;
import com.books.util.base.ResultData;

/**
 * @Auther Wang zhe
 * @Version
 * @ClassName IBookLabelService
 * @Description 业务层图书标签CRUD接口
 */
public interface IBookLabelService {
    /**
     * 添加一个图书标签
     * @param bookLabel
     */
    void addBookLabel(BookLabelBean bookLabel);

    /**
     * 根据ID删除一条记录
     * @param id ID
     * @return
     */
    ResultData<String> deleteLabelById(int id);

    /**
     * 根据ID修改标签信息
     * @param bookLabelBean 图书标签
     * @return
     */
    ResultData<String> updateLabelById(BookLabelBean bookLabelBean);

    /**
     * 根据标签名进行删除
     * @param label_name 标签名
     * @return
     */
    ResultData<String> deleteByName(String label_name);

    /**
     * 根据ID进行查询
     * @param id ID
     * @return
     */
    ResultData<Object> selectLabelById(int id);

    /**
     * 查询所有
     * @return
     */
    ResultData<Object> selectAll();
}
