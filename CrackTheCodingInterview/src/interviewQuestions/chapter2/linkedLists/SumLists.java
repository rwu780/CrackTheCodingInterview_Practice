package interviewQuestions.chapter2.linkedLists;

import java.util.Stack;

public class SumLists {

	public Node<Integer> sumListReverseOrder(Node<Integer> n1, Node<Integer> n2){
		if(n1 == null) {
			return n2;
		}
		if(n2 == null) {
			return n1;
		}
		int num1 = 0;
		int num2 = 0;
		int multiplyer = 1;
		while(n1 != null) {
			num1 += n1.getValue() * multiplyer;
			multiplyer *= 10;
			n1 = n1.getNext();
		}
		multiplyer = 1;
		while(n2 != null) {
			num2 += n2.getValue() * multiplyer;
			multiplyer *= 10;
			n2 = n2.getNext();
		}
		
		int sum = num1 + num2;
		int layer = 1;
		multiplyer = 10;
		int digit = sum % 10;
		Node<Integer> newNode = new Node<Integer>(digit);
		Node<Integer> nextNode = newNode;
		sum -= digit * multiplyer / 10;
		multiplyer *= 10;
		
		while(sum != 0) {
			digit = sum % multiplyer;
			digit /= (Math.pow(10, layer));
			Node<Integer> node = new Node<Integer>(digit);
			nextNode.setNext(node);
			nextNode = node;
			sum -= digit * multiplyer / 10;
			multiplyer *= 10;
			layer += 1;
		}		
		return newNode;
	}
	public Node<Integer> sumListForwardOrder(Node<Integer> n1, Node<Integer> n2){
		Stack<Integer> stacks = new Stack<>();
		if(n1 == null) {
			return n2;
		}
		if(n2 == null) {
			return n1;
		}
		int num1 = 0;
		int num2 = 0;
		int multiplyer = 1;
		while(n1 != null) {
			stacks.push(n1.getValue());
			n1 = n1.getNext();
		}
		while(!stacks.isEmpty()) {
			num1 += stacks.pop() * multiplyer;
			multiplyer *= 10;
		}
		
		multiplyer = 1;
		while(n2 != null) {
			stacks.push(n2.getValue());
			n2 = n2.getNext();
		}
		while(!stacks.isEmpty()) {
			num2 += stacks.pop() * multiplyer;
			multiplyer *= 10;
		}
		
		int sum = num1 + num2;
		int layer = 1;
		multiplyer = 10;
		int digit = sum % 10;
		Node<Integer> endNode = new Node<Integer>(digit);
		sum -= digit * multiplyer / 10;
		multiplyer *= 10;
		
		while(sum != 0) {
			digit = sum % multiplyer;
			digit /= (Math.pow(10, layer));
			Node<Integer> prev_node = new Node<Integer>(digit);
			prev_node.setNext(endNode);
			endNode = prev_node;
			sum -= digit * multiplyer / 10;
			multiplyer *= 10;
			layer += 1;
		}		
		return endNode;
	}

	public static void main(String[] args) {
		SumLists sl = new SumLists();

		Node<Integer> n1 = new Node<>(7);
		n1.setNext(new Node<Integer>(1));
		n1.getNext().setNext(new Node<Integer>(6));

		Node<Integer> n2 = new Node<>(5);
		n2.setNext(new Node<Integer>(9));
		n2.getNext().setNext(new Node<Integer>(2));

		n1.printNode();
		System.out.println("+");
		n2.printNode();
		System.out.println("=");
		Node<Integer> result = sl.sumListReverseOrder(n1, n2);
		result.printNode();
		
		System.out.println("==========");
		n1.printNode();
		System.out.println("+");
		n2.printNode();
		System.out.println("=");
		result = sl.sumListForwardOrder(n1, n2);
		result.printNode();
	}

}
