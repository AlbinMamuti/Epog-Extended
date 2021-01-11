public class LinkedRingBuffer {

	Node first;
	Node last;

	public LinkedRingBuffer(int size) {
		if (size < 1) {
			throw new IllegalArgumentException();
		} else if (size == 1) {
			Node current = new Node();
			current.value = Integer.MIN_VALUE;
			first = last = current;
			first.next = first;
		} else {

			Node current = new Node();
			current.value = Integer.MIN_VALUE;
			first = current;
			for (int i = 0; i < size - 1; i++) {

				Node temp = new Node();
				current.next = temp;
				current = temp;
				current.value = Integer.MIN_VALUE;
			}

			current.next = first;
			last = first;
		}
	}

	public int capacity() {
		int counter = 1;
		Node current = first;
		current = current.next;
		Node current2 = first;
		if(current == current2) {
			return 1;
		}
		counter ++;
		
		while (current.next != current2) {
			counter++;
			current = current.next;
		}
		return counter;
	}

	public int length() {
		
		Node current = first;
		
		int counterFree = 0;
		
		int capac = this.capacity();
		
		for(int i = 0; i < capac; i++) {
			if(current.value != Integer.MIN_VALUE) {
				counterFree++;
				current = current.next;
			} else {
				current = current.next;
			}
		}
		
		return counterFree;
	}

	public void enqueue(int value) {
		int l = this.length();
		int c = this.capacity();
		
		if(l == c) {
			throw new IllegalStateException();
		}
		
		if(l == 0) {
			first.value = value;
			last = first;
		} else {
			if(l < c) {
				
				last = last.next;
				last.value = value;
				
				
			}
		}
		
		

	}

	public int dequeue() {
		int l = this.length();
		int c = this.capacity();
		int val = first.value;
		if(l == 0) {
			throw new IllegalStateException();
		} else {
			
			first.value = Integer.MIN_VALUE;
			first = first.next;
		}
		
		
		
		return val;
	}
}

class Node {
	Node next;
	int value;
}
