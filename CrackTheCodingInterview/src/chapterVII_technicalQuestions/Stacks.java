package chapterVII_technicalQuestions;

import java.util.ArrayList;
import java.util.List;

public class Stacks<T> {
	
	List<T> stacks;
	
	Stacks(){
		stacks = new ArrayList<T>();
	}
	
	public boolean empty() {
		return stacks.isEmpty();
	}
	
	public T pop() {
		T popItem = stacks.get(0);
		stacks.remove(0);
		return popItem;
	}
	
	public T peek() {
		return stacks.get(0);
	}
	
	public void push(T item) {
		stacks.add(0, item);
	}
	
	public int search(T item) {
		for (int i = 0; i < stacks.size(); i++) {
			if(item == stacks.get(i)) {
				return i+1;
			}
		}
		return -1;	
	}
	
	
	public static void main(String[] args) {
		Stacks<Integer> stack = new Stacks<Integer>();
		
		System.out.println("Is stack empty? " + stack.empty());
		stack.push(0);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		System.out.println("Is stack empty? " + stack.empty());
		System.out.println("First Element on the stack " + stack.peek());
		while(!stack.empty()) {
			System.out.println(stack.pop());
		}
	}
}
