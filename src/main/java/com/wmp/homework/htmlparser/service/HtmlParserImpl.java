package com.wmp.homework.htmlparser.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class HtmlParserImpl implements Parser {

	public void collectAlphabetOrDigitData(String htmlText, StringBuilder upperCaseAlphabet,
			StringBuilder lowerCaseAlphabet, StringBuilder digit) {
		for (char c : htmlText.toCharArray()) {
			if ((c >= 'A' && c <= 'Z')) {
				upperCaseAlphabet.append(c);
			} else if ((c >= 'a' && c <= 'z')) {
				lowerCaseAlphabet.append(c);
			} else if ((c >= 48 && c <= 57)) {
				digit.append(c);
			}
		}
		// List<Integer> alphabetList = s.chars().filter(e -> Character.isLetter(e)).boxed().collect(Collectors.toList());
	}

	
	public String sortAlphabetData(StringBuilder upperCaseAlphabet, StringBuilder lowerCaseAlphabet) {

		char[] uppCharList = upperCaseAlphabet.toString().toCharArray();
		char[] lowCharList = lowerCaseAlphabet.toString().toCharArray();

		Arrays.sort(uppCharList);
		Arrays.sort(lowCharList);

		String upperStr = String.valueOf(uppCharList);
		String lowerStr = String.valueOf(lowCharList);

		StringBuilder tempSb = new StringBuilder();
		for (char i = 'A'; i <= 'Z'; i++) {
			int uppFrom = upperStr.indexOf(String.valueOf(i));
			int uppTo = upperStr.lastIndexOf(String.valueOf(i));
			
			if(uppFrom >= 0 && uppTo >= 0 ) {
				tempSb.append(upperStr.substring(uppFrom, uppTo));
			}
			
			
			int lowFrom = lowerStr.indexOf(String.valueOf((char) (i + 32)));
			int lowTo = lowerStr.lastIndexOf(String.valueOf((char) (i + 32)));

			if(lowFrom >= 0 && lowTo >= 0 ) {
				tempSb.append(lowerStr.substring(lowFrom, lowTo));
			}			
		}
		return tempSb.toString();
	}

	
	public String sortDigitData(StringBuilder digit) {
		char[] sortedDigit = digit.toString().toCharArray();
		Arrays.sort(sortedDigit);
		return String.valueOf(sortedDigit);
	}

	
	public String mergeOutPutText(String alphabetData, String digitData) {

		char[] alphabetList = alphabetData.toCharArray();
		char[] digitList = digitData.toCharArray();

		StringBuffer sortedOutputText = new StringBuffer();

		int alphabetTextSize = alphabetList.length;
		int digitTextSize = digitList.length;
		int loopSize = alphabetTextSize > digitTextSize ? alphabetTextSize : digitTextSize;

		for (int i = 0; i < loopSize; i++) {

			if (i < alphabetTextSize) {
				sortedOutputText.append(alphabetList[i]);
			}

			if (i < digitTextSize) {
				sortedOutputText.append(digitList[i]);
			}
		}

		return sortedOutputText.toString();
	}

	
	public Map<String, Object> divideGroupDisplayText(String mergeText, int divideNum) {
		int totalSize = mergeText.length();
		int remainderNum = totalSize % divideNum;
		
		String returnStr = mergeText.substring(0, totalSize-remainderNum);
		String returnRemainder = mergeText.substring(totalSize-remainderNum);
		
		Map<String, Object> returnMap = new HashMap<>();
		returnMap.put("returnStr", returnStr);
		returnMap.put("returnRemainder", returnRemainder);
		
		return returnMap;
//		return Map<String, Object> 
//		char[] outputText = mergeText.toCharArray();
//
//		StringBuilder returnStr = new StringBuilder();
//		int cnt = 0;
//		for (int i = 0; i < outputText.length; i++) {
//			if (cnt == divideNum) {
//				returnStr.append(remainder);
//				cnt = 0;
//				remainder.delete(0, divideNum);
//			} else {
//				remainder.append(outputText[i]);
//				cnt++;
//			}
//		}

//		return returnStr.toString();
	}
	
	
	
	

}
