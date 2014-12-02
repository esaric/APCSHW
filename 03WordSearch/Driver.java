import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Driver{
	public static void main(String[]args) throws FileNotFoundException {
		WordGrid a = new WordGrid(12, 12);
		
		/**
		Code credit to: http://java67.blogspot.com/2012/11/how-to-read-file-in-java-using-scanner-example.html
		**/
		
		//Creating File instance to reference text file in Java
        File text = new File("words.txt");
      
        //Creating Scanner instance to read File in Java
        Scanner scnr = new Scanner(text);
		
		ArrayList<String> wordList = new ArrayList<String>();
        //Reading each line of file using Scanner class
        while(scnr.hasNextLine()){
            String word = scnr.nextLine();
            wordList.add(word);
        }
		//System.out.println(wordList);
		a.addWordList(wordList);
		System.out.println(a);
	}
}