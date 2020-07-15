package com.books.bookManage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.books.entity.booklabel.BookLabelBean;

import java.util.List;

/**
 * @Auther Wang zhe
 * @Version
 * @ClassName BookLabelMapper
 * @Description 图书标签映射接口
 */
public interface BookLabelMapper extends BaseMapper<BookLabelBean> {
    /**
     * 添加一个图书标签
     * @param bookLabelBean
     */
    void addBookLabel(BookLabelBean bookLabelBean);

    /**
     *根据ID判断有没有当前记录
     * @param id ID
     * @return 有返回1 没有 返回0
     */
    int queryIdExists(int id);

    /**
     * 根据ID删除一个图书标签
     * @param id ID
     */
    void deleteLabelById(int id);

    /**
     * 根据标签名进行删除
     * @param label_name 标签名
     */
    void deleteByName(String label_name);

    /**
     * 根据id修改一条
     * @param bookLabelBean 图书标签
     */
    void updateLabelById(BookLabelBean bookLabelBean);

    /**
     * 根据标签名判断是否存在
     * @param label_name 标签名
     * @return
     */
    int queryLabelExists(String label_name);

    /**
     * 根据ID进行查询
     * @param id ID
     * @return
     */
    BookLabelBean selectLabelById(int id);

    /**
     * 查询所有标签
     * @return
     */
    List<BookLabelBean> selectAll();
}
