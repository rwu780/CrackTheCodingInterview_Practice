package interviewQuestions.chapter13.Java;

public class PrivateConstructor {

	private PrivateConstructor() {
	}
	
	public static void returnFinally() {
		
		try {
			int i = 10 / 20;
			System.out.println("i: " + i);
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("Print Finally");
		}
		
	}
	
	public static void main(String[] args) {
		returnFinally();
	}
	

}

//class childClass extends PrivateConstructor{
//	
//}
