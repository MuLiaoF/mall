package com.books.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.books.member.service.IndexService;

@RestController
public class IndexController {
	
	@Autowired
	private IndexService IndexService;
	
	
	@GetMapping
	public String index() {
		return "hi";
	}
	
	@GetMapping("/v1/demo")
	public Member demo() {
		return IndexService.demo();
	}

	@GetMapping("/v1/demo2")
	public Member demo2() {
		return IndexService.demo2();
	}
	
}



