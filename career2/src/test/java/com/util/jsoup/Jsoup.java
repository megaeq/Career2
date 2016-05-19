package com.util.jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

public class Jsoup {
	@Test
	public void connect() throws Exception {
		Document doc = org.jsoup.Jsoup.connect("https://www.ibm.com/developerworks/cn/java/j-lo-jsouphtml/").get();
		String title = doc.title();
		System.out.println(title);
		Elements eles = doc.getAllElements();
		for(Element ele:eles) {
			System.out.println(ele.text());
		}
	}
	
}
