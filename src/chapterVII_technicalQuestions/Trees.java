package chapterVII_technicalQuestions;

public class Trees {
	
	Node root;
	
	public Node createTree() {
		root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(15);
		root.left.left = new Node(1);
		root.left.right = new Node(8);
		
		root.right.left = new Node(12);
		root.right.right = new Node(20);
		
		return root;
	}
	
	public static void main(String[] args) {
		
	}
	
	

}
