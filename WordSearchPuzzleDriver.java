import java.util.ArrayList;

public class WordSearchPuzzleDriver{
	
	public static void main(String args[]){
		ArrayList<String> example = new ArrayList<String>();
				example.add("Yellow");
				example.add("Red");
				example.add("Blue");
				example.add("Green");

		//Generates a wordsearch puzzle using an arrayList
		WordSearchPuzzle puzzleArrayList = new WordSearchPuzzle(example); //Creates a new instance of WordSearch Puzzle using an ArrayList
		generateWordSearchPuzzle();

		//Generates a wordsearch puzzle using a file
		WordSearchPuzzle puzzleFile = new WordSearchPuzzle("wordFile", 6, 3, 10);
		generateWordSearchPuzzle();
	}
}