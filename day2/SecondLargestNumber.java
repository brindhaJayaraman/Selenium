package week1.day2;

import java.util.Arrays;

public class SecondLargestNumber {

	public static void main(String[] args) {
		int[] num = {22,67,98,1,34,58,99};
		Arrays.sort(num);
        int length = num.length;
        System.out.println(length);
        
        int SecondLargestNumber=num[length-2];
        System.out.println(SecondLargestNumber);
	}

}
