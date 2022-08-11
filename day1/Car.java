package week1.day1;

public class Car {
//Syntax to create a variable
	//dataType variableName = value;
	byte version = 20;
	short discountedPrice = -32000;
	int imei = -876599087;
	long serialNumber = 99887766554433221l;
	float headPhoneType = 9456.5623368456F;
	double screenSize = 6.5482;
	boolean isMobileCharged = false;
	char series = 'S';
	
	String brand = "Samsung";
	
	public static void main(String[] args) {
		Car car= new Car();
		System.out.println("Version:" +car.version);
		System.out.println("Discounted Price:" +car.discountedPrice);
		System.out.println("Imei:" +car.imei);
		System.out.println("Serial Number:" +car.serialNumber);
		System.out.println("Head Phone Type:" +car.headPhoneType);
		System.out.println("Screen Size:" +car.screenSize);
		System.out.println("Is Mobile Charged:" +car.isMobileCharged);
		System.out.println("Series :" +car.series);
		System.out.println("Brand :" +car.brand);
	}
	


}
