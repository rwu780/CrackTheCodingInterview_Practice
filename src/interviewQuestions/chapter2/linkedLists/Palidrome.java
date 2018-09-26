package interviewQuestions.chapter2.linkedLists;

import java.util.Stack;

public class Palidrome {
	/**
	 * Implement a function to check if a linked list is a palidrome
	 */
	
	Stack<Integer> stack;
	
	public Palidrome() {
		stack = new Stack<Integer>();
	}


	public boolean checkPalidrome(Node<Integer> head) {
		stack.clear();
		
		Node<Integer> pointer = head;
		
		while(pointer != null) {			
			stack.push(pointer.getValue());
			pointer = pointer.getNext();
		}
		
		while(head != null) {
			int value = stack.pop();
			if(value != head.getValue()) {
				return false;
			}
			head = head.getNext();
		}
		return true;
	}
	

	public static void main(String[] args) {
		Palidrome p = new Palidrome();
		
		Node<Integer> head = new Node<Integer>(0);
		Node<Integer> node2 = new Node<Integer>(1);
		head.setNext(node2);
		Node<Integer> node3 = new Node<Integer>(2);
		node2.setNext(node3);
		Node<Integer> node4 = new Node<Integer>(3);
		node3.setNext(node4);
		Node<Integer> node5 = new Node<Integer>(4);
		node4.setNext(node5);
		Node<Integer> node6 = new Node<Integer>(4);
		node5.setNext(node6);
		Node<Integer> node7 = new Node<Integer>(3);
		node6.setNext(node7);
		Node<Integer> node8 = new Node<Integer>(2);
		node7.setNext(node8);
		Node<Integer> node9 = new Node<Integer>(1);
		node8.setNext(node9);
		Node<Integer> node10 = new Node<Integer>(0);
		node9.setNext(node10);
		
		head.printNode();
		
		System.out.println("Check palidrome " + p.checkPalidrome(head));
	}
}
