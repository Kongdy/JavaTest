package test;

import java.util.Scanner;

/**
 * ACM 4
 * @author wangk
 */
public class T2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int count = input.nextInt();
		while (count-- > 0) {
			String line = input.next();
			char[] chars = line.toCharArray();
			// shell sort
			int lineSize = chars.length/2;
			while (lineSize >= 1) {
				for (int i = lineSize; i < chars.length; ++i) {
					if(chars[i] < chars[i-lineSize]) {
						int j = i-lineSize;
						final char x = chars[i];
						chars[i] = chars[i-lineSize];
						
						while (j >= 0 && x < chars[j]) {
							chars[j+lineSize] = chars[j];
							j -= lineSize;
						}
						chars[j+lineSize] = x;
					}
				}
				lineSize = lineSize/2;
			}
			
			StringBuilder builder = new StringBuilder();
			for (int i = 0;i < chars.length;i++) {
				builder.append(chars[i]);
				if(i < chars.length-1) {
					builder.append(" ");
				}
			}
			System.out.println(builder.toString());
		}
		input.close();
	}
}
