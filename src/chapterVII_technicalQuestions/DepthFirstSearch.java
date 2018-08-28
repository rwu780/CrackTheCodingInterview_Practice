package chapterVII_technicalQuestions;

import java.util.Stack;

public class DepthFirstSearch {
	
	Stack<DFS_Node> stack;
	
	DepthFirstSearch(){
		stack = new Stack<DFS_Node>();
	}
	
	public DFS_Node search(DFS_Node root, int value) throws Exception{
		
		if(root == null) {
			throw new Exception("Root is null");
		}
		
		stack.clear();
		stack.add(root);
		
		StringBuilder sb = new StringBuilder();
		
		while(!stack.isEmpty()) {
			DFS_Node node = stack.pop();
			if(node.getValue() == value) {
				
				sb.append(node.getValue());
				System.out.println(sb.toString());
				
				return node;
			}
			
			sb.append(node.getValue());
			sb.append(" > ");
			
			if(node.getRight() != null) {
				stack.add(node.getRight());
			}
			if(node.getLeft() != null) {
				stack.add(node.getLeft());
			}
		}
		
		throw new Exception("Node not exists");
	}

	public static void main(String[] args) throws Exception{
		DFS_Node root = new DFS_Node(5);
		DFS_Node left = new DFS_Node(3);
		DFS_Node right = new DFS_Node(8);
		root.left = left;
		root.right = right;
		
		left.left = new DFS_Node(1);
		left.right = new DFS_Node(4);
		
		right.left = new DFS_Node(6);
		right.right = new DFS_Node(10);
		
		int value = 10;
		
		DepthFirstSearch dfs = new DepthFirstSearch();
		DFS_Node node = dfs.search(root, value);
		System.out.println("Value: " + node.value);
	}
}

class DFS_Node {
	int value;
	DFS_Node left;
	DFS_Node right;
	
	DFS_Node(int value)
	{
		this.value = value;
		left = null;
		right = null;
	}
	

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public DFS_Node getLeft() {
		return left;
	}

	public void setLeft(DFS_Node left) {
		this.left = left;
	}

	public DFS_Node getRight() {
		return right;
	}

	public void setRight(DFS_Node right) {
		this.right = right;
	}

}
