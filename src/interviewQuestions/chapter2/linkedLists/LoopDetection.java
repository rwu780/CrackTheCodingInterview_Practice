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
		hashmap.clear();
		while(head != null){
			if(hashmap.containsKey(head.getValue())){
				return true;
			}
			else {
				hashmap.put(head.getValue(), 1);
			}
			head = head.getNext();
		}
		return false;
	}
	
	public boolean loopDetectionWithoutBuffer(Node<Integer> head) {
		
		Node<Integer> fastRunner = head;
		Node<Integer> slowRunner = head;
		
		while(fastRunner.getNext() != null) {
			
			if(fastRunner.getNext().getNext() != null) {
				fastRunner = fastRunner.getNext().getNext();
				slowRunner = slowRunner.getNext();
				
				System.out.println("Fast Runner: " + fastRunner.getValue());
				System.out.println("Slow Runner: " + slowRunner.getValue());
				
				if(fastRunner.getValue() == slowRunner.getValue()) {
					return true;
				}
			}
			else {
				return false;
			}
			
			
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		LoopDetection lp = new LoopDetection();
		
		Node<Integer> head = new Node<Integer>(0);
		Node<Integer> next = new Node<Integer>(1);
		head.setNext(next);
		Random ran = new Random();
		
		Node<Integer> loopNode = null;
		boolean loop = false;
		int length = ran.nextInt(10);
		
		for (int i = 2; i < length; i++) {
			Node<Integer> newNode = new Node<Integer>(i);
			next.setNext(newNode);
			next = next.getNext();
			if(ran.nextBoolean() && !loop) {
				loopNode = newNode;
				loop = true;
			}
		}
		if(ran.nextBoolean()) {
			next.setNext(loopNode);
		}
		head.printLoopNode();
		System.out.println("Loop Detection with buffer: " + lp.loopDetectionWithBuffer(head));
		System.out.println("Loop Detection without buffer: " + lp.loopDetectionWithoutBuffer(head));
	}
	
	
	
}
