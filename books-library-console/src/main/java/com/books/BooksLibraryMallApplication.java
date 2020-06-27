package com.books;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.books.*.mapper")
public class BooksLibraryMallApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksLibraryMallApplication.class, args);
	}

}
