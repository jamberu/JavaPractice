import java.util.Scanner;

public class Cellphone {
	static float prepaidLoad = 15.00f;
	static int battery = 10;
	
	static final int callDeduct = 5;
	static final int missCallDeduct = 2;
	static final int smsDeduct = 1;
	static final int reloadAdd = 5;
	static final int rechargeAdd = 5;
	
	public static void setBattery(int battery, String mode) {
		if (mode.equalsIgnoreCase("deduct")) {
			Cellphone.battery -= battery;
		}
		else if (mode.equalsIgnoreCase("add")) {
			Cellphone.battery += battery;
		}
	}

	public static void setPrepaidLoad(int load, String mode) {
		float intToFloatLoad = (float) load;
		
		if (mode.equalsIgnoreCase("deduct")) {
			Cellphone.prepaidLoad -= intToFloatLoad;
		}
		else if (mode.equalsIgnoreCase("add")) {
			Cellphone.prepaidLoad += intToFloatLoad;
		}	
	}
	
	public static void reload() {
		if (Cellphone.prepaidLoad == 15.00) {
			System.out.println("The maximum load you can have is P15.00\n");
		}
		else {
			Cellphone.setPrepaidLoad(reloadAdd, "add");
		}
	}
	
	public static void recharge() {
		if (Cellphone.battery == 10) {
			System.out.println("The maximum charge you can have is 10%\n");
		}
		else {
			Cellphone.setBattery(rechargeAdd, "add");
		}
	}
	
	public static void sendSMS() { 
		Cellphone.setBattery(smsDeduct, "deduct");
		Cellphone.setPrepaidLoad(smsDeduct, "deduct");
	}

	public static void missCall() { 
		Cellphone.setBattery(missCallDeduct, "deduct");
		Cellphone.setPrepaidLoad(missCallDeduct, "deduct");
	}
	
	public static void call() { 
		Cellphone.setBattery(callDeduct, "deduct");
		Cellphone.setPrepaidLoad(callDeduct, "deduct");
	}
	
	public static void displayMenu() {
		System.out.println("1 - Send SMS\t\t\t: Deduct 1 charge from prepaid load and battery");
		System.out.println("2 - Missed Call\t\t\t: Deduct 2 charges from prepaid load and battery");
		System.out.println("3 - Call\t\t\t: Deduct 5 charges from prepaid load and battery");
		System.out.println("4 - Reload\t\t\t: Add 5 charges from prepaid load");
		System.out.println("5 - Recharge\t\t\t: Add 5 charges from battery");
		System.out.println("6 - Back to Menu\t\t: Display the menu");
		System.out.println("7 - Balance Inquiry\t\t: Display the current prepaid load and battery");
		System.out.println("8 - Exit\t\t\t: Terminate the program");
		System.out.print("\nEnter your choice: ");
	}
	
	public static void balanceInquiry() {
		System.out.printf("Prepaid Load: P%.2f\nBattery Value: %d%%\n", Cellphone.prepaidLoad, Cellphone.battery);
	}
	public static void main(String[] args) {
		Scanner entry = new Scanner(System.in);
		
		while (true) {
			Cellphone.displayMenu();
			int choice = entry.nextInt();
			
			switch (choice) {
			case 1:
				Cellphone.sendSMS();
				break;
			case 2:
				Cellphone.missCall();
				break;
			case 3:
				Cellphone.call();
				break;
			case 4:
				Cellphone.reload();
				break;
			case 5:
				Cellphone.recharge();
				break;
			case 6:
				Cellphone.displayMenu();
				break;
			case 7:
				Cellphone.balanceInquiry();
				break;
			case 8:
				entry.close();
				System.exit(0);
			}
		}
	}
	
}
