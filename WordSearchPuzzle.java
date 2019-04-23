import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.io.FileReader; 
import java.io.BufferedReader;
import java.io.IOException; 
import java.io.FileNotFoundException;

public class WordSearchPuzzle{
	private char[][] puzzle ;
	private ArrayList<String> puzzleWords ;

	public WordSearchPuzzle(ArrayList<String> userSpecifiedWords){
		int i;
		int longest = 0;
		userSpecifiedWords.replaceAll(String::toUpperCase);
		for(i=0; i<userSpecifiedWords.size(); i++){
			if(userSpecifiedWords.get(i).length() > longest){
				longest = userSpecifiedWords.get(i).length();
			}
		}
		for(i = 0 ; i < userSpecifiedWords.size(); i++){
			if( userSpecifiedWords.get(i).length() > longest){
			longest = userSpecifiedWords.get(i).length() ;
			}
		}
		this.puzzle = new char[longest+2][longest+2];
		puzzleWords = userSpecifiedWords ;
	}

	public WordSearchPuzzle(String wordFile, int wordCount,int shortest, int longest){
		int temp ;
		if(shortest > longest){
			temp = longest ;
			longest = shortest ;
			shortest = temp ;
		}
		puzzleWords = loadWordsFromFile(wordFile, shortest, longest);
		ArrayList<String> chosen = new ArrayList<String>();
		int i,j,large=0,sum = 0;
		for(i=0; i<wordCount; i++){
			int pos = (int)((Math.random()* puzzleWords.size()));
			chosen.add(puzzleWords.get(pos));
		}
		for(i = 0 ; i < chosen.size(); i++){
			if( chosen.get(i).length() > large){
			large = chosen.get(i).length() ;
			}
		}
		int count = 0 ;
		for(int x = 0 ; x < chosen.size();x++){
			count = count + chosen.get(x).length() ;
		}
		count = (int)((Math.sqrt(count))*1.75) ;
		this.puzzle = new char[count][count];
		puzzleWords = chosen;
	}

	private ArrayList<String> loadWordsFromFile(String filename,int shortest, int longest){
		try {
			FileReader aFileReader = new FileReader(filename);
			BufferedReader aBufferReader = new BufferedReader(aFileReader);
			String lineFile;
			int stringLength ;
			ArrayList<String> words = new ArrayList<String>();
			lineFile = aBufferReader.readLine() ;
			while (lineFile != null) {
				stringLength = lineFile.length() ;
				if(stringLength >= shortest && stringLength <= longest) {
					words.add(lineFile.toUpperCase());
				}
				lineFile = aBufferReader.readLine() ;
			}
			aBufferReader.close();
			aFileReader.close();
			return words ;
		}
		catch(IOException x){
			return null;
		}
	}

	public void showWordSearchPuzzle(boolean hide){
		if(hide == false)
        generateWordsearchpuzzle() ;
		int i,j;
		for(i=0; i<puzzleWords.size(); i++){
			System.out.println(puzzleWords.get(i));
		}
		System.out.println(getPuzzleAsString());
	}

	public ArrayList<String> getWordSearchList(){
		return this.puzzleWords;
	}

	public char[][] getpuzzle(){
			return this.puzzle ;
		}

	public String getPuzzleAsString(){
		String a = " ";
		int c,r = 0 ;
		for( c = 0; c < puzzle[0].length; c++){
			for( r = 0; r < puzzle.length; r++){
				a = a + (puzzle[r][c])+ " ";
			}
		if( r == puzzle.length){
			a = a + " \n " ;
			r = 0 ;
		}}
		return a ;
	}

	public char[][] getPuzzleAsGrid(){
			int i,j;
			char[] hide = {('A'),('B'),('C'),('D'),('E'),('F'),('G'),('H'),('I'),('J'),('K'),('L'),('M'),('N'),('O'),('P'),('Q'),('R'),('S'),('T'),('U'),('V'),('W'),('X'),('Y'),('Z')} ;
			for(i=0; i<puzzle.length; i++){
				for(j=0; j<puzzle[0].length; j++){
					int z = (int)((Math.random()* hide.length));
					puzzle[i][j] = hide[z] ;
					System.out.print(puzzle[i][j] + " ");
				}
				System.out.println();
			}
			return puzzle;
		}

