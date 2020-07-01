package com.books.bookManage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.books.entity.booktype.BookTypeBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther Wang zhe
 * @Version
 * @ClassName BookTypeMapper
 * @Description 图书类型表映射接口
 */
public interface BookTypeMapper extends BaseMapper<BookTypeBean> {
    /**
     * 添加一个图书类型
     * @param bookTypeBean 图书类型
     */
    void addOneBookType(BookTypeBean bookTypeBean);

    /**
     * 根据ID删除一个图书类型
     * @param id 图书类型ID
     */
    void deleteBookTypeById(int id);

    /**
     *根据ID判断有没有当前记录
     * @param id ID
     * @return 有返回1 没有 返回0
     */
    int queryIdExists(int id);

    /**
     * 根据图书类型名称删除记录
     * @param type_name 图书类型名称
     */
    void deleteBookTypeByType(String type_name);

    /**
     * 根据类型名称判断是否存在该行记录
     * @param type_name 类型名称
     * @return 存在返回1，否则返回0
     */
    int queryTypeExists(String type_name);

    /**
     * 根据ID查询一条记录
     * @param id ID
     * @return 一个图书类型记录
     */
    BookTypeBean selectTypeById(int id);

    /**
     * 查询所有记录
     * @return
     */
    List<BookTypeBean> selectTypeAll();

    /**
     * 根据ID修改信息
     * @param bookTypeBean 图书类型
     */
    void updateTypeById(BookTypeBean bookTypeBean);
}
