package collectionsprogram;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

	public static void main(String[] args) {
		String name = "PayPal India";
		
		//convert to character array
		char[] nameChar = name.toCharArray();
		
		//set1 to store characters
		Set<Character>charSet=new HashSet<Character>();
		
		//set2 to store duplicate
		Set<Integer>dupCharSet=new HashSet<Integer>();
		
		//check for duplicates and add duplicates to another set
		for (Character charSet1 : nameChar) {
			if (!charSet.add(charSet1)) {
				dupCharSet.add(charSet1);
				
			}
		}
	
		System.out.println("Characters in the Set :" + charSet);
		System.out.println("Duplicates in the Set:" + dupCharSet);

	}

}
