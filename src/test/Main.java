package test;

import java.util.Scanner;

/**
 * ACM 5
 * @author wangk
 *
 */
public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int count = input.nextInt();
		while (count-- >0) {
			String cursorStr = input.next();
			String referStr = input.next();
			int cursorLength = cursorStr.length();
			int referLength = referStr.length();
			int showCount = 0;
			for (int i = 0; i < referLength; i++) {
			
				if((i >= cursorLength-1) && (referStr.charAt(i) == cursorStr.charAt(cursorLength-1))) {
					boolean flag = true;
					for (int j = 0; j < cursorLength; j++) {
						if(referStr.charAt(i-cursorLength+j+1) != cursorStr.charAt(j)) {
							flag = false;
							break;
						}
					}
					if(flag) {
						++showCount;
					}
				}
			}
			
		System.out.println(showCount);
			
		}
		
		input.close();
	}
}
