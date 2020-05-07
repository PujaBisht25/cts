
public class MiniCar extends Car {

	public MiniCar(Location location) {
		super(CarType.MINI, location);
		construct();
	}
	
	@Override
	void construct() {
		System.out.println("Connecting to mini car.");
	}
}
