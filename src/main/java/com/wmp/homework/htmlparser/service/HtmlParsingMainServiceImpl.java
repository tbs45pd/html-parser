package com.wmp.homework.htmlparser.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class HtmlParsingMainServiceImpl implements HtmlParsingMainService {

	@Autowired
	private Parser htmlParser;
	
	@Override
	public Map<String, Object> getHtmlParsingData(String inputUrl, String htmlTagYn, int displayGroupingNum) throws IOException {

		// 1. URL Encoding
		String targetUrl = inputUrl;
		Document doc = Jsoup.connect(targetUrl).get();

		// 2. HTML Data Parsing
		String parsingData = htmlTagYn.equals("Y") ? doc.html() : doc.data() + doc.wholeText();

		// 3. Collect UpperCase/LowerCase Alphabet and Digit
		StringBuilder upperCaseAlphabet = new StringBuilder();
		StringBuilder lowerCaseAlphabet = new StringBuilder();
		StringBuilder digit = new StringBuilder();

		htmlParser.collectAlphabetOrDigitData(parsingData, upperCaseAlphabet, lowerCaseAlphabet, digit);

		// 4. Sort alphabet, digit Data
		String alphabetData = htmlParser.sortAlphabetData(upperCaseAlphabet, lowerCaseAlphabet);
		String digitData = htmlParser.sortDigitData(digit);

		// 5. Merge OutputText
		String mergedText = htmlParser.mergeOutPutText(alphabetData, digitData);
		
		// 6. Extract Grouping Data
		int divideNum = displayGroupingNum;
//		StringBuilder remainder = new StringBuilder();
//		Map<String, Object> outputMap = htmlParser.divideGroupDisplayText(mergedText, divideNum, remainder);
		Map<String, Object> outputMap = htmlParser.divideGroupDisplayText(mergedText, divideNum);
		
		// 7. Set return value
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("outputText", outputMap.get("returnStr"));
		log.debug("OutputText : ", outputMap.get("returnStr"));
		resultMap.put("remainder", outputMap.get("returnRemainder"));
		log.debug("Remainder : ", outputMap.get("returnRemainder"));
		return resultMap;
	}

}
