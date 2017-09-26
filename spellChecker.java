import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class spellChecker {

	hashTable hashBrown = new hashTable();
	public spellChecker(){}

	//go through dictionary, insert each word into the hash table.
	public void scanDictionary(LinkedList<String> dict){
		for (int i=0; i<dict.size(); i++){
			String singleWord = dict.get(i).replaceFirst("^[^a-zA-Z']+", "").replaceAll("[^a-zA-Z']+$", "").toLowerCase();
		    hashBrown.insert(singleWord);
		}
	}

    public String runChecks(String w){
    	//Use TreeSet because Set does not work with string
    	TreeSet<String> afterCheck = new TreeSet<>();
    	
    	//If word has an extra character
    	for (int i = 0; i< w.length(); i++){
    		//Use StringBuilder to delete a character at location i
	        StringBuilder str = new StringBuilder(w);
	        str.deleteCharAt(i);
	        String changedWord = str.toString();
	        //If corrected word is in the dictionary, save it to afterCheck
	        if (hashBrown.contains(changedWord)){
	        	afterCheck.add(changedWord);
	        }
    	}   
    	//If word is missing a character
    	for (int i = 0; i< w.length() + 1; i++){
	        for (char ch ='a'; ch<= 'z'; ch++){
	        	StringBuilder str = new StringBuilder(w);
	        	//add character ch at position i
	        	str.insert(i, ch);
	        	String changedWord = str.toString();
	        	//If corrected word is in the dictionary, save it
	        	if (hashBrown.contains(changedWord)){	        		
	        		afterCheck.add(changedWord);
	        	}
	        }
    	}	
    	//Swap 2 characters
    	//Iterate only to length -1 so we don't swap with null
    	for (int i=0; i<w.length()-1; i++ ){
    		StringBuilder str = new StringBuilder(w);
    		//Swap characters at position i and i+1
    		char ch = str.charAt(i);
    		str.setCharAt(i, str.charAt(i+1));
    		str.setCharAt(i+1,ch);
    		String changedWord = str.toString();
    		//If corrected word is in dictionary, save it
    		if (hashBrown.contains(changedWord)){
	        		afterCheck.add(changedWord);
	        }
    	}   
    	String output;
    	if (afterCheck.isEmpty()){
    		output = "N/A";
    	}
    	else{
    		output = afterCheck.toString().substring(1, afterCheck.toString().length() - 1);
    	}
    	return output;
    }
    
	
	//Checks words in text file against words in dictionary
	public LinkedList<String> checkFile(LinkedList<String> inputll){
		
		LinkedList<String> misspelled = new LinkedList<>();
		for (int i=0; i<inputll.size(); i++){
			//splits each word in file (input linked list)
			String newLine = inputll.get(i);
			StringTokenizer tokenizer = new StringTokenizer(newLine);
			
			//iterate through, grab new word, remove formatting
   	        while (tokenizer.hasMoreTokens()) {
   	    	     String token = tokenizer.nextToken();
   	    	     token = token.replaceFirst("^[^a-zA-Z']+", "").replaceAll("[^a-zA-Z']+$", "").toLowerCase();
   	    	     //if token word not in hash (dictionary), runChecks on it and add to misspelled linked list
   	    	     if (!hashBrown.contains(token)){   
   	    	    	String linenum = " Line: " + (i+1);
   	    	    	//Call runChecks function
   	    	    	String fixedWords = runChecks(token);
   	    	    	String correction = " Correction: " + (fixedWords);
   	    	    	String everything = token + linenum + correction;
   	    	    	misspelled.add(everything);

   	    	     }
   	        }
   	    }
   	    if (inputll.isEmpty()){
   	    	System.out.println("No errors were found in the document");
   	    }
   	    //Linked list containing all misspelled words
   	    return misspelled;
	}

}
	
	