package week1.day1.assignments;

public class ConvertANegativeNumberToPostivieNumber {
    int number = -568;
	public static void main(String[] args) {
		ConvertANegativeNumberToPostivieNumber negativetopositive = new ConvertANegativeNumberToPostivieNumber();
		if (negativetopositive.number<0) {
			negativetopositive.number = negativetopositive.number* -1;
			System.out.println("Converted Positive Number:" +negativetopositive.number);
		}

	}

}