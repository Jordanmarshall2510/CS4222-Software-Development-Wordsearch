import java.util.ArrayList;
import java.util.Collections;

public class WordSearchPuzzle {
    private char[][] puzzle ;
    private ArrayList<String> puzzleWords ;

    public WordSearchPuzzle(ArrayList<String> userSpecifiedWords){
	userSpecifiedWords = puzzleWords;
        // puzzle generation using user specified words
        // The user passes in a list of words to be used
        // for generating the word search grid.
    }
    public WordSearchPuzzle(String wordFile, int wordCount, int shortest, int longest){
	// puzzle generation using words from a file
        // The user supplies the filename. In the file 
        // the words should appear one per line.
        // The wordCount specifies the number of words
        // to (randomly) select from the file for use in
        // the puzzle.
        // shortest and longest specify the shortest
        // word length to be used and longest specifies
        // the longest word length to be used.
        // SO, using the words in the file randomly select
        // wordCount words with lengths between shortest
        // and longest.
    }

    // The dimensions of the puzzle grid should be set
    // by summing the lengths of the words being used in the
    // puzzle and multiplying the sum by 1.5 or 1.75
    // or some other (appropriate) scaling factor to
    // ensure that the grid will have enough additional
    // characters to obscure the puzzle words. Once
    // you have calculated how many characters you are
    // going to have in the grid you can calculate the
    // grid dimensions by getting the square root (rounded up)
    // of the character total.
    //
    // You will also need to add the methods specified below
    public ArrayList<String> getWordSearchList(){
        return puzzleWords;
    }
    /*public char[][] getPuzzleAsGrid(){
        
    }
    public String getPuzzleAsString(){
        
    }
    public void showWordSearchPuzzle(boolean hide){
        
    }
    private void generateWordSearchPuzzle(){
        
    }*/
}
