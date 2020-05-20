package com.wmp.homework.htmlparser.service;

import java.io.IOException;
import java.util.Map;

public interface HtmlParsingMainService {
	
	public Map<String, Object> getHtmlParsingData(String inputUrl, String htmlTagYn, int displayGroupingNum) throws IOException;
}
