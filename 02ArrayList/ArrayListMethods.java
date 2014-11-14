import java.util.*;

public class ArrayListMethods{

	public static void main(String[]args){
        ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		/*System.out.println(list);
		ArrayListMethods.randomize(list);
		System.out.println(list);
		*/
		list.add(9);
		list.add(9);
		list.add(9);
		ArrayListMethods.collapseDuplicates(list);
		System.out.println(list);
    }
	
	public static void collapseDuplicates(ArrayList<Integer> L){
		ArrayList<Integer> copy = new ArrayList<Integer>(L.size());
		copy.add(L.get(0));
		for (int i = 1; i < L.size(); i++){
			if (L.get(i) != L.get(i-1)) {
				copy.add(L.get(i));
			}
			//System.out.println(copy);
		}
		for (int i = 0; i < copy.size(); i++){
			L.set(i, copy.get(i));
		}
		for (int i = L.size() - copy.size(); i > 0; i--){
			//System.out.println(i);
			L.remove(L.size() - i);
		}
	}
	
	public static void randomize(ArrayList<Integer> L) {
		ArrayList<Integer> copy = new ArrayList<Integer>(L.size());
		Random rand = new Random();
		for (int i = 0; i < L.size(); i++){
			copy.add(rand.nextInt(copy.size() + 1), L.get(i));
			//System.out.println(rand.nextInt(copy.size() + 1));
		}
		//System.out.println(copy);
		// L = copy; // Why won't this work???
		for (int i = 0; i < L.size(); i++){
			L.set(i, copy.get(i));
		}
    }
}