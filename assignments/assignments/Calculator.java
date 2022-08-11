package week1.day2.assignments;


public class Calculator {
	
	public int add(int num1, int num2, int num3) {
		int sum = num1+num2+num3;
		return sum;
	}
    public int sub(int num1,int num2) {
    	int minus = num1-num2;
    	return minus;
    }
    public double mul(double num1, double num2) {
    	double multiply = num1*num2;
    	return multiply;
    }
    public float divide(double d, double e) {
    	float div = (float) (d / e);
    	return div;
    }
    
  
 public static void main(String[]args) {
	 
	 MyCalculator call1 = new MyCalculator();
	 System.out.println ("Sum of Numbers: " +call1.addNumbers);
	 System.out.println ("Diff of Numbers:" +call1.subNumbers);
	 System.out.println ("Product :" +call1.mulNumbers);
	 System.out.println ("Division:" +call1.divNumbers);
 }
		
}
class MyCalculator{
	Calculator cal = new Calculator();
	int addNumbers = cal.add(8, 5, 2);
	int subNumbers = cal.sub(5, 4);
	double mulNumbers = cal.mul(1.25, 1.2);
	float divNumbers = cal.divide(5.2, 4.5);
}

	

