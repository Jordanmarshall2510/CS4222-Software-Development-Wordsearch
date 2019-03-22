import java.util.ArrayList;
import java.util.Collections;

public class WordSearchPuzzle {
    private char[][] puzzle ;
    private ArrayList<String> puzzleWords ;
    private String puzzleString;
    
    public WordSearchPuzzle(ArrayList<String> userSpecifiedWords){
        
    }
    public WordSearchPuzzle(String wordFile, int wordCount, int shortest, int longest){
    
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
    public char[][] getPuzzleAsGrid(){
        int puzzleSize = puzzleWords.size();
        String allWords = "";
        for(int i = 0; i < puzzleSize; i++){
            allWords += puzzleWords.get(i);           
        }
        int puzzleLength = (int)(allWords.length()*1.75);
        puzzle = new char[puzzleLength][puzzleLength];
        return puzzle;
    }


    public List<String> getWordSearchList(){

    }

    public String getPuzzleAsString(){
        String str[] = new String[puzzleWords.size()]; 
        for (int j = 0; j < puzzleWords.size(); j++) { 
            str[j] = puzzleWords.get(j); 
        }
        String string = str.deepToString;
        return str; 
    }

    public void showWordSearchPuzzle(boolean hide){

	}
    
    public String getPuzzleAsString(){
        for(int i = 0; i < puzzle.length; i++){
            for(int j = 0; j <= puzzle[0].length; j++){
                if(j == puzzle.length){
                    puzzleString += "\n";
                }else{
                    puzzleString += puzzle[i][j] + " ";
                }
            }
        }
        return puzzleString;
    }
    
    public void showWordSearchPuzzle(boolean hide){
        
    }

    private void generateWordSearchPuzzle(){
        
    }
}