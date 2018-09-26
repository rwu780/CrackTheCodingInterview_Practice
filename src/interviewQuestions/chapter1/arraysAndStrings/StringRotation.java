package interviewQuestions.chapter1.arraysAndStrings;

import java.util.LinkedList;

public class StringRotation {
	
	LinkedList<Character> string1;
	LinkedList<Character> string2;
	
	
	
	public StringRotation() {
		string1 = new LinkedList<>();
		string2 = new LinkedList<>();
	}
	
	public boolean check(String s1, String s2) {
		if(s1.length() != s2.length()) {
			return false;
		}
		
		for(int i = 0; i < s1.length(); i++) {
			string1.add(s1.charAt(i));
			string2.add(s2.charAt(i));
		}
		
		while(string1.peek() != string2.peek()) {
			Character c = string2.remove();
			string2.add(c);
		}
		
		while(!string1.isEmpty()) {
			Character c1 = string1.remove();
			Character c2 = string2.remove();
			if(c1 != c2) {
				return false;
			}
		}
		if(!string2.isEmpty()) {
			return false;
		}
		return true;
	}



	public static void main(String[] args) {
		StringRotation sr = new StringRotation();
		
		String s1 = "waterbottle";
		String s2 = "erbottlewat";
		
		System.out.println("Is " + s1 + " rotation of " + s2 + " : " + sr.check(s1, s2));
		
		s1 = "waterbotele";
		s2 = "erbottlewat";
		
		System.out.println("Is " + s1 + " rotation of " + s2 + " : " + sr.check(s1, s2));
		
	}

}
