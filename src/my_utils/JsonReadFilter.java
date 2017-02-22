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
 * 读取文件，过滤字符
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
						if(str.contains("□") || str.contains("●") || str.contains("○")) {
							continue;
						}
						str = str.replaceAll("[0-9]", "");
						String[] strs = str.split("[\\pP\\p{Punct}]");
						for(int i = 0;i < strs.length;i++) {
							String s = strs[i];
							if(s.contains("全唐") || s.contains("敦煌") || s.contains("這首詩") || (s.length() ==1 && s.charAt(0) >= 48 && s.charAt(0) <= 57)) {
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
		System.out.println("耗时:"+rt);
	}

	/**
	 * 从目录中获取所有文件，并且过滤出需要的文件
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
				throw new IllegalArgumentException("目录下无文件。");
			}
		} else {
			throw new IllegalArgumentException("目录不存在，或者路径所指不是文件目录");
		}
		return needsFile;
	}

	/**
	 * 读取文件中的内容
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
