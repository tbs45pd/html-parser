package com.wmp.homework.htmlparser.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HtmlParserViewController {

	@RequestMapping(value = "/")
	public String index() {
		
		return "html-parser";
	}
	

}