	private void generateWordsearchpuzzle(){
		int i = 0, rand, wordUsed = 0, row=0, col=0, k, empty = 0;
		puzzle = this.puzzle ;
		while(i < puzzleWords.size()){
		rand = (int)(Math.random()*4) ;
		row = (int)(Math.random()*(puzzle[0].length)) ;
		col = (int)(Math.random()*(puzzle.length)) ;
		int coltemp = col ;
		int rowtemp = row ;
		if(rand == 0){
			if(puzzle[0].length - (col+1) >=puzzleWords.get(i).length()){
				for(empty = 0 ; empty <puzzleWords.get(i).length(); empty++){
					if((Character.isLetter(puzzle[row][coltemp]))==false){
						coltemp++ ;
					}else{
					empty = puzzleWords.get(i).length()+1 ;
					}
				}
			if(empty == puzzleWords.get(i).length()){
				k = 0 ;
				while( k < puzzleWords.get(i).length() ){
					puzzle[row][col] = puzzleWords.get(i).charAt(k) ;
					col++ ;
					k++ ;
				}
				i++;
				}
			}
		else if(rand == 1){
		if(puzzle.length - (col+1)>=puzzleWords.get(i).length() ){
			for(empty = 0 ; empty <puzzleWords.get(i).length(); empty++){
				if((Character.isLetter(puzzle[row][coltemp]))==false){
					coltemp++ ;
				}else{
				empty = puzzleWords.get(i).length()+1 ;
			}
		}
		if(empty == puzzleWords.get(i).length()){
			k = puzzleWords.get(i).length()-1 ;
			while( k >= 0 ){
				puzzle[row][col] = puzzleWords.get(i).charAt(k) ;
				col++;
				k--;
			}
			i++ ;
			}
		}
		}else if(rand == 2){
			if(puzzle[0].length - (row+1) >=puzzleWords.get(i).length() && (Character.isLetter(puzzle[row][col])==false)){
				for(empty = 0 ; empty <puzzleWords.get(i).length(); empty++){
					if((Character.isLetter(puzzle[rowtemp][col]))==false){
						rowtemp++ ;
					}else{
						empty = puzzleWords.get(i).length()+1 ;
					}
		}
		if(empty == puzzleWords.get(i).length()){
			k = puzzleWords.get(i).length()-1 ;
			while( k >= 0 ){
				puzzle[row][col] = puzzleWords.get(i).charAt(k) ;
				row++;
				k-- ;
			}
			i++ ;
			}

		}
		}
		else if(rand == 3){
			if(puzzle[0].length - (row+1) >=puzzleWords.get(i).length() ){
				for(empty = 0 ; empty <puzzleWords.get(i).length(); empty++){
					if((Character.isLetter(puzzle[rowtemp][col]))==false){
						rowtemp++ ;
					}else{
					empty = puzzleWords.get(i).length()+1 ;
					}
					}
				if(empty == puzzleWords.get(i).length()){
				k = 0 ;
				while(k < puzzleWords.get(i).length() ){
					puzzle[row][col] = puzzleWords.get(i).charAt(k) ;
					row++;
					k++;
				}
				i++ ;
			}
			}
			}
		}
		int a,j;
		char[] fill = {('A'),('B'),('C'),('D'),('E'),('F'),('G'),('H'),('I'),('J'),('K'),('L'),('M'),('N'),('O'),('P'),('Q'),('R'),('S'),('T'),('U'),('V'),('W'),('X'),('Y'),('Z')} ;
		for(i=0;i < puzzleWords.size(); i++){
			for(a=0; a<puzzle.length; a++){
				for(j=0; j<puzzle[0].length; j++){
					if(Character.isLetter(puzzle[a][j])==false){
						int z = (int)((Math.random()* fill.length));
						puzzle[a][j] = fill[z] ;
					}
					}
				}
			}
		}
	}
}