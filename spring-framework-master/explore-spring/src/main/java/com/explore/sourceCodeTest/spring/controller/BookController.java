package com.explore.sourceCodeTest.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.explore.sourceCodeTest.spring.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;

}
