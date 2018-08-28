package chapterVII_technicalQuestions;

import java.util.LinkedList;
import java.util.Queue;

public class BreathFirstSearch {
	
	Queue<BFS_Node> queue;
	
	BreathFirstSearch(){
		queue = new LinkedList<BFS_Node>();
	}
	
	public BFS_Node search(BFS_Node root, int value) throws Exception {
		
		if(root == null) {
			throw new Exception("Root is null");
		}
		
		queue.clear();
		queue.add(root);
		
		StringBuilder sb = new StringBuilder();
		
		while(!queue.isEmpty()) {
			BFS_Node node = queue.remove();
			
			if(node.getValue() == value) {
				sb.append(node.getValue());
				System.out.println(sb.toString());
				
				return node;
			}
			
			sb.append(node.getValue());
			sb.append(" > ");
			
			if(node.getLeft() != null) {
				queue.add(node.getLeft());
			}
			if(node.getRight() != null) {
				queue.add(node.getRight());
			}
		}
		
		throw new Exception("Node not exists");
		
	}
	
	public static void main(String[] args) throws Exception {
		BFS_Node root = new BFS_Node(5);
		BFS_Node left = new BFS_Node(3);
		BFS_Node right = new BFS_Node(8);
		root.left = left;
		root.right = right;
		
		left.left = new BFS_Node(1);
		left.right = new BFS_Node(4);
		
		right.left = new BFS_Node(6);
		right.right = new BFS_Node(10);
		
		int value = 10;
		
		BreathFirstSearch bfs = new BreathFirstSearch();
		BFS_Node node = bfs.search(root, value);
		System.out.println("Value: " + node.value);
			
	}

}

class BFS_Node {
	int value;
	BFS_Node left;
	BFS_Node right;
	
	BFS_Node(int value)
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

	public BFS_Node getLeft() {
		return left;
	}

	public void setLeft(BFS_Node left) {
		this.left = left;
	}

	public BFS_Node getRight() {
		return right;
	}

	public void setRight(BFS_Node right) {
		this.right = right;
	}

}