public class OrderedSuperArray extends SuperArray{

	public void add(int index, String o){
        add(o);
    }
	
	public void add(String o){
		for (int i = size(); i > 0 && get(i - 1).compareTo(o) > 0; i--);
		super.add(i, o);
	}
	
	/*public void add(String o){
        int index = size();
        while( index >0 && get(index-1).compareTo(o) > 0 ){
            index--;
        }
        super.add(index, o);
    }*/
	
	public String set(int index, String o){
        String removed = remove(index);
        add(o);
        return removed;
}
