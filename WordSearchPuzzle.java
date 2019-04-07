import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.io.FileReader; 
import java.io.BufferedReader;
import java.io.IOException; 

public class WordSearchPuzzle {
    private char[][] puzzle ;
    private ArrayList<String> puzzleWords;    
    private ArrayList<String> list;
    private String puzzleString;
    private ArrayList<String> wordsPosition;
    private ArrayList<String> justWords;
    private ArrayList<String> wordsInOrder;		//
    
    public WordSearchPuzzle(ArrayList<String> userSpecifiedWords){
        
    }   
    public WordSearchPuzzle(String wordFile, int wordCount, int shortest, int longest){
       largest = 0;
       int position = 0;
        for(int i = 0; i <= wordCount;i++){
            int ran = (int) (Math.random()*puzzleWords);
            String wordUse = puzzleWords.get(ran);
            int wordSize = worduse.length();
            for(int r = 0;r <= ){
                if (wordSize >= largest) {
                    wordsInOrder.add(position,wordUse);
                }
                else{
                    position++;
                }
            }


       for(int i = 0; i <= wordCount;i++){
        int ran = (int) (Math.random()*puzzleWords.size);
        String wordUse = puzzleWords.get(ran);
        int varNum = wordUse.length();
        if(varNum>= shortest && varNum >= longest){
            wordsInOrder.add(wordUse);
        }
        else
            i--;
       }
    }


    public List<String> getWordSearchList(){
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
            int irow; int icol;
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
            String Srotation;
            String Sdirection;
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
            wordsPosition.add("Word "+S+" is "+Srotation+" and "+Sdirection+" at position x="+irow+" y="+icol+" to x="+rows+" y="+cols);
            justWords.add(S);
            i++;
        }
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for(int row = 0; row <= puzzle.length;row++){
            for(int col = 0;col <= puzzle.length;col++){
                int ran = (int) (Math.random()*alphabet.length());
                char chran = alphabet.charAt(ran);
                if (puzzle[row][col] == ' '){
                    puzzle[row][col] = chran;
                }
            }
        }
        //Still need to make a thing that checks if user supplied words or not
    }
}