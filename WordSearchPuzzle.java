import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.io.FileReader; 
import java.io.BufferedReader;
import java.io.IOException; 
import java.util.Scanner;
import java.io.FileNotFoundException;

public class WordSearch {
    private char[][] puzzle;
    private ArrayList<String> puzzleWords = new ArrayList<String>();    
    private ArrayList<String> list = new ArrayList<String>();;
    private String puzzleString;
    private ArrayList<String> wordsPosition = new ArrayList<String>();;
    private ArrayList<String> justWords = new ArrayList<String>();;
    private ArrayList<String> wordsInOrder = new ArrayList<String>();;

    public void WordSearchPuzzle(ArrayList<String> userSpecifiedWords){
        puzzleWords = userSpecifiedWords;
        getPuzzleAsGridNoReturn();
        generateWordSearchPuzzle();
    }  

    public void WordSearchPuzzle(String wordFile, int wordCount, int shortest, int longest){
    BufferedReader in = null;
        try {
            FileReader aFileReader = new FileReader("wordFile");
            BufferedReader aBufferReader = new BufferedReader(aFileReader);
            String lineFromFile;
            lineFromFile = aBufferReader.readLine() ;
            while (lineFromFile != null) {  
                puzzleWords.add(lineFromFile.toUpperCase());
                lineFromFile = aBufferReader.readLine() ;
            }
            aBufferReader.close();
            aFileReader.close();
        }
        catch(IOException x) {
            throw null;
        } 
        getPuzzleAsGridNoReturn();
        fileSort(wordCount, shortest, longest);
        generateWordSearchPuzzle();
    }


    public List<String> getWordSearchList(){
        return puzzleWords;
    }

    public char[][] getPuzzleAsGrid(){
        return puzzle;
    }

    private void getPuzzleAsGridNoReturn(){
        int puzzleSize = puzzleWords.size();
        String allWords = "";
        for(int i = 0; i < puzzleSize; i++){
            allWords += puzzleWords.get(i);           
        }
        int puzzleLength = (int)(allWords.length()*1.75);
        puzzle = new char[puzzleLength][puzzleLength];
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
        if(hide == true){
            System.out.println(justWords);
        }else{
            System.out.println(wordsPosition);
        }
    }
    
    private void generateWordSearchPuzzle(){       
        for(int i = 0; i < puzzleWords.size(); i++){
            int rows = (int) (Math.random()*puzzle.length); 
            int cols = (int) (Math.random()*puzzle.length);
            String S = puzzleWords.get(i);
            int k = 0;
            int rotation = 0;
            int direction = 0;
            int irow = 0;
            int icol = 0;
            irow = rows; icol = cols;
            for(int j = 0; j < S.length(); j++){                       
                rotation = (int) (Math.random() *2);
                direction = (int) (Math.random() *2);                
                if (rotation == 0){
                    if (direction == 0 || S.length() <= (puzzle.length - cols)){
                        puzzle[rows][cols] = S.charAt(k);
                        k++;
                        cols++;                    
                    }else if (direction == 1 || S.length() <= ( cols-1 )){
                        puzzle[rows][cols] = S.charAt(k);
                        k++;                        
                        cols--;
                    }
                }else if(rotation == 1){
                    if (direction == 0 || S.length() <= (puzzle.length - rows)){
                        puzzle[rows][cols] = S.charAt(k);
                        k++;
                        rows++;
                    }else if (direction == 1 || S.length() <= (rows - 1)){
                        puzzle[rows][cols] = S.charAt(k);
                        k++;
                        rows--;
                    }
                }
            }
            String Srotation = "";
            String Sdirection = "";
            if (rotation == 0 && direction == 0 ){
                Srotation = "horizontal";
                Sdirection = "right to left";
            }else if (rotation == 0 && direction == 1 ){
                Srotation = "horizontal";
                Sdirection = "left to right";
            }else if (rotation == 1 && direction == 0 ){
                Srotation = "vertical";
                Sdirection = "upwards";
            }else if (rotation == 1 && direction == 1 ){
                Srotation = "vertical";
                Sdirection = "downwards";
            }
            String sentance = "Word "+S+" is "+Srotation+" and "+Sdirection+" at position x="+irow+" y="+icol+" to x="+rows+" y="+cols;
            wordsPosition.add(sentance);
            justWords.add(S);
            i++;
        }
        
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for(int row = 0; row <= puzzle.length;row++){
            for(int col = 0;col <= puzzle[0].length;col++){
                int ran = (int) (Math.random()*alphabet.length());
                char chran = alphabet.charAt(ran);
                if (puzzle[row][col] == ' '){
                    puzzle[row][col] = chran;
                }
            }
        }
    }
    
    private void fileSort(int wordCount, int shortest, int longest){
        longest = 0;
        int position = 0;
        for(int i = 0; i <= wordCount;i++){
        int ran = (int) (Math.random()*puzzleWords.size());
        String wordUse = puzzleWords.get(ran);
        int varNum = wordUse.length();
        if(varNum>= shortest && varNum >= longest){
            wordsInOrder.add(wordUse);
        }
        else
            i--;
       }
       int shortPos = 0;
       int longPos = 0;
       for(int j = 1; j < puzzleWords.size(); j++){
            if ((puzzleWords.get(j)).length() == shortest){
                shortPos=j;
                j=puzzleWords.size();
            }
       }
       for(int k=0; k<puzzleWords.size(); k++){
            if ((puzzleWords.get(k)).length() == longest){
                longPos = k;
       }
        ArrayList<String> tempStor = new ArrayList<String>(); 
       for (int i = 0;i < wordCount; i++){
        int rand = (int)(((Math.random() * (longPos-shortPos)) + shortPos));
        String randomWord = puzzleWords.get(rand);
        tempStor.add(randomWord);
       }

       puzzleWords = tempStor;
    }
}
}