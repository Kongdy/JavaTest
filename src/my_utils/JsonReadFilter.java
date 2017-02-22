package my_utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

/**
 * ��ȡ�ļ��������ַ�
 * 
 * @author wangk
 *
 */
public class JsonReadFilter {

	public static String FILE_PATH = "E:\\desktop\\chinese-poetry-master\\json";
	public static String OUT_PUT_PATH = "E:\\desktop\\result.txt";

	public static void main(String[] args) {
		Gson gson = new Gson();
		JsonReadFilter filter = new JsonReadFilter();
		long st = System.currentTimeMillis();
		List<File> files = filter.readFromParentPath();
		int totalCount = 0;
		StringBuilder sb = new StringBuilder();
		for (File file : files) {
			try {
				String results = filter.readContent(file).trim();
				List<MyEntity> myEntitys = gson.fromJson(results,
						new TypeToken<List<MyEntity>>() {
						}.getType());
				for (MyEntity entity : myEntitys) {
					for (String str : entity.paragraphs) {
						if(str.contains("��") || str.contains("��") || str.contains("��")) {
							continue;
						}
						str = str.replaceAll("[0-9]", "");
						String[] strs = str.split("[\\pP\\p{Punct}]");
						for(int i = 0;i < strs.length;i++) {
							String s = strs[i];
							if(s.contains("ȫ��") || s.contains("�ػ�") || s.contains("�@��Ԋ") || (s.length() ==1 && s.charAt(0) >= 48 && s.charAt(0) <= 57)) {
								continue;
							}
							sb.append(s);
							sb.append(" ");
						}
					}
					sb.append(System.getProperty("line.separator"));
				}
				sb.append(System.getProperty("line.separator"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			++totalCount;
			System.out.println("total progress:" + totalCount + "/"
					+ files.size());
		}
		filter.writeContent(sb.toString());
		long et = System.currentTimeMillis();
		long rt = et-st;
		System.out.println("��ʱ:"+rt);
	}

	/**
	 * ��Ŀ¼�л�ȡ�����ļ������ҹ��˳���Ҫ���ļ�
	 * 
	 * @return
	 */
	public List<File> readFromParentPath() {
		List<File> needsFile = new ArrayList<>();
		File parentFile = new File(FILE_PATH);
		if (parentFile.exists() && parentFile.isDirectory()) {
			File[] files = parentFile.listFiles();
			if (files.length > 0) {
				for (File file : files) {
					String name = file.getName();
					if (name.startsWith("poet.tang.")) {
						needsFile.add(file);
					}
				}
			} else {
				throw new IllegalArgumentException("Ŀ¼�����ļ���");
			}
		} else {
			throw new IllegalArgumentException("Ŀ¼�����ڣ�����·����ָ�����ļ�Ŀ¼");
		}
		return needsFile;
	}

	/**
	 * ��ȡ�ļ��е�����
	 * 
	 * @param txtFile
	 * @return
	 * @throws IOException
	 */
	public String readContent(File txtFile) throws IOException {
		StringBuffer content = new StringBuffer();
		if (txtFile.exists() && txtFile.isFile() && txtFile.canRead()) {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(txtFile), "UTF-8"));
			int tempChar;
			while ((tempChar = br.read()) != -1) {
				content.append((char) tempChar) ;
			}
			br.close();
		}
		return content.toString();
	}

	public void writeContent(String str) {
		File f = new File(OUT_PUT_PATH);
		try {
			if (!f.exists()) {
				f.createNewFile();
			}
			FileOutputStream fos = new FileOutputStream(f);
			PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(fos, "UTF-8")));
			pw.print(str);
			fos.flush();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
