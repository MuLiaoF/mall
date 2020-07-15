package com.books.member.controller;

import com.books.entity.member.MemMemberInfo;
import com.books.entity.member.SysAuthUser;
import com.books.member.service.IMemberService;
import com.books.response.rule.CardRuleSelRsp;
import com.books.util.base.ExceptionConstantsUtils;
import com.books.util.base.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author feng
 * @version 1.0
 * @date 2020/7/15 15:59
 */
@RestController
@RequestMapping("/member")
@Slf4j
public class MemBerController {


    @Autowired
    private IMemberService memberService;


    @PostMapping("regis")
    public ResultData regisMember(HttpSession session) {
        SysAuthUser user = (SysAuthUser) session.getAttribute("user");
        MemMemberInfo memMemberInfo = null;
        try {
            memMemberInfo = memberService.regit(user);
        } catch (Exception e) {
            return ExceptionConstantsUtils.printErrorMessage(log, e, "注册用户失败");
        }

        return ExceptionConstantsUtils.printSuccessMessage(log,  "注册用户成功", memMemberInfo);
    }





}
