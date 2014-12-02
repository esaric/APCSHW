public class Driver{
	public static void main(String[]args){
		WordGrid a = new WordGrid(10, 10);
		System.out.println(a);
		System.out.println(a.addWord("dog", 9, 5, 0, -1));
		System.out.println(a);
	}
}