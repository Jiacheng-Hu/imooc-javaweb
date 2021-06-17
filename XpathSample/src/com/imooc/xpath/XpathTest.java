package com.imooc.xpath;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class XpathTest {
	
	public void test(String xpathExp) {
		String file = "/Users/hujiacheng/Documents/imooc-javaweb/XpathSample/src/plan.xml";
		SAXReader reader = new SAXReader();
		try {
			Document document = reader.read(file);
			List<Node> nodes = document.selectNodes(xpathExp);
			for(Node node : nodes) {
				Element temp = (Element) node;
				System.out.println(temp.element("course-name").getText());
				System.out.println(temp.element("class-hour").getText());
				System.out.println(temp.element("exam-form").getText());
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		XpathTest xt = new XpathTest();
		xt.test("//course");
	}

}
