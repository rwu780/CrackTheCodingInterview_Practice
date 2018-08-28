package chapterVII_technicalQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayLists {
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(0, 4);
		list.add(3, 5);
		
		System.out.println(Arrays.toString(list.toArray()));
	}

}
