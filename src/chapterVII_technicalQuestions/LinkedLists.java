package chapterVII_technicalQuestions;

class LinkedLists {
	
	private class LinkedListNode{
		int value;
		LinkedListNode next;
		
		LinkedListNode(int value){
			this.value = value;
		}
		
	}
	
	public LinkedListNode createLinkedList() {
		LinkedListNode head = new LinkedListNode(0);
		
		LinkedListNode nextNode = head;
		
		for (int i = 1; i < 10; i++) {
			LinkedListNode newNode = new LinkedListNode(i);
			nextNode.next = newNode;
			nextNode = nextNode.next;
		}
		return head;
		
	}
	
	public void printLinkedList(LinkedListNode node) {
		while(node != null) {
			if(node.next == null) {
				System.out.println(node.value);
			}
			else {
				System.out.print(node.value + " -> ");
			}
			node = node.next;
		}
	}
	
	
	public static void main(String[] args) {
		LinkedLists ll = new LinkedLists();
		LinkedListNode head = ll.createLinkedList();
		ll.printLinkedList(head);
		
	}
	
	
	
}


