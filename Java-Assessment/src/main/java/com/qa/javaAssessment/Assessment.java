package com.qa.javaAssessment;

import java.util.Arrays;

public class Assessment {

	// Given a string, return a string where
	// for every char in the original string,
	// there are three chars.

	// multChar("The") ==> "TTThhheee"
	// multChar("AAbb") ==> "AAAAAAbbbbbb"
	// multChar("Hi-There") ==> "HHHiii---TTThhheeerrreee"

	private int count;

	public String multChar(String input) {
		String word = "";
		for (int i = 0; i< input.length(); i++) {
			word += input.substring(i, i+1);
			word += input.substring(i, i+1);
			word += input.substring(i, i+1);
		}
		return word;
	}
	
	// Return the string (backwards) that is between the first and last appearance
	// of "bert"
	// in the given string, or return the empty string "" if there is not 2
	// occurances of "bert" - Ignore Case

	// getBert("bertclivebert") ==> "evilc"
	// getBert("xxbertfridgebertyy") ==> "egdirf"
	// getBert("xxBertfridgebERtyy") ==> "egdirf"
	// getBert("xxbertyy") ==> ""
	// getBert("xxbeRTyy") ==> ""

	public String getBert(String input) {
		
		String lowercase = input.toLowerCase();
		
		int wordtotal = lowercase.length();
		
		int firstbertindex = -1;
		
		int lastbertindex = -1;
		
		String substring;
		
		
		for (int i = 0; i <wordtotal-3; i++) {
			
			substring = lowercase.substring(i, i+4);
			

			
		   if (substring.equals("bert")) {
			   
			   if (firstbertindex == -1) {
				   
				   firstbertindex = i;
				   
				   continue;
				 		   
			   }
			   
			   lastbertindex = i;
			   
		   }
			
		}
	
		
		if (lastbertindex == -1) {
			
			return "";	
		}
			
			
		
		String reversedanswer = lowercase.substring(firstbertindex+4, lastbertindex);
		
		
		
		return new StringBuilder(reversedanswer).reverse().toString();
	
	
	
	}


	// Given three ints, a b c, one of them is small, one is medium and one is
	// large. Return true if the three values are evenly spaced, so the
	// difference between small and medium is the same as the difference between
	// medium and large. Do not assume the ints will come to you in a reasonable
	// order.

	// evenlySpaced(2, 4, 6) ==> true
	// evenlySpaced(4, 6, 2) ==> true
	// evenlySpaced(4, 6, 3) ==> false
	// evenlySpaced(4, 60, 9) ==> false

	public boolean evenlySpaced(int a, int b, int c) {
		int[] array= {a, b, c};
		Arrays.sort(array);
		
		int difference = array[1]-array[2];
		
		return (array[0]-array[1] == difference);
	}
			

	// Given a string and an int n, return a string that removes n letters from the 'middle' of the string.
	// The string length will be at least n, and be odd when the length of the input is odd.

	// nMid("Hello", 3) ==> "Ho"
	// nMid("Chocolate", 3) ==> "Choate"
	// nMid("Chocolate", 1) ==> "Choclate"

	public String nMid(String input, int a) {
		
		int wordlength = input.length();
		
		String firsthalf = input.substring(0, (wordlength-a)/2);
		
		String secondhalf = input.substring((wordlength+a)/2, wordlength);
		
		return firsthalf + secondhalf;
		
		
		
	}


	// Given a string, return the length of the largest "block" in the string.
	// A block is a run of adjacent chars that are the same.
	//
	// superBlock("hoopplla") ==> 2
	// superBlock("abbCCCddDDDeeEEE") ==> 3
	// superBlock("") ==> 0

	public int superBlock(String input) {
		
		int longestblock = 0;
				
		int lengthcurrentblock = 0;
		
		char lastcharacter = 'a';
		
	
		
		for (int i=0; i<input.length(); i++) {
				
			if (lastcharacter == input.charAt(i) && i!=0) {
				
				lengthcurrentblock++;
				
		
				
				
			
			}
			
			else {
				
				lastcharacter = input.charAt(i);
				
				lengthcurrentblock = 1;
				
						
			}
				
			if (lengthcurrentblock>longestblock) {
				
				longestblock = lengthcurrentblock;
				
			}
				
			

			
			
		}
			
		
		return longestblock;

	}
	
	//given a string - return the number of times "am" appears in the String ignoring case -
	// BUT ONLY WHEN the word "am" appears without being followed or proceeded by other letters
	//
	//amISearch("Am I in Amsterdam") ==> 1
	//amISearch("I am in Amsterdam am I?") ==> 2
	//amISearch("I have been in Amsterdam") ==> 0

	public int amISearch(String arg1) {
		
		String word = "am";
		String word2 = "Am";
		
		count = 0;
		
		String[] temp = arg1.split(" ");
		
		for (int i = 0; i <temp.length; i++) {
			
		   if (word.equals(temp[i]) || word2.equals(temp[i])) {
			   
			   count++;
		   }
			
		}
			
		return count;				
		
	}
	
	//given a number 
	// if this number is divisible by 3 return "fizz"
	// if this number is divisible by 5 return "buzz"
	// if this number is divisible by both 3  and 5return "fizzbuzz"
	//
	//fizzBuzz(3) ==> "fizz"
	//fizzBuzz(10) ==> "buzz"
	//fizzBuzz(15) ==> "fizzbuzz"
	
	public String fizzBuzz(int arg1) {
		
		if (arg1 % 15 == 0) {
			
			return "fizzbuzz";
			
			
		}
		
		if (arg1 % 5 ==0) {
			
			return "buzz";
					
		}
		
		if (arg1 % 3 == 0) {
			
			return "fizz";
		}
		
		return null;
				
		
	}
	
	//Given a string split the string into the individual numbers present
	//then add each digit of each number to get a final value for each number
	// String example = "55 72 86"
	//
	// "55" will = the integer 10
	// "72" will = the integer 9
	// "86" will = the integer 14
	//
	// You then need to return the highest vale
	//
	//largest("55 72 86") ==> 14
	//largest("15 72 80 164") ==> 11
	//largest("555 72 86 45 10") ==> 15
	
	public int largest(String arg1) {
		
		
		
		int largestvalue = 0;
				
		int runningtotal = 0;
		
		
		
		for (int i=0; i<arg1.length(); i++) {
				
			if (arg1.charAt(i) == ' '){
			
				runningtotal = 0;
				
						
			}
			
			else {
				
				
				runningtotal += Character.getNumericValue(arg1.charAt(i));
			}
				
			if (runningtotal>largestvalue) {
				
				largestvalue = runningtotal;
				
			}
				
			
			
		}
			
		
		return largestvalue;
	}
}
