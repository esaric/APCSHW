import java.util.*;

public class WordGrid{
	private char[][] data;
	Random rng = new Random();
	//rng.setSeed(seed);
    /**Initialize the grid to the size specified and fill all of the positions
     *with underScores.
     *@param row is the starting height of the WordGrid
     *@param col is the starting width of the WordGrid
     */
    public WordGrid(int rows,int cols){
		data = new char[rows][cols];
		for (int i = 0; i < rows; i++){
			for (int j = 0; j < rows; j++){
				data[i][j] = '_';
			}
		}
    }

    /**Set all values in the WordGrid to underScores '_'*/
    private void clear(){
		for (int i = 0; i < data.length; i++){
			for (int j = 0; j < data[0].length; j++){
				data[i][j] = '_';
			}
		}
    }

	public void setSeed(long seed){
		rng.setSeed(seed);
	}
	
    /**The proper formatting for a WordGrid is created in the toString.
     *@return a String with each character separated by spaces, and each row
     *separated by newlines.
     */
    public String toString(){
		String output = "";
		for (int i = 0; i < data.length; i++){
			for (int j = 0; j < data[0].length; j++){
				output += data[i][j] + " ";
			}
			output += "\n";
		}
		return output;
    }
	
	/**Verifies whether a given word fits to the specified position of the WordGrid.*/
	public boolean isLegalPosition(String word, int row, int col, int dx, int dy){
		if (dx == 0 && dy == 0 ||
			dx < -1 || dx > 1 ||
			dy < -1 || dy > 1 ||
			row < 0 || row > data.length || 
			col < 0 || col > data[0].length){
			return false;
		}
		int[] wordRange = new int[word.length()];
		for (int x = 0; x < word.length(); x++){
			wordRange[x] = x;
		}
		for ( int i : wordRange ){
			try{
				if ((char)data[row + i*dy][col + i*dx] != '_' && (char)data[row + i*dy][col + i*dx] != word.charAt(i)){
					return false;
				}
			}catch (ArrayIndexOutOfBoundsException e){
				return false;
			}
			//System.out.println((char)data[row + i*dy][col + i*dx]);
		}
		return true;
	}
    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added in a direction corresponding with dx and dy, must 
	 *fit on the WordGrid, and must have a corresponding letter to match 
	 *any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
	 *@param dx is the horizontal increment (-1, 0, 1).
	 *@param dy is the vertical increment (-1, 0 , 1).
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, false is returned.
     */
    public boolean addWord(String word, int row, int col, int dx, int dy){
		int[] wordRange = new int[word.length()];
		for (int x = 0; x < word.length(); x++){
			wordRange[x] = x;
		}
		if (isLegalPosition(word, row, col, dx, dy)) {
			for ( int i : wordRange ) {
				data[row + i*dy][col + i*dx] = word.charAt(i);
			}
			return true;
		}else{
			return false;
		}
    }
	/**Attempts to add a given word to a random position of the WordGrid.
     *The word is added in a direction corresponding with dx and dy, must 
	 *fit on the WordGrid, and must have a corresponding letter to match 
	 *any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
	 *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, false is returned.
     */
	public boolean addWordRandomly(String word){
		for (int tries = 100; tries > 0; tries--){
			if (addWord(word, rng.nextInt(data.length), 
							  rng.nextInt(data[0].length), 
							  rng.nextInt(2) - 1, 
							  rng.nextInt(2) - 1)){
				return true;
			}
		}
		return false;
	}
	
	public void addWordList(ArrayList<String> wordList){
		for (int tries = wordList.size(); tries > 0; tries --){
			addWordRandomly(wordList.get(rng.nextInt(wordList.size())));
		}
	}
}