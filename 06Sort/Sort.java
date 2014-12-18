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
				if (swaps == 0){
					break;
				}
			}
		}
	}
	
	public static void selection(int[] list){
		int temp;
		int min;
		
		for (int j = 0; j < list.length - 1; j++){
			min = j;
			for (int i = j+1; i < list.length; i++){
				//System.out.println(list[min]);
				if (list[i] < list[min]){
					min = i;
				}
			}
			
			if (min != j){
				temp = list[j];
				list[j] = list[min];
				list[min] = temp;
			}
			//System.out.println("---------------------");
		}
	}
	
	public static void insertion(int[] list){
		int partition; 
		int i;
		
		for (int j = 1; j < list.length; j++){
			partition = list[j];
			for(i = j-1; (i >= 0) && (list[i] > partition); i--){
				list[i+1] = list[i];
			}
			list[i+1] = partition;
		}
	}
}
