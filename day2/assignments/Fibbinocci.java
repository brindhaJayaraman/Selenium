package week1.day2.assignments;

public class Fibbinocci {

	public static void main(String[] args) {
		int firstNumb = 0, secondNumb=1, sum = 0;
		System.out.println(firstNumb+ " "+secondNumb);
		for (int i = 2 ;i< 11; i++ ) {
			sum = firstNumb+ secondNumb;
			System.out.println(" " + sum);
			firstNumb = secondNumb;
			secondNumb = sum;
		}
		

	}

}
