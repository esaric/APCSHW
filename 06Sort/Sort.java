public class Sort{
	public static void main(String[] args){
		int[] a = {99, 4, 12, 25, -5, 0};
		bubble(a);
		
		String s = "[ ";
		for ( int x : a ){
			s += x + " ";
		}
		s += "]";
		
		System.out.println(s);
	}
	
	public static void bubble(int[] list){
		int temp;
		int swaps = 0;
		
		for (int j = 0; j < list.length; j++){
			for (int i = 0; i < list.length - 1; i++){
				if (list[i] > list[i+1]){
					temp = list[i];
					list[i] = list[i+1];
					list[i+1] = temp;
					swaps++;
				}
				if (swaps == 0)
					break;
			}
		}
	}
}
