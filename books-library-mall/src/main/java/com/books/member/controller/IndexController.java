package com.books.member.controller;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONObject;
import com.books.entity.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.books.member.service.IndexService;

@RestController
public class IndexController {
	
	@Autowired
	private IndexService IndexService;
	
	
	@GetMapping("/hi")
	public String index() {
		return "hi";
	}
	
	
	@RequestMapping("/v1/demo")
	@ResponseBody
	public Member demo() {
		return IndexService.demo();
	}

	@GetMapping("/v1/demo2")
	public Member demo2() {
		return IndexService.demo2();
	}
	
}



