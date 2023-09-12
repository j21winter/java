package devices;

public class Phone extends Device {

	public Phone() {
		super();
	}

	public void makeCall() {
		if(battery > 5){
			System.out.println("Making Call\n");
			battery -= 5;
			super.displayBattery();
			checkBattery();
		} else {
			System.out.println("Insufficient Battery\nPlease Charge Phone");
		}
	}
	
	public void playGame() {
		if(battery > 25){
			System.out.println("Playing Game\n");
			battery -= 20;
			super.displayBattery();
			checkBattery();
		} else {
			System.out.println("Insufficient Battery\nPlease Charge Phone");
		}
	}
	
	public void chargePhone() {
		System.out.println("Changing Phone\n");
		if(battery <= 50) {
			battery += 50;
			super.displayBattery();
			checkBattery();
		}else {
		battery = 50;
		super.displayBattery();
		checkBattery();
		}
	}
	
	public void checkBattery() {
		if(battery <= 10 ) {
			System.out.println("Battery Levels Critical: ");
			super.displayBattery();
		} 
	}

}