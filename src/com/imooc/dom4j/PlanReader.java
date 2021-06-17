package com.imooc.dom4j;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class PlanReader {

	public void getData() {
		SAXReader reader = new SAXReader();
		String file = "/Users/hujiacheng/Documents/imooc-javaweb/src/plan.xml";
		try {
			Document document = reader.read(file);
			Element root = document.getRootElement();
			List<Element> courses = root.elements("course");
			for (Element course : courses) {
				System.out.println("课程编号：" + course.attribute("no").getText());
				System.out.println("课程名称：" + course.element("course-name").getText());
				System.out.println("课时：" + course.element("class-hour").getText());
				System.out.println("考试形式：" + course.element("exam-form").getText());
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		PlanReader pr = new PlanReader();
		pr.getData();
	}

}
