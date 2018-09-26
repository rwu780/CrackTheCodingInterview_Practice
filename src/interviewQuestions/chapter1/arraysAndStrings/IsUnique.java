package interviewQuestions.chapter1.arraysAndStrings;

public class IsUnique {

	boolean[] unique;
	
	public boolean isUniqueWithDataStructure(String s) {
		unique = new boolean[26];
		s = s.toLowerCase();
		for(int i = 0; i < s.length(); i++) {
			int c_index = s.charAt(i) - 97;
			if(unique[c_index] == true) {
				return false;
			}
			unique[c_index] = true;
		}
		return true;
		
	}
	
	public boolean isUniqueWithoutDataStructure(String s) {
		byte u = 0;
		s = s.toLowerCase();
		for (int i = 0; i < s.length(); i++) {
			int c_index = s.charAt(i) - 97;
			if((u & (1 << c_index)) == 1) {
				return false;
			}
			
			u = (byte) (u | (1 << c_index));
		}
		
		return true;
		
	}
	
	public static void main(String[] args) {
		IsUnique iu = new IsUnique();
		
		String s = "abcdeagdvcgtsraegsfd";
		System.out.println("String: " + s + ", is unique? " + iu.isUniqueWithDataStructure(s));
		
		String s1 = "abcde";
		System.out.println("String: " + s1 + ", is unique? " + iu.isUniqueWithDataStructure(s1));
		
		String s2 = "abcdeagdvcgtsraegsfd";
		System.out.println("String: " + s2 + ", is unique? " + iu.isUniqueWithoutDataStructure(s2));
		
		String s3 = "abcde";
		System.out.println("String: " + s3 + ", is unique? " + iu.isUniqueWithoutDataStructure(s3));
	}
}
