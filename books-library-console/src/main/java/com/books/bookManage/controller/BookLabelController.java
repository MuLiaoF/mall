package com.books.bookManage.controller;


import com.books.bookManage.service.IBookLabelService;
import com.books.entity.booklabel.BookLabelBean;
import com.books.util.base.ConstantUtils;
import com.books.util.base.ExceptionConstantsUtils;
import com.books.util.base.ResultData;
import com.books.util.enums.ErrorCodesEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther Wang zhe
 * @Version
 * @ClassName BookLabelController
 * @Description 图书标签Controller
 */
@RestController
@RequestMapping("/labels")
@Slf4j
public class BookLabelController {

    @Autowired
    private IBookLabelService service;

    /**
     * 添加一个图书标签
     * 测试：http://localhost:8081/labels/add?label_name=1&isdel=1
     * @param bookLabelBean 图书标签
     * @return
     */
    @RequestMapping("/add")
    public ResultData<String> addOneLabel(BookLabelBean bookLabelBean){
        ResultData<String> resultData = new ResultData<>();
        try {
            service.addBookLabel(bookLabelBean);
            resultData.setSuccess(ConstantUtils.SUCCESS_MESSAGE);
            resultData.setCode(ErrorCodesEnum.SUCCESS_CODE.getErrorCode());
            resultData.setMsg(ErrorCodesEnum.SUCCESS_CODE.getErrorMsg());
        }catch (Exception ex){
            resultData.setSuccess(ConstantUtils.SUCCESS_MESSAGE);
            resultData.setCode(ErrorCodesEnum.ERROR_CODE_SAVE_ERROR.getErrorCode());
            resultData.setMsg(ErrorCodesEnum.ERROR_CODE_SAVE_ERROR.getErrorMsg());
            return ExceptionConstantsUtils.printErrorMessage(log,ex,"添加图书标签异常");
        }
        return resultData;
    }


    /**
     * 根据ID删除一个图书标签
     * 测试：http://localhost:8081/labels/deleteById?id=5
     * @param id ID
     * @return
     */
    @RequestMapping("/deleteById")
    public ResultData<String> deleteById(int id){
        ResultData<String> resultData = new ResultData<>();
        try {
            resultData = service.deleteLabelById(id);
        }catch (Exception ex){
            resultData.setSuccess(ConstantUtils.SUCCESS_MESSAGE);
            resultData.setCode(ErrorCodesEnum.ERROR_CODE_DELETE_ERROR.getErrorCode());
            resultData.setMsg(ErrorCodesEnum.ERROR_CODE_DELETE_ERROR.getErrorMsg());
            return ExceptionConstantsUtils.printErrorMessage(log,ex,"删除图书标签异常");
        }
        return resultData;
    }



    /**
     * 根据ID更新一个图书标签，传入几个参数就修改几个
     * 测试：http://localhost:8081/labels/updateById?id=3&isdel=1
     *      http://localhost:8081/labels/updateById?id=3&label_name=0
     *      http://localhost:8081/labels/updateById?id=3&label_name=1&isdel=0
     * @param bookLabelBean 标签信息
     * @return
     */
    @RequestMapping("/updateById")
    public ResultData<String> updateById(BookLabelBean bookLabelBean){
        ResultData<String> resultData = new ResultData<>();
        try {
            resultData = service.updateLabelById(bookLabelBean);
        }catch (Exception ex){
            resultData.setSuccess(ConstantUtils.SUCCESS_MESSAGE);
            resultData.setCode(ErrorCodesEnum.ERROR_CODE_DELETE_ERROR.getErrorCode());
            resultData.setMsg(ErrorCodesEnum.ERROR_CODE_DELETE_ERROR.getErrorMsg());
            return ExceptionConstantsUtils.printErrorMessage(log,ex,"更新图书标签异常");
        }
        return resultData;
    }

    /**
     * 根据标签名称删除
     * 测试：http://localhost:8081/labels/deleteByName?label_name=1
     * @param label_name 标签名称
     * @return
     */
    @RequestMapping("/deleteByName")
    public ResultData<String> deleteByName(String label_name){
        System.out.println(label_name);
        ResultData<String> resultData = new ResultData<>();
        try {
            resultData = service.deleteByName(label_name);
        }catch (Exception ex){
            resultData.setSuccess(ConstantUtils.SUCCESS_MESSAGE);
            resultData.setCode(ErrorCodesEnum.ERROR_CODE_DELETE_ERROR.getErrorCode());
            resultData.setMsg(ErrorCodesEnum.ERROR_CODE_DELETE_ERROR.getErrorMsg());
            return ExceptionConstantsUtils.printErrorMessage(log,ex,"删除图书标签异常！");
        }
        return resultData;
    }

    /**
     * 根据ID进行修改
     * @param id ID
     * @return
     */
    @RequestMapping("/selectById")
    public ResultData<Object> selectLabelById(int id){
        ResultData<Object> resultData = new ResultData<>();
        try {
            resultData = service.selectLabelById(id);
        }catch (Exception ex){
            resultData.setSuccess(ConstantUtils.SUCCESS_MESSAGE);
            resultData.setCode(ErrorCodesEnum.ERROR_CODE_QUERY_ERROR.getErrorCode());
            resultData.setMsg(ErrorCodesEnum.ERROR_CODE_QUERY_ERROR.getErrorMsg());
            return ExceptionConstantsUtils.printErrorMessage(log,ex,"根据ID查询异常！");
        }
        return resultData;
    }

    /**
     * 查询所有
     * 测试：http://localhost:8081/labels/selectAll
     * @return
     */
    @RequestMapping("/selectAll")
    public ResultData<Object> selectAll(){
        ResultData<Object> resultData = new ResultData<>();
        try {
            resultData = service.selectAll();
        }catch (Exception ex){
            resultData.setSuccess(ConstantUtils.SUCCESS_MESSAGE);
            resultData.setCode(ErrorCodesEnum.ERROR_CODE_QUERY_ERROR.getErrorCode());
            resultData.setMsg(ErrorCodesEnum.ERROR_CODE_QUERY_ERROR.getErrorMsg());
            return ExceptionConstantsUtils.printErrorMessage(log,ex,"查询所有异常！");
        }
        return resultData;
    }
}
