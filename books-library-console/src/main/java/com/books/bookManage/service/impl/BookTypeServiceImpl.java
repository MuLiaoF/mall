package com.books.bookManage.service.impl;

import com.books.bookManage.mapper.BookTypeMapper;
import com.books.bookManage.service.IBookTypeService;
import com.books.entity.booktype.BookTypeBean;
import com.books.util.base.ConstantUtils;
import com.books.util.base.ExceptionConstantsUtils;
import com.books.util.base.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther Wang zhe
 * @Version
 * @ClassName BookTypeServiceImpl
 * @Description 业务层图书类型接口实现类
 */
@Service
@Slf4j
public class BookTypeServiceImpl implements IBookTypeService {


    @Autowired
    private BookTypeMapper mapper;

    @Override
    public void addOneBookType(BookTypeBean bookTypeBean) {
        //调用持久层插入图书类型
        mapper.addOneBookType(bookTypeBean);
    }

    /**
     * 根据ID删除一个图书类型
     * @param id 图书类型ID
     * @return
     */
    @Override
    public ResultData<String> deleteBookTypeById(int id) {
        ResultData<String> resultData = new ResultData<>();
        //如果该ID不存在直接返回错误信息
        if (mapper.queryIdExists(id)==0){
            resultData.setCode(ConstantUtils.ERROR_CODE);
            resultData.setSuccess(ConstantUtils.ERROR_MESSAGE);
            resultData.setMsg("不存在该条记录！");
            ExceptionConstantsUtils.printErrorMessage(log,"不存在id为"+id+"的记录");
            return resultData;
        }
        //ID存在，执行删除操作并返回成功信息
        mapper.deleteBookTypeById(id);
        resultData.setCode(ConstantUtils.SUCCESS_CODE);
        resultData.setSuccess(ConstantUtils.SUCCESS_MESSAGE);
        resultData.setMsg("删除成功");
        return resultData;
    }

    /**
     * 根据类型名称删除
     * @param type_name 图书类型名称
     * @return
     */
    @Override
    public ResultData<String> deleteBookTypeByType(String type_name) {
        ResultData<String> resultData = new ResultData<>();
        //如果不存在这个类型名字，返回错误信息
        if (mapper.queryTypeExists(type_name)==0){
            resultData.setCode(ConstantUtils.ERROR_CODE);
            resultData.setSuccess(ConstantUtils.ERROR_MESSAGE);
            resultData.setMsg("不存在当前类型名称");
            ExceptionConstantsUtils.printErrorMessage(log,"不存在名称为"+type_name+"的记录");
            return resultData;
        }
        //如果存在的话删除
        mapper.deleteBookTypeByType(type_name);
        resultData.setCode(ConstantUtils.SUCCESS_CODE);
        resultData.setSuccess(ConstantUtils.SUCCESS_MESSAGE);
        resultData.setMsg("删除成功");
        return resultData;
    }

    /**
     * 根据ID查询一条记录
     * @param id ID
     * @return
     */
    @Override
    public ResultData<Object> selectTypeById(int id) {
        ResultData<Object> resultData = new ResultData<>();
        //不存在ID
        if (mapper.queryIdExists(id)==0){
            resultData.setCode(ConstantUtils.ERROR_CODE);
            resultData.setSuccess(ConstantUtils.ERROR_MESSAGE);
            resultData.setMsg("不存在该条记录");
            ExceptionConstantsUtils.printErrorMessage(log,"不存在id为"+id+"的记录");
            return resultData;
        }
        resultData.setCode(ConstantUtils.SUCCESS_CODE);
        resultData.setSuccess(ConstantUtils.SUCCESS_MESSAGE);
        resultData.setMsg("查询成功");
        resultData.setObj(mapper.selectTypeById(id));
        return resultData;
    }

    /**
     * 查询所有记录
     * @return
     */
    @Override
    public ResultData<Object> selectTypeAll() {
        ResultData<Object> resultData = new ResultData<>();
        resultData.setCode(ConstantUtils.SUCCESS_CODE);
        resultData.setSuccess(ConstantUtils.SUCCESS_MESSAGE);
        resultData.setMsg("查询成功");
        resultData.setObj(mapper.selectTypeAll());
        return resultData;
    }

    /**
     * 根据ID修改图书类型信息
     * @param bookTypeBean 图书类型
     * @return
     */
    @Override
    public ResultData<String> updateTypeById(BookTypeBean bookTypeBean) {
        mapper.updateTypeById(bookTypeBean);
        ResultData<String> resultData = new ResultData<>();
        resultData.setCode(ConstantUtils.SUCCESS_CODE);
        resultData.setSuccess(ConstantUtils.SUCCESS_MESSAGE);
        resultData.setMsg("修改成功");
        return resultData;
    }
}
