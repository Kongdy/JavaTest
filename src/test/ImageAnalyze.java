package test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Í¼Æ¬·ÖÎöÊ¶±ð
 * @author wangk
 *
 */
public class ImageAnalyze {
	
	public static void main(String[] args) throws IOException {
		BufferedImage image = ImageIO.read(new File("E:\\e.jpg"));
		
		int width = image.getWidth();
		int heght = image.getHeight();
		
		for (int i = 0; i < heght; i++) {
			for (int j = 0; j < width; j++) {
				int dip = image.getRGB(j, i);
//				if(dip == -1) {
//					System.out.print(" ");
//				} else {
//					System.out.print("¡ñ");
//				}
				System.out.print(dip);
			}
			System.out.println("");
		}
	}
}
