package collectionsprogram;

import java.util.HashSet;
import java.util.Set;


public class PrintDuplicateNumbers {

	public static void main(String[] args) {
		
		//input
		int[] data = {4,3,6,8,29,1,2,4,7,8};
		
		//Set 1 to store input
		Set<Integer>set=new HashSet<Integer>();
		
		//set 2 to store duplicates
		
		Set<Integer>dupSet=new HashSet<Integer>();
		
		//Check for duplicates
		for(Integer numbers: data) {
			if(!set.add(numbers)) {
				dupSet.add(numbers);
			}
		}
        System.out.println("Numbers in Set:" +set);
        System.out.println("Duplicates in Set:" +dupSet);
	}

}

