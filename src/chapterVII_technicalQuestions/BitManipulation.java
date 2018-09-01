package chapterVII_technicalQuestions;

import java.util.Random;

public class BitManipulation {

	public static void main(String[] args) {
		
		// 0001 << 1 = 0010
		System.out.println("1 << 1 is " + (1 << 1));
		
		// 0001 << 3 => 1000
		System.out.println("1 << 3 is " + (1 << 3));
		
		// 1111 1111 1111 >> 4 0000 1111 1111
		System.out.println("0XFFF >> 4 expect: " + 0xFF + ", actual: " + (0XFFF >> 4));
		
		byte b = (byte) 64;
		System.out.println(b >> 6);
		
		Random ranString = new Random();
		
		StringBuilder sb = new StringBuilder();
		int i = 1;
		while(i < 10){
			int n = ranString.nextInt(25);
			i ++;
			sb.append(String.valueOf((char) (n+65)));
		}
		
		String s = sb.toString();
		System.out.println(sb.toString());
		
		// 0000 0000 0000 0000 0000 0000 0000
		byte repeated = 0x0000000;
		
		for (int j = 0; j < s.length(); j++) {
			int c = (int) s.charAt(j) - 65;
			
			repeated = (byte) (repeated | (1 << c)); 
			// 64 0x000 0000
			System.out.println("c is " + c +" " + repeated);

		}
		
		System.out.println(repeated);
	}
}
