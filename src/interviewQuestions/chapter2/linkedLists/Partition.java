package interviewQuestions.chapter2.linkedLists;

import java.util.Random;

public class Partition {
	
	public Node<Integer> partition(Node<Integer> head, int value){
		Node<Integer> leftPartition = null;
		Node<Integer> rightPartition = null;
		
		Node<Integer> leftHead = null;
		Node<Integer> rightHead = null;
		
		while(head != null) {
			if(head.getValue() < value) {
				if(leftPartition == null) {
					leftPartition = new Node<Integer>(head.getValue());
					leftHead = leftPartition;
				}
				else {
					leftPartition.setNext(new Node<Integer>(head.getValue()));
					leftPartition = leftPartition.getNext();
				}
			}
			else {
				if(rightPartition == null) {
					rightPartition = new Node<Integer>(head.getValue());
					rightHead = rightPartition;
				}else {
					rightPartition.setNext(new Node<Integer>(head.getValue()));
					rightPartition = rightPartition.getNext();
				}
			}
			head = head.getNext();
		}
		
		leftPartition.setNext(rightHead);
		return leftHead;
	}
	
	public static void main(String[] args) {
		Partition partition = new Partition();
		Random random = new Random();
		Node<Integer> head = new Node<Integer>(random.nextInt());
		Node<Integer> next = new Node<Integer>(random.nextInt());
		head.setNext(next);
		
		for (int i = 2; i <= 10; i++) {
			Node<Integer> newNode = new Node<Integer>(random.nextInt(100));
			next.setNext(newNode);
			next = next.getNext();
		}
		head.printNode();
		int pivot = random.nextInt(100);
		System.out.println(pivot);
		Node<Integer> newHead = partition.partition(head, pivot);
		
		newHead.printNode();
		
	}

}
