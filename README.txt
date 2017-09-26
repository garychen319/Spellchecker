Spell Checker - Run by inputing words.txt (the dictionary file, unchanged) followed by input.txt when prompted.

Contents of filetospellcheck.txt: “Thhis iis aa pooryl spellt textt documnet. Test nu1mbers and punct’uation.”

Files:
words.txt, filetospellcheck.txt
spellCheckTest.java - Tester for spellcheck. Contains command line prompts and takes in 2 file names, dictionary file name first, then file name of document you wish to spell check. Calls spellChecker and outputs incorrect word, line number and possible corrections.
spellChecker.java - Contains 3 main functions. scanDictionary goes reads in all the lines from dictionary file, stores it in the hash table. runChecks changes incorrect words in the input file text to include an extra character, exclude a character, and have 2 adjacent characters swapped. It then compares all these changed words to the words in the dictionary, and if it is in the dictionary it will output the dictionary version as the correction. checkFile takes in the input file and runs runChecks on it, then concatenates the incorrect word, line # and correction(s).
hashtable.java - Basically the standard java hash table except altered insert so it takes in a single string input.
