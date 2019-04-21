import java.util.ArrayList;

public class WordSearchPuzzleDriver{	

	public static void main(String args[]){
		WordSearchPuzzle test = new WordSearchPuzzle();
		ArrayList<String> example = new ArrayList<String>();
				example.add("Yellow");
				example.add("Red");
				example.add("Blue");
				example.add("Green");

		//Generates a wordsearch puzzle using an arrayList
		test.WordSearchPuzzle(example); //Creates a new instance of WordSearch Puzzle using an ArrayLis
		//Generates a wordsearch puzzle using a file
		test.WordSearchPuzzle("wordFile", 6, 3, 10);
	}
    }