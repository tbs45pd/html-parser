package com.wmp.homework.htmlparser.service;

import java.util.Map;

public interface Parser {

	public void collectAlphabetOrDigitData(String htmlText, StringBuilder upperCaseAlphabet,
			StringBuilder lowerCaseAlphabet, StringBuilder digit);
	
	public String sortAlphabetData(StringBuilder upperCaseAlphabet, StringBuilder lowerCaseAlphabet);
	
	public String sortDigitData(StringBuilder digit);
	
	public String mergeOutPutText(String alphabetData, String digitData);
	
//	public String divideGroupDisplayText(String mergeText, int divideNum, StringBuilder remainder);
	
	public Map<String, Object> divideGroupDisplayText(String mergeText, int divideNum);
}
