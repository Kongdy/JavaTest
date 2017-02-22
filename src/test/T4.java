package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class T4 {
	
	private final static String[] goods = new String[]{
		"�·�","��ʳ","��ױƷ","Ь"
	};
	/**
	 * ȡ���볤��
	 */
	private final static int GOOD_NUM_LENGTH = 6;
	private static Map<String, String> goodsMap = new HashMap<String, String>();
	
	public static void main(String[] args) {
		System.out.println("��ʼ����ȡ����...");
		goodsMap.clear();
		for(String good:goods) {
			String goodNum = getRadomUniqueGoodNum();
			goodsMap.put(goodNum,good);
		}
		System.out.println("ȡ�����������:");
		for (String key:goodsMap.keySet()) {
			System.out.println(key+" - "+goodsMap.get(key));
		}
		System.out.println("\n������ȡ���룬�س�����,����end��������:");
		Scanner scanner = new Scanner(System.in);
		for (;;) {
			String key = scanner.nextLine();
			if("end".equalsIgnoreCase(key)) {
				break;
			}
			if(goodsMap.keySet().contains(key)) {
				System.out.println(key+" - "+goodsMap.get(key));
			} else {
				System.out.println("ȡ�����Ӧ�Ļ��ﲻ���ڣ�����������:");
			}
		}
		scanner.close();
	}

	
	public static String getRadomUniqueGoodNum() {
		String goodNum = "";
		for(int i = 0;i < GOOD_NUM_LENGTH;i++) {
			goodNum +=(int)(Math.random()*10);
		}
		if(goodsMap.keySet().contains(goodNum)) {
			goodNum = getRadomUniqueGoodNum();
		}
		return goodNum;
	}

}
