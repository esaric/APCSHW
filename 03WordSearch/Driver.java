import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Driver{
	public static void main(String[] args) throws FileNotFoundException{
	
		int randomSeed;
		boolean isNotCheater = true;
	
		WordGrid a = new WordGrid(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
		if (args.length == 3){
			randomSeed = Integer.parseInt(args[2]);
			a.setSeed(randomSeed);
		}
		if (args.length == 4){
			if (Integer.parseInt(args[3]) == 1){
				isNotCheater = false;
			}
		}
		//WordGrid a = new WordGrid(firstArg, secondArg);
		
		//System.out.println(wordList);
		a.loadWordsFromFile("words.txt", isNotCheater);
		System.out.println(a.wordsInPuzzle());
		System.out.println(a);
	}
}