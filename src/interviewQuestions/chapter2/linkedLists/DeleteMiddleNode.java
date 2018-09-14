package interviewQuestions.chapter2.linkedLists;

public class DeleteMiddleNode<T> {

	public void findMiddle(Node<T> head) {
		if(head == null) {
			return;
		}
		
		Node<T> slowRunner = head;
		Node<T> fastRunner = head;
		
		while(fastRunner.getNext() != null) {
			if(fastRunner.getNext().getNext() != null) {
				fastRunner = fastRunner.getNext().getNext();
				if(fastRunner.getNext() == null) {
					slowRunner.setNext(slowRunner.getNext().getNext());
				}
				else {
					slowRunner = slowRunner.getNext();
				}
			}else {
				slowRunner.setNext(slowRunner.getNext().getNext());
				return;
			}
		}	
	}
	
	public static void main(String[] args) {
		DeleteMiddleNode<Integer> dmn = new DeleteMiddleNode<>();
		
		Node<Integer> head = new Node<Integer>(0);
		Node<Integer> next = new Node<Integer>(1);
		head.setNext(next);
		
		for (int i = 2; i < 10; i++) {
			Node<Integer> newNode = new Node<Integer>(i);
			next.setNext(newNode);
			next = next.getNext();
		}
		head.printNode();
		dmn.findMiddle(head);
		head.printNode();
	}
}
