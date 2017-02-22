package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.io.File;
import java.lang.Runtime;
import java.lang.ProcessBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class javaTest {
	public static void main(String[] args) throws Exception {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		Document xmlDoc = null;
		String str = readJson();
		ByteArrayInputStream bais = new ByteArrayInputStream(str.getBytes());
		db = factory.newDocumentBuilder();
		xmlDoc = db.parse(bais);
		Element root = xmlDoc.getDocumentElement();
		NodeList nl1 = root.getElementsByTagName("android.view.View");

		for (int i = 0; i < nl1.getLength(); i++) {
			String tmp = nl1.item(i).getAttributes()
					.getNamedItem("content-desc").getNodeValue().trim();
			if (tmp.endsWith("选）")) {
				System.out.println(tmp.substring(0, tmp.length() - 4));
			}
			if (tmp.endsWith("提交 Link")) {
				System.out.println("zzzzzzzzzzzzzzzzzzz");
			}
		}
	}

	public static String readJson() {
		BufferedReader reader = null;
		StringBuffer data = new StringBuffer();
		//
		try {
			reader = new BufferedReader(new FileReader("assert/test.xml"));
			String temp = null;
			while ((temp = reader.readLine()) != null) {
				data.append(temp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return data.toString();
	}
}

// select * from transporter_training_question where subject == 1

// print [tmp.name for tmp in aa if tmp.is_correct]
