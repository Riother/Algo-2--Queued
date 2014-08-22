package lab2;

import edu.neumont.io.Bits;

public class AVLHuffmanTree {
	AVLFrequencyData root;
	boolean useNumbers;
	
	public AVLHuffmanTree(byte[] bytes, boolean useNumbers) {
		this.useNumbers = useNumbers;
//		createTree(generateFrequencies(bytes));
		generateFrequencies(bytes);
	}
	
	public AVLHuffmanTree(AVLBasedPriorityQueue<AVLFrequencyData> data, boolean useNumbers) {
		this.useNumbers = useNumbers;
		createTree(data);
	}
	
	private AVLBasedPriorityQueue<AVLFrequencyData> generateFrequencies(byte[] bytes) {
		AVLFrequencyData frequency;
		AVLBasedPriorityQueue<AVLFrequencyData> frequencies = new AVLBasedPriorityQueue<AVLFrequencyData>();
		int[] symbols = new int[256];
		for(int i = 0; i < bytes.length; i++) {
			symbols[bytes[i]] ++;
		}
		System.out.println("Generating Frequencies!");
		for(int i = 0; i < 256; i++) {
			if(symbols[i] > 0) {
				frequency = new AVLFrequencyData((byte)i, symbols[i], useNumbers);
				frequencies.offer(frequency);
				System.out.println("Symbol: " + frequency.getName() + " Frequency: " + symbols[i]);
			}
		}
		System.out.println("Frequencies Generated!");
		System.out.println();
		frequencies.preOrder();
		return frequencies;
	}
	
	private void createTree(AVLBasedPriorityQueue<AVLFrequencyData> frequencies) {
		AVLFrequencyData parent;
		AVLFrequencyData child1;
		AVLFrequencyData child2;
		System.out.println("Creating Tree");
//		int size = frequencies.size();
//		for(int i = 0; i < size; i++) {
//			System.out.println(frequencies.poll().getName());
//		}
		while(frequencies.size() >= 2) {
			child1 = frequencies.poll();
			child2 = frequencies.poll();
			System.out.println("Child 1 Value: " + child1.getName() + " Frequency: " + child1.getFrequency());
			System.out.println("Child 2 Value: " + child2.getName() + " Frequency: " + child2.getFrequency());
			System.out.println();
			byte data = (byte) (child1.getData() + child2.getData());
			int combinedFrequency = child1.getFrequency() + child2.getFrequency();
			parent = new AVLFrequencyData(data, combinedFrequency, useNumbers);
			parent.setName(child1.getName(), child2.getName());
			parent.setLeftNode(child1);
			parent.setRightNode(child2);
			frequencies.offer(parent);
		}
		
		System.out.println("Tree Created");
		System.out.println();
		root = frequencies.poll();
	}
	
	public void printOut() {
		printOut(root);
	}
	
	private void printOut(AVLFrequencyData root) {
		System.out.println("Value    :" + root.getName());
		System.out.println("Frequency: " + root.getFrequency());
		if(root.isLeaf())
			System.out.println("Is Root  : True");
		else
			System.out.println("Is Root  : False");	
		
		System.out.println("---------------------------");
		
		if(root.hasLeftValue()) {
			printOut(root.getLeftNode());
		}
		if(root.hasRightValue()) {
			printOut(root.getRightNode());
		}
	}
	
	public byte toByte(Bits bits) {
		byte b = toByte(root, bits);
		return b;
	}
	
	private byte toByte(AVLFrequencyData root, Bits bits) {
		if(!root.isLeaf()) {
			if(bits.poll()) {
				return toByte(root.getRightNode(), bits);
			}
			else {
				return toByte(root.getLeftNode(), bits);
			}
		}
		else {
			return root.getData();
		}
	}
	
	public void fromByte(byte b, Bits bits) { 
		fromByte(root, b, bits);
		
	}

	private boolean fromByte(AVLFrequencyData root, byte b, Bits bits) {
		if(!root.isLeaf()) {
			if(fromByte(root.getLeftNode(), b, bits)) {
				bits.addFirst(false);
				return true;
			}
			if(fromByte(root.getRightNode(), b, bits)) {
				bits.addFirst(true);
				return true;
			}
		}
		else {
			if(root.getData() == b) {
				return true;
			}
		}
		return false;
	}
}
