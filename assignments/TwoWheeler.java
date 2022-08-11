package week1.day1.assignments;

public class TwoWheeler {
	int noOfWheels = 4;
	short noOFMirrors = 2;
	long chasisNumber =154962589547858955l;
	boolean isPunctured = false;
	double runningKM = 5.5478;
	String bikeName = "activa";

	public static void main(String[] args) {
		TwoWheeler twowheeler = new TwoWheeler();
		System.out.println("Wheels:" +twowheeler.noOfWheels);
		System.out.println("Mirrors:"+twowheeler.noOFMirrors);
		System.out.println("Chassis Number:" +twowheeler.chasisNumber);
		System.out.println("Punctured:" +twowheeler.isPunctured);
		System.out.println("Kilometers Run:" +twowheeler.runningKM);
		System.out.println("Bike Name:" +twowheeler.bikeName);
	}

}
