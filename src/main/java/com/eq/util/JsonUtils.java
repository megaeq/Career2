package com.eq.util;

import java.util.Map;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class JsonUtils {
	public static String prettyPrintedJson(Object object) {
		String uglyJSONString = new Gson().toJson(object);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(uglyJSONString);
        return gson.toJson(je);
	}
	public static String prettyPrintedHtmlJson(Object object) {
		String json = prettyPrintedJson(object);
		for(int i=0;i<5;i++) {
        	String s1 = "\n";
        	String s2 = "<br/>";
        	for(int k=0;k<4-i;k++) {
        		s1+=" ";
        		s2+="&nbsp;";
        	}
        	json = json.replace(s1, s2);
        }
		return json;
	}
	
	
	public static void main(String[] args) {
		Map<String, Object> map = Maps.newHashMap();
		map.put("a", 1);
		map.put("b",2);
		prettyPrintedJson(map);
		
	}
}
