public class SuperArray{
    private Object[] data;
    private int storedElements;

	public static void main(String[]args){
		SuperArray L = new SuperArray();
		System.out.println(L);
		for (int i = 0; i < 10; i++) {
			L.add(new Integer(i));
		}
		System.out.println(L);
		L.add(11);
		System.out.println(L);
		System.out.println(L.remove(1));
		System.out.println(L);
		System.out.println(L.get(5));
	}
	
    public SuperArray(){
		this(10);
    }

    public SuperArray(int capacity){
		data = new Object[capacity];
		storedElements = 0;
    }

    public String toString(){
		String outString = "[ ";
		for (int i = 0; i < data.length; i++){
			outString += data[i] + " ";
		}
		return outString + "]";
    }

    public void add(Object e){
		add(storedElements, e);
    }
	
	public void add(int index, Object o){
		if (storedElements == data.length){
			resize(data.length * 2);
		}
		for (int i = storedElements; i > index; i--) {
			data[i] = data[i-1];
		}
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}else{
			data[index] = o;
			storedElements++;
		}
    }
	
    public int size(){
		return storedElements;
    }

    public void resize(int newCapacity){
		Object[] newData = new Object[newCapacity];
		for (int i = 0; i < newCapacity; i++){
			if (i >= data.length){
				newData[i] = null;
			}else{
				newData[i] = data[i];
			}
		}
		data = newData;
    }

    public void clear(){
		for (int i = 0; i < storedElements; i++){
			data[i] = null;
		}
    }
	
	public Object get(int index){
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		return data[index];
    }

    public Object set(int index, Object o){
		Object replaced = data[index];
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		data[index] = o;
		return replaced;
	}
	
	public Object remove(int index){
		if (storedElements < data.length / 4) {
			resize(data.length / 2);
		}
		Object replaced = data[index];
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		for (int i = index; i < storedElements - 1; i++) {
			data[i] = data[i+1];
		}
		data[storedElements-1] = null;
		return replaced;
	}
}
