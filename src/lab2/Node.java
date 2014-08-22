package lab2;

public class Node<T extends Comparable<T>> {
	T value;
	Node<T> left;
	Node<T> right;
	
	public Node(T value) {
		left = null;
		right = null ;
		this.value = value;
	}
	
	public T getValue() {
		return value;
	}
	
	public void setValue(T value) {
		this.value = value;
	}
	
	public Node<T> getLeftNode() {
		return left;
	}
	
	public Node<T> getRightNode() {
		return right;
	}
	
	public void setLeftNode(Node<T> nextValue) {
		this.left = nextValue;
	}
	
	public void setRightNode(Node<T> nextValue) {
		this.right = nextValue;
	}
	
	public boolean hasLeftNode() {
		if(left != null)
			return true;
		else
			return false; 
	}
	
	public boolean hasRightNode() {
		if(right != null)
			return true;
		else
			return false; 
	}
	
	public boolean isLeaf() {
		if(hasRightNode() || hasLeftNode())
			return false;
		else
			return true;
	}
	
	public int height() {
		int height = 0;
		if(isLeaf()) {
			return height;
		}
		else if(!hasLeftNode() && hasRightNode()) {
			height += getRightNode().height() + 1;
		}
		else if(hasLeftNode() && !hasRightNode()) {
			height += getLeftNode().height() + 1;
		}
		else {
			if(getLeftNode().height() > getRightNode().height())
				height = getLeftNode().height() + 1;
			else
				height = getRightNode().height() + 1;
		}
		
		return height;
	}
}
