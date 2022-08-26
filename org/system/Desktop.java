package org.system;

public class Desktop extends Computer{

	public void desktopSize() {
		
		System.out.println("24 inch ");
	}

	public static void main(String[] args) {
		Computer singleInheritance = new Computer();
		singleInheritance.computerModel();
		
		Desktop desktopinherit = new Desktop();
		desktopinherit.desktopSize();
	}
}
