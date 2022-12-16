import java.util.*;

public class Solution
{
	public static void main(String[] args) {
		/*
		 * romanToInt
		 * String s = "III";
		String s1 = "LVIII";
		String s2 = "IV"; 
		String s3 = "CMLXXXIII";
		String s4 = "MCMXCIV"; 
		romanToInt(s);
		romanToInt(s1);
		romanToInt(s2);
		romanToInt(s3);
		romanToInt(s4);
		 */
		
		 String[] lCPStrings = new String[]{"flower", "flow", "flight"};

		 System.out.println(longestCommonPrefix(lCPStrings));
	}

	public static String longestCommonPrefix(String[] strs) {
        /*
		 * Write a function to find the longest common prefix string amongst an array of strings.
		 * If there is no common prefix, return an empty string "".
		 * 
		 * Input: strs = ["flower","flow","flight"]
		 * Output: "fl"
		 * 
		 * Logic: 
		 * Take the items in Strings array and add to a hashmap 
		 * Find an efficient way to iterate through each item by checking if the next item 
		 * contains the same letter as the first item 
		 * then we have the first letter of the prefix, then next without a nested loop
		 * 
		 * Brute Force: 
		 * for loop through input array 
		 * nested for loop to go through each character in each item of string array 
		 * while loop probably to keep index of first item in array and check with next item, adding character to a string 
		 * 
		 * Solution:
		 * Add strs to a Map
		 * use characters of first index in map to compare with rest
		 * ------
		 * Use math?? 
		 * -------
		 * 
		 * 
		 * Problem:
		 * Need to figure out what the key value pair will be 
		 * 	- key is item then value is each character of the item 
		 * -------
		 * need to create solution that finds common prefixes NOT FOR ALL indexes 
		 * 	- this means common prefix can just be from two of the words out of whole array 
		 * 	- cannot just take the item in first index and compare with the rest 
		 * 	- need to find a way to go through the first index of each character in string array
		 * 		- keep tally of sum of total times each letter shows up in a hashmap + index of character 
		 * 		- then figure out a way to loop through map
		 * 			- condition for starting search at index 0 then next so that we can return a string with the longest common prefix 
		 * 				- concatonate to an empty string 
		 */
		
		 System.out.println("original: " + Arrays.toString(strs));
		 //Map<Character, Integer> charTallyMap = new HashMap(); 
		 //ArrayList<String> arrItems = new ArrayList(Arrays.asList(strs)); 
		 //arrStringItems.addAll(strs);
		 String[] arrItems = Arrays.copyOf(strs, strs.length); 
		 System.out.println("arraylist: " + Arrays.toString(arrItems));  

		 
		 //sum up total number of times each letter shows up in entire arrItems 
		 /*
		  * was able to iterate through arrItems and go through each character in each item 
		  * now need to figure out how to add character value to hashmap + sum of number of times it shows up in array 
		  * 	- need to figure out how to also store the index of each letter added to hashmap 
		  			- cuz just cuz f shows up three times doesnt mean it's at the first index 
					- need to be able to keep track so that i can compare the data at the end in the hashmap and add the values that are most common to a string based on the index and sum value 
		* - first map should be the character and index 
		* USE ARRAYLIST AS VALUE FOR HASHMAP  
		*/
		/*
		 * Multidimensional ArrayList 
		 */
		/*
		int k = 0;
		ArrayList<ArrayList<String>> rows = new ArrayList<>();
		for(int i=0; i<5; i++){
			ArrayList<String> row = new ArrayList<>();
			for(int j=0; j<5; j++){
				String val = Integer.toString(k); 
				row.add(val);
				k += 1; 
			}
			rows.add(row); 
			k = 0; 
		}
		for(int i=0; i<5; i++){
			for(int j=0; j<5; j++){
				System.out.print(rows.get(i).get(j)+" "); //getting each element in multidimensional array 
			 }
			 System.out.println("");
		}
		*/
		
		/*
			LOGIC: 
			- create hashmap key: character, value(arraylist-integer): index found at, number of times found here
			- if character is found in hashmap key and value of index at is the same as the loop iteration then update number of times found ++
				- OR add character to string
					- in order for character to be added to string it must be found at the same index more than once 
					- maybe just compare character with hashmap(character, index found at) and if found add to string 
						- but what if another character at the same index if more frequently found? 
							- need to keep count and have condition to compare 
			- else set 
		*/
		
		Map<Character, Integer> charVals = new HashMap<Character, Integer>(); 
		int i = 0;
		String commonPrefix = ""; 
		List<String> allCommonPrefix = new ArrayList<String>(); 
		
		
		while(i < arrItems.length){
			//int index = 0; 
			int total = 1; 
			Character letter = null;  
			System.out.println("i: " + i);
			System.out.println("checking for " + arrItems[i]);
			//first figure out how to set hashmap with proper values including exception of if already in map then just sum++
			for (int j = 0; j < arrItems[i].length(); j++){ //through each character in each item in array 
				System.out.println("j: " + j);
				letter = arrItems[i].charAt(j); //getting character from item in array 
				System.out.println("char at index " + j + " is " + letter); 
				//need logic for checking and adding: letter, index found at, total number of times found at this index 
				//then need logic for if
				if (charVals.containsKey(letter) && charVals.get(letter) == j) {
					//StringBuilder commonFound = new StringBuilder(); 
					//commonFound.append(letter); 
					//total += 1; 
					//System.out.println("commonFound: " + commonFound.toString()); 
					System.out.println("yes: " + letter); 
					commonPrefix += letter.toString();
					System.out.println("commonPrefix: " + commonPrefix); 
					
				}
				else {
					charVals.put(letter, j); 
				}
			}
			System.out.println("charVals: " + charVals); 
			allCommonPrefix.add(commonPrefix); 
			commonPrefix = ""; 
			//System.out.println(commonPrefix); 
			
			//System.out.println("commonFound: " + commonFound.toString());
			i++;
		}
		
		System.out.println("allCommonPrefix: " + allCommonPrefix.toString()); 
		String longestCommonPrefix = ""; 
		
		for (int k = 0; k < allCommonPrefix.size(); k++){
			if (allCommonPrefix.get(k) == ""){
				longestCommonPrefix += ""; 
			}
			else {
				
				longestCommonPrefix += allCommonPrefix.get(k).toString(); 
				// longestCommonPrefix += ;
			}
			System.out.println(longestCommonPrefix);
		}
		
		//String[] commonPrefixArr = allCommonPrefix.toArray(new String[allCommonPrefix.size()]);
		//System.out.println("commonPrefixArr: " + Arrays.toString(commonPrefixArr)); 
		
		//findingCommonPrefix(commonPrefixArr); 
		
		// MAYBE INSTEAD NEED TO ADD UP NUMBER OF TIMES EACH LETTER SHOWS UP AT EACH INDEX AND ADD EACH CHARACTER GIVEN THE VALUES TO A STRING 
			// - as long as a letter shows up more than once, it should be added 
				// - do not add a letter if it shows up more 
		//findingCommonPrefix(); 
		// Map<String, ArrayList<Character, Integer>> charVals = new HashMap<Character, ArrayList<Character, Integer>>();

		// while (i < arrItems.length){ //through each item in array 
		// 	int index = 0; 
		// 	int total = 0; 
		// 	Character letter = null;  
		// 	System.out.println("i: " + i);
		// 	System.out.println("checking for " + arrItems[i]);
		// 	//first figure out how to set hashmap with proper values including exception of if already in map then just sum++
		// 	for (int j = 0; j < arrItems[i].length(); j++){ //through each character in each item in array 
		// 		System.out.println("j: " + j);
		// 		letter = arrItems[i].charAt(j); //getting character from item in array 
		// 		System.out.println("char at index " + j + " is " + letter); 
		// 		//need logic for checking and adding: letter, index found at, total number of times found at this index 
		// 		//then need logic for if 
		// 		if (charVals.containsKey(letter)){

		// 		}
		// 		else{
		// 			charVals.put(letter, new ArrayList<Integer>());
		// 			// charVals.put(letter, new ArrayList<Integer>()); 
		// 			charVals.add(j); //index 
		// 			charVals.add(total); //total 
		// 		}
		// 	}
		// 	i++; 
		//  }




		String test = "working"; 
		return test; 
    }
	
