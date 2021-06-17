package com.imooc.dom4j;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class PlanReader {
	
	public void writeXml() {
		SAXReader reader = new SAXReader();
		String file = "/Users/hujiacheng/Documents/imooc-javaweb/src/plan.xml";
		try {
			Document document = reader.read(file);
			Element root = document.getRootElement();
			Element course = root.addElement("course");
			course.addAttribute("no", "4");
			course.addElement("course-name").setText("线性代数");
			course.addElement("class-hour").setText("84");
			course.addElement("exam-form").setText("考试");
			Writer writer = new OutputStreamWriter(new FileOutputStream(file));
			document.write(writer);
			writer.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void readXml() {
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
		pr.writeXml();
		pr.readXml();
	}

}
