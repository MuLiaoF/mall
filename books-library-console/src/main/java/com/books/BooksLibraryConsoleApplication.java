package com.books;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.books.*.mapper")
public class BooksLibraryConsoleApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksLibraryConsoleApplication.class, args);
	}

}