	public static int romanToInt(String s) {
		//need to use recursion for the addition of turning larger numerals to single values 
		//need a base case and then else statement for the actual calculation 
        //can also use a map to map elements then if the string contains any of the elements it will assign the value and calculate but this is more advanced
		//I = 1 
        //V = 5
        //X = 10 
        //L = 50 
        //C = 100 
        //D = 500 
        //M = 1000
		String[] substrings = s.split("");
		System.out.println(Arrays.toString(substrings));
		HashMap<String, Integer> romanVals = new HashMap<String, Integer>(); 
		int sum = 0; 
		int[] subValues = new int[substrings.length]; 

		romanVals.put("I", 1);
		romanVals.put("V", 5);
		romanVals.put("X", 10);
		romanVals.put("L", 50);
		romanVals.put("C", 100);
		romanVals.put("D", 500);
		romanVals.put("M", 1000);

		
		for (int i = 0; i < substrings.length; i++){
			if (romanVals.containsKey(substrings[i])){
				//System.out.println(romanVals.get(substrings[i]));
				subValues[i] = romanVals.get(substrings[i]); 
					//arr[i] = arr[i] + arr[j];
					//arr[j] = arr[i] - arr[j];
					//arr[i] = arr[i] - arr[j];
					// System.out.print(subValues[0]);
					// System.out.print("\n" + subValues[1] + "\n");
					// subValues[0] = subValues[0] + subValues[1]; 
					// System.out.print("\n" + subValues[0]);
					// System.out.print("\n" + subValues[1] + "\n");
					// subValues[1] = subValues[0] - subValues[1];
					// System.out.print("\n" + subValues[0]);
					// System.out.print("\n" + subValues[1] + "\n"); 
					// subValues[0] = subValues[0] - subValues[1];
					// System.out.print("\n" + subValues[0]);
					// System.out.print("\n" + subValues[1] + "\n");
				//sum += romanVals.get(substrings[i]); 
				//if greater value key is after a lower vslue key then subtract the total higher value key sum to the total?
			}
			
				//sum += romanVals.get(substrings[i]); 
			//sum += subValues[i]; 
			//System.out.println(substrings[i]);
		}
		int subtractVal = 0; 
		int additionVal = 0; 
		int i = 0; 
		/*
		 * Logic: 
		 * isTrue is false until i reaches index subValues.length - 1
		 * add value of last index in the while loop to additionVal 
		 * 
		 * Problem: 
		 * it is taking last index and adding it to the subtract condition statement when it should skip it 
		 */
		while (i < subValues.length) {
			if (i == subValues.length - 1) {
				additionVal += subValues[i]; 
				i++; 
			}
			else if (subValues[i] < subValues[i+1]) {
				subtractVal += subValues[i+1] - subValues[i];
				i += 2; 
			}
			else {
				additionVal += subValues[i];
				i++; 
			}
		}
		// for (int i = 0; i < subValues.length; i++){
		// 	if (i == subValues.length - 1){
		// 		additionVal += subValues[i];
		// 	}
		// 	else if (subValues[i] < subValues[i+1]){
		// 		subtractVal += subValues[i+1] - subValues[i];
		// 	}
		// 	else {
		// 		additionVal += subValues[i];

		// 	}
		// }
		sum = additionVal + subtractVal; 
		//sum += subValues[0]; 
		System.out.println(Arrays.toString(subValues));
		System.out.println(sum);
		return sum; 

	}

}


		
		// 
			
			
			// if (subValues[i] > subValues[i-1]){
			// 	sum += subValues[i] - subValues[i-1];
			// 	subValues[i] = 0; 
			// 	subValues[i-1] = 0;
			// }
			// else {
			// 	sum += subValues[i]; 
			// 	subValues[i] = 0; 
			// }
			//System.out.println("iteration: " + i + " ;" + " sum: " + sum);
		//}


		//System.out.println(Arrays.toString(subValues));
		// if (subValues[1] > subValues[0]){
		// 	int[] remainingItems = Arrays.copyOfRange(subValues, 2, subValues.length - 1);
		// 	//System.out.println(Arrays.toString(remainingItems));
		// 	int remainingSum = 0; 
		// 	for (int i = 0; i < remainingItems.length; i++){
		// 		remainingSum += remainingItems[i]; 
		// 		//System.out.println("Remaining sum: " + remainingSum);
		// 		sum = subValues[1] - subValues[0] + remainingSum; 
		// 	}
		// }
		// else {
		// 	for (int i = 0; i < subValues.length; i++){
		// 		sum += subValues[i]; 
		// 	}
		// }
		// //System.out.println(sum);

		//System.out.println(romanVals);
		
		// for (int i = 0; i<substrings.length; i++){
		// 	System.out.print(substrings[i] + " ");
		// }

	// public static int recurSum(int n)
    // {
    //     if (n <= 1)
    //         return n;
    //     return n + recurSum(n - 1);
    // }
