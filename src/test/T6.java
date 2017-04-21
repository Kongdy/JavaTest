package test;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class T6 {
	
	private static List<String> tempArrayList = new ArrayList<String>();
	private static Random rd = new Random();
	private static DecimalFormat format = new DecimalFormat("000");
	
	public static void main(String[] args) {
		int sum = 0;
		for(int i = 0;i < 1000000;i++) {
			tempArrayList.clear();
			sum += calcRepeat(0);
		}
		double result = sum/1000000F;
		System.out.println("result:"+result);
	}
	
	private static int calcRepeat(int repeatCount) {
		int threeRandomInt = rd.nextInt(999);
		String threeRandomStr = format.format(threeRandomInt);
		repeatCount++;
		if(tempArrayList.contains(threeRandomStr)) {
			return repeatCount;
		} else {
			tempArrayList.add(threeRandomStr);
			return calcRepeat(repeatCount);
		}
	}
}
