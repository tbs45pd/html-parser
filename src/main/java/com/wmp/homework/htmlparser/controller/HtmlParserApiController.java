package com.wmp.homework.htmlparser.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.wmp.homework.htmlparser.service.HtmlParsingMainService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class HtmlParserApiController {
	
	@Autowired
	private HtmlParsingMainService htmlParsingMainService;
	
	@ResponseBody
	@RequestMapping(value = "/html/parsingUrl")
	public ModelAndView getHtmlParsingData(@RequestParam String inputUrl
			, @RequestParam String htmlTagYn, @RequestParam int displayGroupingNum) throws IOException {
		log.debug("Input URL : " + inputUrl);
		log.debug("DisplayGroupingNum : " +  displayGroupingNum);
		log.debug("htmlTagYn : " + htmlTagYn);
		
		
		Map<String, Object> resultMap = htmlParsingMainService.getHtmlParsingData(inputUrl, htmlTagYn, displayGroupingNum);
		
		
		ModelAndView model = new ModelAndView();
		model.setViewName("html-parser");
		model.addObject("outputText" , resultMap.get("outputText"));
		model.addObject("remainder" , resultMap.get("remainder"));
		
		return model;
	}
	
	
	
	
	
	
	
	
	
	
}
