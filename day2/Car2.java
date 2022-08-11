package week1.day2;

public class Car2 {
	
	public void printCarBrand() 
	{
		System.out.println("Maruthi");
	}
	
    public String getCarColor() 
    {
	return "orange";
    }
    
    public int getEngineNumber()
    {
    	return 782455292;
    }
    
    public int subTwoNumbers(int a, int b)
    {
    	int c= a-b;
    	return c;
    }
    
    public int multiplicationOfTwoNumbers(int a, int b)
    {
    	int c = a*b;
    	return  c;
    }
    
    public int divisionOfTwoNumber (int a, int b)
    {
    	int c =  a/b;
    	return c;
    }
	public static void main(String[] args) {
		
		Car2 objcar2 = new Car2();
		
		objcar2.printCarBrand();
		
		String Carcolor = objcar2.getCarColor();
		System.out.println(Carcolor);
		
		int subtractionOutput = objcar2.getEngineNumber();
		System.out.println(subtractionOutput);
		
		int sub = objcar2.subTwoNumbers (6,5);
		System.out.println(sub);
		
		int multiplicationOutput = objcar2.multiplicationOfTwoNumbers(4,5);
		System.out.println(multiplicationOutput);
		
		int divisionOutput = objcar2.divisionOfTwoNumber(4,2);
		System.out.println(divisionOutput);
		

	}

}
