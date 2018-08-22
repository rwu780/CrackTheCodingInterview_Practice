package chapterVII_technicalQuestions;

import java.util.LinkedList;
import java.util.Queue;

public class BreathFirstSearch {
	
	public Node BFS(Node root, int value) throws Exception {
		
		if(root == null) {
			throw new Exception("Root node is null");
		}
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			Node node = queue.remove();
			
			
			if(node.value == value) {
				System.out.println(node.value);
				return node;
			}
			if(node.left != null) {
				queue.add(node.left);
			}
			if(node.right != null) {
				queue.add(node.right);
			}
			System.out.print(node.value + " > ");

		}
		throw new Exception("Node does not exist");
	}
	
	
	public static void main(String[] args)  {
		Trees tree = new Trees();
		
		Node root = tree.createTree();
		BreathFirstSearch bfs = new BreathFirstSearch();
		
		int value = 5;
		try {
			bfs.BFS(root, value);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		value = 20;
		try {
			bfs.BFS(root, value);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		value = 200;
		try {
			bfs.BFS(root, value);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		value = 200;
		try {
			bfs.BFS(null, value);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
