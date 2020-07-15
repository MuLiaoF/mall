package com.books.member.controller;

import com.books.entity.member.SysAuthUser;
import com.books.member.service.IAuthUserService;
import com.books.request.member.InitMemMiniFansReq;
import com.books.request.member.MemMiniFansReq;
import com.books.response.member.AuthUserRes;
import com.books.util.base.ExceptionConstantsUtils;
import com.books.util.base.ResultData;
import com.books.util.token.TokenEntity;
import com.books.util.token.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


/**
 * @author feng
 * @version 1.0
 * @date 2020/7/1 11:57
 */
@RestController
@Slf4j
@RequestMapping("/auth")
public class AuthUserController {

    @Autowired
    private IAuthUserService authUserService;


    /**
     * 初始化粉丝信息获取openID
     *
     * @param memMiniFansReq
     * @return
     */
    @PostMapping("/v1/mini/fans/init")
    public ResultData initMiniFans(@RequestBody MemMiniFansReq memMiniFansReq) {
        String appid = memMiniFansReq.getAppid();
        String code = memMiniFansReq.getCode();
        if (appid == null || "".equals(appid)) {
            return ExceptionConstantsUtils.printErrorMessage(log, "参数不能为空");
        }
        if (code == null || "".equals(code)) {
            return ExceptionConstantsUtils.printErrorMessage(log, "参数不能为空");
        }
        AuthUserRes memMiniFansRes = null;
        try {
            memMiniFansRes = authUserService.initMiniFans(memMiniFansReq);
        } catch (Exception e) {
            log.info(ExceptionUtils.getStackTrace(e));
            return ExceptionConstantsUtils.printErrorMessage(log, e.getMessage());
        }
        return ExceptionConstantsUtils.printSuccessMessage(log, "", memMiniFansRes);
    }

    /**
     * 小程序微信授权
     *
     * @param memMiniFans 粉丝信息
     * @param request    过滤器
     * @return
     * @throws Exception
     */
    @PostMapping("/v1/get/mini/fans/info")
    public ResultData modifyMemMiniFans(@RequestBody InitMemMiniFansReq memMiniFans, HttpServletRequest request) throws Exception {
        log.info("---------------> 解密参数" + memMiniFans);
        InitMemMiniFansReq.UserInfoWx userInfo = memMiniFans.getUserInfo();
        String encryptedData = memMiniFans.getEncryptedData();
        String signature = memMiniFans.getSignature();
        if (signature == null || "".equals(signature)) {
            return ExceptionConstantsUtils.printErrorMessage(log, "");
        }
        if (encryptedData == null || "".equals(encryptedData)) {
            return ExceptionConstantsUtils.printErrorMessage(log, "");
        }
        if (userInfo == null) {
            return ExceptionConstantsUtils.printErrorMessage(log, "");
        }
        TokenEntity sessionUser = TokenUtil.getSessionUser(request);
        if (sessionUser == null) {
            return ExceptionConstantsUtils.printErrorMessage(log, "");
        }
        Integer mid = sessionUser.getMid();
        Integer userId = sessionUser.getUserId();
        memMiniFans.setMid(mid);
        memMiniFans.setUserId(userId);
        SysAuthUser token = null;
        try {
            token = authUserService.modifyAuthUser(memMiniFans);
        } catch (Exception e) {
            log.info(ExceptionUtils.getStackTrace(e));
            return ExceptionConstantsUtils.printErrorMessage(log, "");
        }
        return ExceptionConstantsUtils.printSuccessMessage(log, "", token);
    }
}



