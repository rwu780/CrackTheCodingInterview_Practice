package interviewQuestions.chapter2.linkedLists;

import java.util.HashMap;
import java.util.Random;

public class LoopDetection {
	/**
	 * Given a circular linked list, implement an algorithm that returns the
	 * node at the beginning of the loop
	 */
	HashMap<Integer, Integer> hashmap;
	
	public LoopDetection(){
		hashmap = new HashMap<Integer, Integer>();
	}
	
	public boolean loopDetectionWithBuffer(Node<Integer> head){
		
		while(head != null){
			if(hashmap.containsKey(head.getValue())){
				return true;
			}
			head = head.getNext();
		}
		return false;
	}
	
	public static void main(String[] args) {
		LoopDetection lp = new LoopDetection();
		
		Node<Integer> head = new Node<Integer>(0);
		Node<Integer> next = new Node<Integer>(1);
		head.setNext(next);
		Random ran = new Random();
		
		for (int i = 2; i < 10; i++) {
			Node<Integer> newNode = new Node<Integer>(ran.nextInt(10));
			next.setNext(newNode);
			next = next.getNext();
		}
		head.printNode();
		System.out.println("Loop Detection: " + lp.loopDetectionWithBuffer(head));
//		head.printNode();
	}
	
	
	
}
