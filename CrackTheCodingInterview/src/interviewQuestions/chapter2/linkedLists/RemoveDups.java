package interviewQuestions.chapter2.linkedLists;

import java.util.HashMap;

public class RemoveDups<T> {
	
	HashMap<T, Integer> hm;

	public RemoveDups() {
		hm = new HashMap<>();
	}
	
	public void removeDupWithBuffer(Node<T> head) {
		hm.clear();
		hm.put(head.getValue(), 1);
		
		while(head != null) {
			if(head.getNext() == null) {
				break;
			}
			Node<T> next = head.getNext();
			
			if(hm.containsKey(next.getValue())) {
				//Duplicate
				Node<T> newNext = next.getNext();
				while(newNext != null && hm.containsKey(newNext.getValue())) {
					newNext = newNext.getNext();
				}
				head.setNext(newNext);
			}
			else {
				hm.put(next.getValue(), 1);
			}
			head = head.getNext();
		}		
	}
	
	public void printNode(Node<T> head){

		while(head != null){
			if(head.getNext() == null){
				// Handle Last Value
				System.out.println(head.getValue());
			}
			else{
				// Handle intermediate Values
				System.out.print(head.getValue() + " -> ");
			}
			head = head.getNext();
		}
	}
	
	public static void main(String[] args) {
		RemoveDups<Integer> rd = new RemoveDups<>();
		
		Node<Integer> head = new Node<Integer>(0);
		Node<Integer> next = new Node<Integer>(1);
		head.setNext(next);
		
		for (int i = 2; i <= 10; i++) {
			Node<Integer> newNode = new Node<Integer>((i+1) % 5);
			next.setNext(newNode);
			next = next.getNext();
		}
		
//		next.setNext(new Node<Integer>(10));
		
		rd.printNode(head);
		
		rd.removeDupWithBuffer(head);
		rd.printNode(head);
		
		
	}
	
	

	
}
