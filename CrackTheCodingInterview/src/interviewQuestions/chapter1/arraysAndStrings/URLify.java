package interviewQuestions.chapter1.arraysAndStrings;

public class URLify {
	
	public String stringURLify(String s, int length) {
		int resultLength = length;
		for (int i = 0; i < length; i++) {
			if(s.charAt(i) == ' '){
				resultLength += 2;
			}
		}
		
		char[] c_array = new char[resultLength];
		
		int original_index = 0;
		int new_index = 0;
		while(original_index < length) {
			char c = s.charAt(original_index);
			if(c == ' ') {
				c_array[new_index] = '%';
				c_array[new_index+1] = '2';
				c_array[new_index+2] = '0';
				new_index += 3;
			} else {
				c_array[new_index] = c;
				new_index ++;
			}
			original_index ++;
		}
		
		return new String(c_array);
	}
	
	public static void main(String[] args) {
		URLify url = new URLify();
		
		System.out.println(url.stringURLify("Mr John Smith       ", 13));
	}

}
