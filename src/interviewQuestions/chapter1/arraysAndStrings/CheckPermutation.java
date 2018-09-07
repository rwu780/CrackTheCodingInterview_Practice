package interviewQuestions.chapter1.arraysAndStrings;

import java.util.HashMap;

public class CheckPermutation {
	
	HashMap<Character, Integer> hm;

	public CheckPermutation() {
		hm = new HashMap<Character, Integer>();
	}

	public boolean checkPermutationOfTwoString(String s1, String s2) {
		hm.clear();
		if(s1.length() != s2.length()) {
			return false;
		}
		
		for(int i = 0; i < s1.length(); i++) {
			char c = s1.charAt(i);
			if(hm.containsKey(c)) {
				int value = hm.get(c) + 1;
				hm.replace(c, value);
			} else {
				hm.put(c, 1);
			}
		}
		
		for(int i = 0; i < s2.length(); i++) {
			char c = s2.charAt(i);
			if(!hm.containsKey(c)) {
				return false;
			}
			int value = hm.get(c) - 1;
			if(value == 0) {
				hm.remove(c);
			} else {
				hm.replace(c, value);
			}
		}
		
		if(!hm.isEmpty()) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		CheckPermutation cp = new CheckPermutation();
		
		System.out.println(cp.checkPermutationOfTwoString("abcde", "bdeca"));
		

		System.out.println(cp.checkPermutationOfTwoString("abcdee", "bdecaa"));
		

		System.out.println(cp.checkPermutationOfTwoString("abbbcccde", "bbccdebca"));
		
	}
	

}
