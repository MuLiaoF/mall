package com.books.bookManage.service.impl;

import com.books.bookManage.mapper.BookLabelMapper;
import com.books.bookManage.service.IBookLabelService;
import com.books.entity.booklabel.BookLabelBean;
import com.books.util.base.ConstantUtils;
import com.books.util.base.ExceptionConstantsUtils;
import com.books.util.base.ResultData;
import lombok.extern.slf4j.Slf4j;
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
public class BookLabelServiceImpl implements IBookLabelService {

    @Autowired
    private BookLabelMapper mapper;

    /**
     * 插入一个图书标签
     * @param bookLabelBean 图书标签
     */
    @Override
    public void addBookLabel(BookLabelBean bookLabelBean) {
        mapper.addBookLabel(bookLabelBean);
    }

    /**
     * 判断ID是否存在的方法
     * @param id ID
     * @return 存在返回true 否则返回false
     */
    public boolean queryIdExists(int id){
        ResultData<String> resultData = new ResultData<>();
        if (mapper.queryIdExists(id)==0) return false;
        return true;
    }

    /**
     * 根据ID删除一个图书标签信息
     * @param id ID
     * @return
     */
    @Override
    public ResultData<String> deleteLabelById(int id) {
        ResultData<String> resultData = new ResultData<>();
        //如果ID不存在
        if (!queryIdExists(id)){
            resultData.setSuccess(ConstantUtils.ERROR_MESSAGE);
            resultData.setCode(ConstantUtils.SUCCESS_CODE);
            resultData.setMsg("不存在当前ID");
            ExceptionConstantsUtils.printErrorMessage(log,"不存在id为"+id+"的记录");
            return resultData;
        }
        //删除
        mapper.deleteLabelById(id);
        resultData.setSuccess(ConstantUtils.SUCCESS_MESSAGE);
        resultData.setCode(ConstantUtils.SUCCESS_CODE);
        resultData.setMsg("删除成功!");
        return resultData;
    }

    /**
     * 根据ID更新一个图书标签
     * @param bookLabelBean 标签信息
     * @return
     */
    @Override
    public ResultData<String> updateLabelById(BookLabelBean bookLabelBean) {
        ResultData<String> resultData = new ResultData<>();
        //如果ID不存在
        if (!queryIdExists(bookLabelBean.getId())){
            resultData.setSuccess(ConstantUtils.ERROR_MESSAGE);
            resultData.setCode(ConstantUtils.ERROR_CODE);
            resultData.setMsg("不存在当前记录");
            ExceptionConstantsUtils.printErrorMessage(log,"不存在id为"+ bookLabelBean.getId()+"的记录");
            return resultData;
        }
        //删除
        mapper.updateLabelById(bookLabelBean);
        resultData.setSuccess(ConstantUtils.SUCCESS_MESSAGE);
        resultData.setCode(ConstantUtils.SUCCESS_CODE);
        resultData.setMsg("更新成功!");
        return resultData;
    }

    //根据标签名判断该标签是否存在
    public boolean queryLabelExists(String labelName){
        ResultData<String> resultData = new ResultData<>();
        if (mapper.queryLabelExists(labelName)==0) return false;
        return true;
    }

    /**
     * 根据标签名进行删除
     * @param label_name 标签名
     * @return
     */
    @Override
    public ResultData<String> deleteByName(String label_name) {
        ResultData<String> resultData = new ResultData<>();
        if (!queryLabelExists(label_name)){
            resultData.setSuccess(ConstantUtils.ERROR_MESSAGE);
            resultData.setCode(ConstantUtils.ERROR_CODE);
            resultData.setMsg("不存在当前标签");
            ExceptionConstantsUtils.printErrorMessage(log,"不存在当前标签");
            return resultData;
        }
        mapper.deleteByName(label_name);
        resultData.setSuccess(ConstantUtils.SUCCESS_MESSAGE);
        resultData.setCode(ConstantUtils.SUCCESS_CODE);
        resultData.setMsg("删除成功!");
        return resultData;
    }

    /**
     * 根据ID进行查询
     * @param id ID
     * @return
     */
    @Override
    public ResultData<Object> selectLabelById(int id) {
        ResultData<Object> resultData = new ResultData<>();
        //如果ID不存在
        if (!queryIdExists(id)){
            resultData.setSuccess(ConstantUtils.ERROR_MESSAGE);
            resultData.setCode(ConstantUtils.ERROR_CODE);
            resultData.setMsg("不存在当前ID!");
            ExceptionConstantsUtils.printErrorMessage(log,"不存在id为"+id+"的记录");
            return resultData;
        }
        resultData.setSuccess(ConstantUtils.SUCCESS_MESSAGE);
        resultData.setCode(ConstantUtils.SUCCESS_CODE);
        resultData.setObj(mapper.selectLabelById(id));
        resultData.setMsg("查询成功!");
        return resultData;
    }

    /**
     * 根据所有
     * @return
     */
    @Override
    public ResultData<Object> selectAll() {
        ResultData<Object> resultData = new ResultData<>();
        resultData.setSuccess(ConstantUtils.SUCCESS_MESSAGE);
        resultData.setCode(ConstantUtils.SUCCESS_CODE);
        resultData.setObj(mapper.selectAll());
        resultData.setMsg("查询成功!");
        return resultData;
    }

}
