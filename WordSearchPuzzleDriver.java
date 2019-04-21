import java.util.ArrayList;

public class WordSearchPuzzleDriver{	
	public static void main(String args[]){
		WordSearch mainTest = new WordSearch();
		ArrayList<String> example = new ArrayList<String>();
				example.add("Yellow");
				example.add("Red");
				example.add("Blue");
				example.add("Green");

		//Generates a wordsearch puzzle using an arrayList
		WordSearchPuzzle test1 = new WordSearchPuzzle(example);
		//Generates a wordsearch puzzle using a file
		WordSearchPuzzle test2 = new WordSearchPuzzle("wordFile", 6, 3, 10);
	}
}