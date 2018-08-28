package chapterVII_technicalQuestions;

public class BinarySearchTree {
	
	TreeNode topRoot;
	
	public TreeNode search(int value) {
		return searchNode(topRoot, value);
	}
	
	public TreeNode searchNode(TreeNode root, int value) {
		if(root.getValue() == value) {
			return root;
		}
		if(root.getValue() > value) {
			if(root.left == null) {
				return null;
			}
			return searchNode(root.getLeft(), value);
		}
		
		if(root.getValue() < value) {
			if(root.right == null) {
				return null;
			}
			return searchNode(root.getRight(), value);
		}
		return null;
	}
	
	public void insert(int value) {
		if(topRoot == null) {
			topRoot = new TreeNode(value);
			return;
		}
		insertNode(topRoot, value);
	};
	
	public void insertNode(TreeNode root, int value) {
		if(value >= root.getValue()) {
			if(root.getRight() == null) {
				root.setRight(new TreeNode(value));
				return;
			}
			else {
				insertNode(root.getRight(), value);
			}	
		}
		if(value < root.getValue()) {
			if(root.getLeft() == null) {
				root.setLeft(new TreeNode(value));
				return;
			} else {
				insertNode(root.getLeft(), value);
			}
		}
	}
	
	public void delete(int value) {
		if(search(value) == null) {
			return;
		}
		deleteNode(topRoot, value);
	}
	
	public TreeNode deleteNode(TreeNode root, int value) {
		if(root == null) {
			return null;
		}
		
		if(root.getValue() == value) {
			if(root.getLeft() == null && root.getRight() == null) {
				// Both Left and Right Child are null
				// Directly Remove
				return null;
			}
			else if(root.getLeft() == null && root.getRight() != null) {
				// Replace with right child
				return root.getRight();
			}
			else if(root.getLeft() != null && root.getRight() == null) {
				// Replace with Left Child
				return root.getLeft();
			}
			else {
				//Replace with Smallest value on the right sub tree;
				int minValue = smallest(root.right);
				root.setValue(minValue);
				root.setRight(deleteNode(root.right, minValue));
				return root;
			}
		}
		if(root.getValue() > value) {
			root.setLeft(deleteNode(root.left, value));
		}
		if(root.getValue() < value) {
			root.setRight(deleteNode(root.right, value));
		}
		
		return root;
	}
	
	public int smallest(TreeNode root) {
		if(root.left != null) {
			return smallest(root.left);
		}
		else {
			return root.getValue();
		}
	}
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		
		bst.insert(5);
		bst.insert(1);
		bst.insert(10);
		bst.insert(3);
		bst.insert(20);
		bst.insert(30);
		
		System.out.println("Program End");
		
//		bst.delete(5);
		bst.delete(20);
		
		System.out.println("Program End");
		
	}
}

class TreeNode {
	TreeNode left;
	TreeNode right;
	int value;
	
	TreeNode(int v){
		this.value = v;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}