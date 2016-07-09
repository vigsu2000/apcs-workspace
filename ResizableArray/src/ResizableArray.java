import java.util.Arrays;

public class ResizableArray<E> {
	
	private static final int INITIAL_ARRAY_LENGTH = 100;
	private Object[] data;
	private int size;
	
	public ResizableArray() {
		data = (E[])new Object[INITIAL_ARRAY_LENGTH];
		size = 0;
	}
	
	private void resize() {
		Object[] largerArray = (E[])new Object[data.length*2];
		for(int i = 0; i < size; i++) {
			largerArray[i] = data[i];
		}
		data = largerArray;
	}
	
	public void add(E x) {
		if(size >= data.length-1) {
			resize();
		}
		data[size] = x;
		size++;
	}
	
	public void sort() {
        Arrays.sort(data, 0, size);
	}
	
	public boolean equals(ResizableArray other) {
		if(size != other.size) {
			return false;
		}
		for(int i = 0; i < size; i++) {
			if(data[i] != other.get(i)) {
				return false;
			}
		}
		return true;
	}
	
	public int size() {
		return size;
	}
	
	public void remove(int i) {
		if(i > size) {
			throw new IllegalArgumentException("Bad Index: " + i);
		}
		for(int j = i; j < size - 1; j++) {
			data[j] = data[j+1];
		}
		size--;
	}
	
	public void insert(int i, E x) {
		if(i > size) {
			throw new IllegalArgumentException("Bad Index: " + i);
		}
		if(size >= data.length-1) {
			resize();
		}
		for(int j = size; j > i; j--) {
			data[j] = data[j-1];
		}
		data[i] = x;
		size = size + 1;
	}
	
	public void removeAll(E x) {
		int t1 = 0;
		int t2 = 0;
		while (t1 <= size - 1) { 
			if (data[t1] != x) { 
				data[t2++] = data[t1]; 
			}
			t1++;
		}
		while (t2 <= size - 1) {
			data[t2++] = x;
		}
		int a = 0;
		while(data[a] != x) {
			a++;
		}
		size = size - (size - a);
		System.out.println();		
	}
	
	public void clear() {
		for(int i = 0; i < size; i++) {
			remove(i);
		}
	}
	
	public void addAll(E[] x) {
		for(int i = 0; i < x.length; i++) {
			add(x[i]);
		}
	}
	
	public E get(int i) {
		if(i > size) {
			throw new IllegalArgumentException("Bad Index: " + i);
		}
		return (E)data[i];
	}
	
	public int firstIndexOf(E x) {
		for(int i = 0; i < size; i++) {
			if(data[i] == x) {
				return i;
			}
		}
		return -1;
	}
	
	public void set(int i, E x) {
		if(i > size) {
			throw new IllegalArgumentException("Bad Index: " + i);
		}
		data[i] = x;
	}
	
	public void replaceAll(E oldVal, E newVal) {
		for(int i = 0; i < size; i++) {
			if(data[i] == oldVal) {
				data[i] = newVal;
			}
		}
	}
	
	public int lastIndexOf(E x) {
		for(int i = size-1; i > 0; i++) {
			if(data[i] == x) {
				return i;
			}
		}
		return -1;
	}
	
	public E[] toArray() {
		Object[] newData = (E[])new Object[size];
		for(int i = 0; i < size; i++) {
			newData[i] = data[i];
		}
		return (E[])newData;
	}
	
	public String toString() {
		String x = "{";
		for(int i = 0; i < size; i++) {
			x += data[i] + ", ";
		}
		return x + "}";
	}
	
	/*public ResizableArray subArray(int start, int end) {
		int i = start;
		ResizableArray r = new ResizableArray();
		while(i < end) {
			r.add(data[i]);
			i++;
		}
		return r;
	}*/
	
	/*public static void main(String[] args) {
		ResizableArray<Integer> r = new ResizableArray<Integer>();
		r.add(1);
		r.add(2);
		r.add(3);
		System.out.println(r.get(1));
	}*/

}
