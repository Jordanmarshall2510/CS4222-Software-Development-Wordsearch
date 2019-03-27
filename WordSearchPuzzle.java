//All the methods are in order here from the specification sheet

import java.util.ArrayList;
import java.util.Collections;

public class WordSearchPuzzle {
    private char[][] puzzle ;
    private ArrayList<String> puzzleWords;    
    private List<String> list;
    private String puzzleString;
    
    public WordSearchPuzzle(ArrayList<String> userSpecifiedWords){
        
    }
    
    public WordSearchPuzzle(String wordFile, int wordCount, int shortest, int longest){
        // BasicEnglish.txt - the 850 words of Basic English
        // BNCwords.txt - 5456 words
        try {
            FileReader aFileReader = new FileReader(wordFile);
            BufferedReader aBufferReader = new BufferedReader(aFileReader);
            String lineFromFile;
            lineFromFile = aBufferReader.readLine() ;
            while (lineFromFile != null) {  
                puzzleWords.add(lineFromFile.toUpperCase());
                lineFromFile = aBufferReader.readLine() ;
            }
            aBufferReader.close();
            aFileReader.close();
            return puzzleWords ;
        }
        catch(IOException x) {
            return null ;
        }

        int characterTotal;
        for(int i = 0; i <= puzzleWords.size(); i++){
        	characterTotal = puzzleWords.get(i);
        }
        int gridDim = Math.sqrt(characterTotal);
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

	public List<String> getWordSearchList(){
        list = new ArrayList<String>(Arrays.asList(puzzleWords));
        return list
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

    

    public String getPuzzleAsString(){
        String str[] = new String[puzzleWords.size()]; 
        for (int j = 0; j < puzzleWords.size(); j++) { 
            str[j] = puzzleWords.get(j); 
        }
        String string = str.deepToString;
        return str; 
    }

    public void showWordSearchPuzzle(boolean hide){
        if(hide == true){
            //hides all random characters revealing the answers
        }else{
            //displays all characters including answers
        }
	}
    
    /*public String getPuzzleAsString(){
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
    }*/
    
    private void generateWordSearchPuzzle(){
        
    }
}