import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class spellCheckTest {
	
	public static void main(String[] args) throws FileNotFoundException{
		//Prompt user and take in dictionary file name and text file name
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter Dictionary file name (words.txt): ");
	    String dictionary = s.next();
	    System.out.println("Enter the name of the file you wish to spell check (filetospellcheck.txt): ");
	    String file = s.next();
		
	    //Parse first file into linked list
	    LinkedList<String>dictionaryll = new LinkedList<>();  
	    Scanner s1 = new Scanner(new FileInputStream(dictionary));
        while (s1.hasNextLine()){
              String line = s1.nextLine();
              dictionaryll.add(line);
        }
        s1.close();
        //Parse second file into ll
	    LinkedList<String>textll = new LinkedList<>(); 
	    Scanner s2 = new Scanner(new FileInputStream(file));
        while (s2.hasNextLine()) {
              String line2 = s2.nextLine();
              textll.add(line2);
        }
        s2.close();
	    
        //Call spellchecker on both linked lists
		spellChecker checker = new spellChecker();
		checker.scanDictionary(dictionaryll);
		LinkedList<String> checkedll = checker.checkFile(textll);
		
		//output checked list
		for (int i=0; i<checkedll.size(); i++){
			System.out.println(checkedll.get(i));
		}	
	}
}