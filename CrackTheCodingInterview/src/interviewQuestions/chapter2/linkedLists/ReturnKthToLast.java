package interviewQuestions.chapter2.linkedLists;

public class ReturnKthToLast<T> {
	
	public Node<T> returnKthToLast(Node<T> head, int k){
		int i = 0;
		while(i < k) {
			if(head.getNext() != null) {
				head = head.getNext();
			}
			i++;
		}
		
		return head;
	}
	
	
	public static void main(String[] args) {
		ReturnKthToLast<Integer> rk = new ReturnKthToLast<>();
		
		Node<Integer> head = new Node<Integer>(0);
		Node<Integer> next = new Node<Integer>(1);
		head.setNext(next);
		
		for (int i = 2; i <= 10; i++) {
			Node<Integer> newNode = new Node<Integer>(i);
			next.setNext(newNode);
			next = next.getNext();
		}
		head.printNode();
		Node<Integer> kth = rk.returnKthToLast(head, 3);
		kth.printNode();
	}

}
