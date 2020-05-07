public class CarFactory {

	public static Car buildCar(CarType model, Location location) {
		AbstractCarFactory abstractCarFactory;
		if(model == CarType.LUXURY) {
			abstractCarFactory= new LuxuryCarFactory(location);
		}
		else if(model == CarType.MICRO) {
			abstractCarFactory= new MicroCarFactory(location);
		}
		else {
			abstractCarFactory= new MiniCarFactory(location);
		}
		return abstractCarFactory.constructCar();
	}
}