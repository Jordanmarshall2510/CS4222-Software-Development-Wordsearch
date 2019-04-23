import java.util.ArrayList;

public class WordSearchPuzzleDriver{
    
    public static void main(String[] args){

    //File Testing
        //File wordFile500 with 10 words.
        //Shortest length is 5 and longest length is 5.
        WordSearchPuzzle test1 = new WordSearchPuzzle("wordFile500.txt",10,5,5);
        test1.getWordSearchList() ;
        test1.showWordSearchPuzzle() ;
        System.out.println();

        //File wordFile500 with 7 words.
        //Shortest length is 3 and longest length is 5.
        WordSearchPuzzle test2 = new WordSearchPuzzle("wordFile500.txt",7,3,5);
        test2.getWordSearchList() ;
        test2.showWordSearchPuzzle() ;
        System.out.println();

        //File wordFile500 with 8 words.
        //Shortest length is 4 and longest length is 10.
        WordSearchPuzzle test3 = new WordSearchPuzzle("wordFile500.txt",8,4,10);
        test3.getWordSearchList() ;
        test3.showWordSearchPuzzle() ;
        System.out.println();

    //ArrayList Testing
        //Creation of a sample ArrayList.
        ArrayList<String> example = new ArrayList<String>();
                    example.add("Car");
                    example.add("Helicopter");
                    example.add("Motorbike");
                    example.add("Plane");
                    example.add("Bike");

        //
        WordSearchPuzzle testList = new WordSearchPuzzle(example);
        testList.getWordSearchList() ;
        testList.showWordSearchPuzzle() ;
        System.out.println();

    }
}