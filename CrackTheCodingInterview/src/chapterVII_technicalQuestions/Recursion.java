package chapterVII_technicalQuestions;

public class Recursion {
	
	public void recursive(int i) {
		if(i > 0) {
			recursive(i - 1);
			System.out.println("Number: " + i);
		}
	}
	
	public static void main(String[] args) {
		Recursion recursion = new Recursion();
		recursion.recursive(5);
		
	}

}
