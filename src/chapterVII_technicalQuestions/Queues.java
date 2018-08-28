package chapterVII_technicalQuestions;

import java.util.ArrayList;
import java.util.List;

public class Queues<T> {
	
	List<T> queue;
	
	Queues(){
		queue = new ArrayList<T>();
	}
	
	public boolean empty() {
		return queue.isEmpty();
	}
	
	public boolean add(T element) {
		return queue.add(element);
	}
	
	public T element() {
		return queue.get(0);
	}
	
	public T peek() {
		if(queue.isEmpty()) {
			return null;
		}
		return queue.get(0);
	}
	
	public T poll() {
		if(queue.isEmpty()) {
			return null;
		}
		T element = queue.get(0);
		queue.remove(0);
		return element;
	}
	
	public T remove() {
		T element = queue.get(0);
		queue.remove(0);
		return element;
	}
	
	public static void main(String[] args) {
		Queues<Integer> queue = new Queues<Integer>();
		
		System.out.println("Is stack empty? " + queue.empty());
		queue.add(0);
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);
		
		System.out.println("Is queue empty? " + queue.empty());
		System.out.println("First Element on the queue " + queue.peek());
		while(!queue.empty()) {
			System.out.println(queue.remove());
		}
	}

}
