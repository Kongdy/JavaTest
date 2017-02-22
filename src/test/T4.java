package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class T4 {
	
	private final static String[] goods = new String[]{
		"衣服","零食","化妆品","鞋"
	};
	/**
	 * 取货码长度
	 */
	private final static int GOOD_NUM_LENGTH = 6;
	private static Map<String, String> goodsMap = new HashMap<String, String>();
	
	public static void main(String[] args) {
		System.out.println("开始生成取货码...");
		goodsMap.clear();
		for(String good:goods) {
			String goodNum = getRadomUniqueGoodNum();
			goodsMap.put(goodNum,good);
		}
		System.out.println("取货码生成完毕:");
		for (String key:goodsMap.keySet()) {
			System.out.println(key+" - "+goodsMap.get(key));
		}
		System.out.println("\n请输入取货码，回车查找,输入end结束输入:");
		Scanner scanner = new Scanner(System.in);
		for (;;) {
			String key = scanner.nextLine();
			if("end".equalsIgnoreCase(key)) {
				break;
			}
			if(goodsMap.keySet().contains(key)) {
				System.out.println(key+" - "+goodsMap.get(key));
			} else {
				System.out.println("取货码对应的货物不存在，请重新输入:");
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
