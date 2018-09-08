package interviewQuestions.chapter1.arraysAndStrings;

public class StringCompression {
	
	public String compressString(String s) {
		StringBuilder sb = new StringBuilder();
		
		char prev = s.charAt(0);
		int count = 1;
		for (int i = 1; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c == prev) {
				count ++;
			} else {
				sb.append(prev);
				sb.append(count);
				count = 1;
			}
			prev = c;
		}
		
		sb.append(prev);
		sb.append(count);
		
		String compressed = sb.toString();
		if(compressed.length() > s.length()) {
			return s;
		}
		return compressed;
	}
	
	public static void main(String[] args) {
		StringCompression sc = new StringCompression();
		
		String s = "aabcccccaaa";
		System.out.println("Compress " + s + " into: " + sc.compressString(s));
		
		s = "abcde";
		System.out.println("Compress " + s + " into: " + sc.compressString(s));
	}

}
