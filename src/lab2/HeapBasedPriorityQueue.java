package lab2;

import java.util.ArrayList;

public class HeapBasedPriorityQueue<T extends Comparable<T>> {
	
	ArrayList<T> data;
	int index;
	int size;
	public HeapBasedPriorityQueue() {
		data = new ArrayList<T>();
		index = 0;
		size = 0;
	}
	
	public boolean offer(T value) {
		return offer(index, value);
	}
	
	private boolean offer(int index, T value) {
		boolean successful = false;
		data.add(value);
		this.index++;
		size++;
		successful = heapify();
		return successful;
	}
	
	public T peek() {
		return data.get(0);
	}
	
	public T poll() {
		if(size >= 1) {
			T value = data.get(0);
			data.remove(0);
			size--;
			heapify();
			return value;
		}
		else
			return null;
	}
	
	public int size() {
		return size;
	}
	
	private boolean heapify() {
		int comparisonChild1;
		int comparisonChild2;
		int biggestValueIndex;
//		System.out.println();
		for(int i = 0; i < data.size(); i++) {
//			System.out.print("Current: " + ((FrequencyData) data.get(i)).getName());
			if(i*2+1 < data.size()) {
				comparisonChild1 = data.get(i).compareTo(data.get(i*2+1));
//				System.out.print(" Child 1: " + comparisonChild1 + " " + ((FrequencyData) data.get(i*2+1)).getName());
				if(i*2+2 < data.size())	{
					comparisonChild2 = data.get(i).compareTo(data.get(i*2+2));
//					System.out.print(" Child 2: " + comparisonChild2 + " " + ((FrequencyData) data.get(i*2+2)).getName());
					biggestValueIndex = biggestChild(i*2+1, i*2+2);
					if(comparisonChild1 < 0 || comparisonChild2 < 0) {
						T temp = data.get(i);
						data.set(i, data.get(biggestValueIndex));
						data.set(biggestValueIndex, temp);
//						System.out.println();
						return heapify();
					}
				}
				else {
					biggestValueIndex = i*2+1;
					if(comparisonChild1 < 0) {
						T temp = data.get(i);
						data.set(i, data.get(biggestValueIndex));
						data.set(biggestValueIndex, temp);
//						System.out.println();
						return heapify();
					}
				}
			}
//			System.out.println();
		}
		return true;
	}
	
	private int biggestChild(int child1Index, int child2Index) {
		int comparison = data.get(child1Index).compareTo(data.get(child2Index));
		if(comparison < 0)
			return child2Index;
		else
			return child1Index;
	}
}
