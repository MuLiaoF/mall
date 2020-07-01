package com.books.bookManage.controller;


import com.books.bookManage.service.IBookTypeService;
import com.books.entity.booktype.BookTypeBean;
import com.books.util.base.ConstantUtils;
import com.books.util.base.ExceptionConstantsUtils;
import com.books.util.base.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther Wang zhe
 * @Version
 * @ClassName BookTypeController
 * @Description 图书类型Controller
 */
@RestController
@RequestMapping("/books")
@Slf4j
public class BookTypeController {



    @Autowired
    private IBookTypeService service;

    /**
     * 插入图书类型
     * 测试请求：localhost:8081/books/oneType?pid=2&typeName=科学类&isdel=1&status=1
     * @param bookTypeBean 图书类型
     * @return
     */
    @RequestMapping("/oneType")
    public ResultData<String> addOneBookType(BookTypeBean bookTypeBean){
        ResultData<String> resultData = new ResultData<>();
        try{
            //插入
            service.addOneBookType(bookTypeBean);
            resultData.setCode(ConstantUtils.SUCCESS_CODE);
            resultData.setSuccess(ConstantUtils.SUCCESS_MESSAGE);
            resultData.setMsg("添加图书类型成功！");
        }catch (Exception ex){
            resultData.setCode(ConstantUtils.ERROR_CODE);
            resultData.setSuccess(ConstantUtils.ERROR_MESSAGE);
            resultData.setMsg("添加图书类型失败！");
            ExceptionConstantsUtils.printErrorMessage(log,ex,"添加图书异常");
        }
        return resultData;
    }

    /**
     * 根据ID删除一个图书类别
     * 测试请求：http://localhost:8081/books/deleteById?id=2
     * @param id ID
     * @return
     */
    @RequestMapping("/deleteById")
    public ResultData<String> deleteById(int id){
        ResultData<String> resultData = new ResultData<>();
        try{
            resultData = service.deleteBookTypeById(id);
        }catch (Exception e){
            resultData.setCode(ConstantUtils.ERROR_CODE);
            resultData.setSuccess(ConstantUtils.ERROR_MESSAGE);
            resultData.setMsg("删除失败！");
            return ExceptionConstantsUtils.printErrorMessage(log,e,"删除异常");
        }
        return resultData;
    }

    /**
     * 根据类型名称删除
     * 测试：http://localhost:8081/books/deleteByName?type_name=111
     * @param type_name 类型名称
     * @return
     */
    @RequestMapping("/deleteByName")
    public ResultData<String> deleteByTypeName(String type_name){
        ResultData<String> resultData = new ResultData<>();
        try{
            resultData = service.deleteBookTypeByType(type_name);
        }catch (Exception e){
            resultData.setCode(ConstantUtils.ERROR_CODE);
            resultData.setSuccess(ConstantUtils.ERROR_MESSAGE);
            resultData.setMsg("通过类型名称删除失败！");
            return ExceptionConstantsUtils.printErrorMessage(log,e,"通过类型名称删除异常");
        }
        return resultData;
    }

    /**
     * 根据ID查询一条记录
     * 测试：http://localhost:8081/books/selectOne?id=4
     * @param id ID
     * @return
     */
    @RequestMapping("/selectOne")
    public ResultData<Object> selectBookTypeById(int id){
        ResultData<Object> resultData = new ResultData<>();
        try{
            resultData = service.selectTypeById(id);
        }catch (Exception e){
            resultData.setCode(ConstantUtils.ERROR_CODE);
            resultData.setSuccess(ConstantUtils.ERROR_MESSAGE);
            resultData.setMsg("查询失败");
            return ExceptionConstantsUtils.printErrorMessage(log,e,"通过ID查询异常");
        }
        return resultData;
    }

    /**
     * 查询所有记录
     * 测试：http://localhost:8081/books/selectAll
     * @return
     */
    @RequestMapping("/selectAll")
    public ResultData<Object> selectAll(){
        ResultData<Object> resultData = new ResultData<>();
        try{
            resultData = service.selectTypeAll();
        }catch (Exception e){
            resultData.setCode(ConstantUtils.ERROR_CODE);
            resultData.setSuccess(ConstantUtils.ERROR_MESSAGE);
            resultData.setMsg("查询失败!");
            return ExceptionConstantsUtils.printErrorMessage(log,e,"查询异常");
        }
        return resultData;
    }
}
