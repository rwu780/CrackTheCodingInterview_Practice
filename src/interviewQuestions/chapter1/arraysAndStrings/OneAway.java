package interviewQuestions.chapter1.arraysAndStrings;

import java.util.HashMap;
import java.util.Set;

public class OneAway {
	
	public boolean check(String s1, String s2) {
		if(Math.abs(s1.length() - s2.length()) > 1) {
			return false;
		}
		HashMap<Character, Integer> hm = new HashMap<>();
		
		int i = 0;
		while(i < s1.length() && i < s2.length()) {
			char c_s1 = s1.charAt(i);
			char c_s2 = s2.charAt(i);
			
			if(c_s1 == c_s2) {
				i++;
				continue;
			}
			if(hm.containsKey(c_s1)) {
				int value = hm.get(c_s1) + 1;
				hm.replace(c_s1, value);
			} else {
				hm.put(c_s1, 1);
			}
			if(hm.containsKey(c_s2)) {
				int value = hm.get(c_s2) - 1;
				hm.replace(c_s2, value);
			} else {
				hm.put(c_s2, -1);
			}
			i++;
		}
		
		Set<Character> keys = hm.keySet();
		int sum = 0;
		for(Character c: keys) {
			sum += Math.abs(hm.get(c));
		}
		
		if(sum <= 2) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		OneAway oa = new OneAway();
		
		String s = "pale";
		String s1 = "ple";
		System.out.println(oa.check(s, s1));
		
		s = "pales";
		s1 = "pale";
		System.out.println(oa.check(s, s1));
		
		s = "pale";
		s1 = "bale";
		System.out.println(oa.check(s, s1));
		
		s = "pale";
		s1 = "bake";
		System.out.println(oa.check(s, s1));
		
		
	}
}
