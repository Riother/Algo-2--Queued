package lab2;

public class FrequencyData implements Comparable<FrequencyData> {

	byte data;
	String name;
	int frequency;
	int height;
	FrequencyData left;
	FrequencyData right;
	
	public FrequencyData(byte data, int frequency, boolean usingNumbers) {
		this.data = data;
		this.frequency = frequency;
		if(usingNumbers)
			name = "" + data;
		else
			name = "" + (char)data;
		left = null;
		right = null;
		height = 0;
	}
	
	public void setName(String child1, String child2) {
		name = child1 + "" + child2;
	}
	
	public String getName() { 
		return name;
	}
	
	public byte getData() {
		return data;
	}
	
	public int getFrequency() {
		return frequency;
	}
	
	public void setData(byte data) {
		this.data = data;
	}
	
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	
	public void print() {
		System.out.println(data + " " + frequency);
	}
	
	public FrequencyData getLeftNode() {
		return left;
	}
	
	public FrequencyData getRightNode() {
		return right;
	}
	
	public void setLeftNode(FrequencyData nextValue) {
		this.left = nextValue;
	}
	
	public void setRightNode(FrequencyData nextValue) {
		this.right = nextValue;
	}
	
	public boolean hasLeftValue() {
		if(left != null)
			return true;
		else
			return false; 
	}
	
	public boolean hasRightValue() {
		if(right != null)
			return true;
		else
			return false; 
	}
	
	public boolean isLeaf() {
		if(hasRightValue() || hasLeftValue())
			return false;
		else
			return true;
	}
	
	public int getHeight() {
		calculateHeight(this);
		return height;
	}
	
	private void calculateHeight(FrequencyData current) {
		if(current.hasLeftValue()) {
			calculateHeight(current.getLeftNode());
			if(current.getLeftNode().getHeight() >= current.height)
				current.height = current.getLeftNode().getHeight() + 1;
		}
		
		if(current.hasRightValue()) {
			calculateHeight(current.getRightNode());
			if(current.getRightNode().getHeight() >= current.height)
				current.height = current.getRightNode().getHeight() + 1;
		}
	}
	
	@Override
	public int compareTo(FrequencyData o) {
		return new Integer(this.frequency).compareTo(o.getFrequency());
	}
}

