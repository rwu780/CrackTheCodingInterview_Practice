package interviewQuestions.chapter2.linkedLists;

import java.util.HashMap;
import java.util.Set;

public class Intersection<T> {
	/**
	 * Given two(singly) linked lists. determine if the two lists intersect.
	 * Return the intersecting node.
	 */
	
	public Node<T> returnIntersectNodes(Node<T> head1, Node<T> head2){
		HashMap<T, Integer> hashMap = new HashMap<T, Integer>();
		
		while(head1 != null) {
//			if(hashMap.containsKey(head1.getValue())) {
			hashMap.put(head1.getValue(), 1);
//			}
			head1 = head1.getNext();
		}
		
		while(head2 != null) {
			if(hashMap.containsKey(head2.getValue())) {
				int value = hashMap.get(head2.getValue()) - 1;
				hashMap.replace(head2.getValue(), value);
			}
			head2 = head2.getNext();
		}
		
		Node<T> newHead = null;
		Node<T> next = null;
		Set<T> keys = hashMap.keySet();
		for(T n : keys) {
			if(hashMap.get(n) == 0) {
				if(newHead == null) {
					newHead = new Node<T>(n);
				}
				else if(next == null) {
					next = new Node<T>(n);
					newHead.setNext(next);
				}
				else {
					next = new Node<T>(n);
					next.setNext(next);
				}
			}
		}
				
		return newHead;
	}
	
	
	public static void main(String[] args) {
		Intersection<Integer> intersection = new Intersection<>();

		
		Node<Integer> head1 = new Node<Integer>(0);
		head1.setNext(new Node<Integer>(1));
		head1.getNext().setNext(new Node<Integer>(5));
		head1.getNext().getNext().setNext(new Node<Integer>(9));
		System.out.println("Head1: ");
		head1.printNode();
		
		Node<Integer> head2 = new Node<Integer>(1);
		head2.setNext(new Node<Integer>(4));
		head2.getNext().setNext(new Node<Integer>(7));
		head2.getNext().getNext().setNext(new Node<Integer>(9));
		System.out.println("Head2: ");
		head2.printNode();
		
		Node<Integer> intersectionHead = intersection.returnIntersectNodes(head1, head2);
		System.out.println("Intersection: ");
		intersectionHead.printNode();
		
		
		
	}

}
