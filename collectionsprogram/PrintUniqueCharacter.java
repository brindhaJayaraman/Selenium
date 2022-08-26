package collectionsprogram;

import java.util.HashSet;
import java.util.Set;

public class PrintUniqueCharacter {

	public static void main(String[] args) {
		
		String name = "brindha";
		
		//Convert String to Character array
		char[] nameChar = name.toCharArray();
		
		//Create Hash set
		Set<Character>setChar=new HashSet<Character>();
		
		//Print unique character
		for(Character uniqChar: nameChar) {
			
			//if the character repeats remove
			if(!setChar.add(uniqChar)) {
				setChar.remove(uniqChar);
			}
		}
		
System.out.println(setChar);
	}

}
