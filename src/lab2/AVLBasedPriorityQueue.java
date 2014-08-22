package lab2;

public class AVLBasedPriorityQueue<T extends Comparable<T>> {
	
	Node<T> root;
	int size;
	public AVLBasedPriorityQueue() {
		root = null;
		size = 0;
	}
	
	public boolean offer(T data) {
		boolean successful = false;
		if(offer(root, root, data)) {
			root = checkBalance(root);
			successful = true;
			size++;
			System.out.println("Balance Factor: " + calculateBalance(root));
		}

		return successful;
	}
	
	private boolean offer(Node<T> parent, Node<T> node, T data) {
		boolean successful = false;
		if(root == null) {
			root = new Node<T>(data);
			successful = true;
		}
		else if(node == null) {
			int comparison = data.compareTo(parent.getValue());
			node = new Node<T>(data);
			if(comparison < 0) {
				parent.setLeftNode(node);
				successful = true;
			}
			else {
				parent.setRightNode(node);
				successful = true;
			}
		}
		else {
			int comparison = data.compareTo(node.getValue());
			parent = node;
			if(comparison < 0) {
				successful = offer(parent, parent.getLeftNode(), data);
			}
			else {
				successful = offer(parent, parent.getRightNode(), data);
			}
		}
		
		return successful;
	}
	
	public int size() {
		return size;
	}
	
	public T peek() {
		return root.getValue();
	}
	
	public T poll() {
		size--;
		T temp = poll(root, root);
		root = checkBalance(root);
		return temp;
	}
	
	private T poll(Node<T> parent, Node<T> node) {
		if(parent == node && parent.hasRightNode()) {
			return poll(parent, node.getRightNode());
		}
		else if(node.hasRightNode()) {
			parent = node;
			return poll(parent, node.getRightNode());
		}
		else if(node.hasLeftNode()) {
			parent.setRightNode(node.getLeftNode());
			Node<T> temp = node;
			node = null;
			return temp.getValue();
		}
		else {
			parent.setRightNode(null);
			return node.getValue();
		}
	}
	
	private Node<T> checkBalance(Node<T> node) {
		if(node.hasLeftNode()) {
			node.setLeftNode(checkBalance(node.getLeftNode()));
		}
		if(node.hasRightNode()) {
			node.setRightNode(checkBalance(node.getRightNode()));
		}
		
		if(calculateBalance(node) >= 2) {
			if(calculateBalance(node.getLeftNode()) <= -1) {
				node.setLeftNode(rotateLeft(node.getLeftNode()));
				return rotateRight(node);
			}
			else {
				return rotateRight(node);
			}
		}
		else if(calculateBalance(node) <= -2) {
			if(calculateBalance(node.getRightNode()) >= 1) {
				node.setRightNode(rotateRight(node.getRightNode()));
				return rotateLeft(node);
			}
			else {
				return rotateLeft(node);
			}
		}
		else {
			return node;
		}
	}

	private int calculateBalance(Node<T> node) {
		int balance = 0;
		if(node.isLeaf()) {
			return balance;
		}
		else if(!node.hasLeftNode() && node.hasRightNode()) {
			return -node.getRightNode().height() -1;
		}
		else if(!node.hasRightNode() && node.hasLeftNode()) {
			return node.getLeftNode().height() + 1;
		}
		else {
			return (node.getLeftNode().height() + 1) - (node.getRightNode().height() + 1);
		}
	}
	
	private Node<T> rotateRight(Node<T> root) {
		Node<T> pivot = root.getLeftNode();
//		if(pivot.getRightNode() != null) {
			root.setLeftNode(pivot.getRightNode());
//		}
		pivot.setRightNode(root);
		return pivot;
	}
	
	private Node<T> rotateLeft(Node<T> root) {
		Node<T> pivot = root.getRightNode();
//		if(pivot.getLeftNode() != null) {
			root.setRightNode(pivot.getLeftNode());
//		}
		pivot.setLeftNode(root);
		return pivot;
	}
	
	public void preOrder() {
		preOrder(root);
	}
	
	private void preOrder(Node<T> node) {
		System.out.print(node.getValue() + ", " );
		if(node.hasLeftNode())
			preOrder(node.getLeftNode());
		if(node.hasRightNode())
			preOrder(node.getRightNode());
	}

}
