Homework 4 README
Gary Chen
gc2676

Written.pdf - Written portion, contains images

Coding Problem 1:
Spell Checker - Run by inputing words.txt (the dictionary file, unchanged) followed by input.txt when prompted.

Contents of filetospellcheck.txt: “Thhis iis aa pooryl spellt textt documnet. Test nu1mbers and punct’uation.”

Files:
words.txt, filetospellcheck.txt
spellCheckTest.java - Tester for spellcheck. Contains command line prompts and takes in 2 file names, dictionary file name first, then file name of document you wish to spell check. Calls spellChecker and outputs incorrect word, line number and possible corrections.
spellChecker.java - Contains 3 main functions. scanDictionary goes reads in all the lines from dictionary file, stores it in the hash table. runChecks changes incorrect words in the input file text to include an extra character, exclude a character, and have 2 adjacent characters swapped. It then compares all these changed words to the words in the dictionary, and if it is in the dictionary it will output the dictionary version as the correction. checkFile takes in the input file and runs runChecks on it, then concatenates the incorrect word, line # and correction(s).
hashtable.java - Basically the standard java hash table except altered insert so it takes in a single string input.


Coding Problem 2:
KBestCounter - run by entering a number k, and it will show you the k largest elements. Also works with other data types. If you wish to test the program with strings, comment out the integer tester and uncomment the string tester portion (start & end locations marked with comments).

Contents of Integer tester:
Integer[] data = {-99,0,1,3,5,7,9,2,4,6,8};
Contents of String tester:
String[] data2 = {"apple","bagle","cat","dog","elephant"};

Files:
TestKBest.java - Tester program, contains command line prompts and 2 different testers for integer and string.
KBestCounter - Implemented using a max-heap using a priority queue. The heap keeps track of the k largest values, and will add one value at a time, and make sure the heap is correct after each add. readData adds the value from the input data set one at a time on the heap, and output() simply puts the numbers in the heap in largest->smallest order and returns.
