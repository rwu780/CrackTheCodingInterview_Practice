package interviewQuestions.chapter1.arraysAndStrings;

import java.util.HashMap;
import java.util.Set;

public class PalindromePermutation {
	
	HashMap<Character, Integer> hm;

	public PalindromePermutation() {
		hm = new HashMap<Character, Integer>();
	}

	public boolean check(String s) {
		s = s.toLowerCase();
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(hm.containsKey(c)) {
				int value = hm.get(c) + 1;
				hm.replace(c, value);
			}else {
				hm.put(c, 1);
			}
		}
		
		Set<Character> keys = hm.keySet();
		boolean singletons = false;
		for(Character c: keys) {
			if(hm.get(c) % 2 != 0) {
				if(singletons) {
					return false;
				}
				singletons = true;
			}
		}
		return true;
		
	}
	
	public static void main(String[] args) {
		PalindromePermutation pp = new PalindromePermutation();
		
		String s = "Tactcoa";
		System.out.println("String: " + s + ", is a permutation of a palidrome " + pp.check(s));
	
	}

}
