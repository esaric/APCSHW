public class WordGrid{
	private char[][] data;

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
		for (int i = 0; i < rows; i++){
			for (int j = 0; j < rows; j++){
				data[i][j] = '_';
			}
		}
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
     *or there are overlapping letters that do not match, then false is returned.
     */
    public boolean addWord(String word,int row, int col){
		return true;
    }

    //vertical + diagonal should be implemented as well.
}