
public class CarClient {

	public static void main(String[] args) {
		
		//AbstractCarFactory factory = new AbstractCarFactory();
		//CarFactory CarFactory = factory.getFactory(CarType.LUXURY);
		//CarFactory carFactory = new LuxuryCarFactory();
		System.out.println(CarFactory.buildCar(CarType.LUXURY, Location.DEFAULT));
		System.out.println(CarFactory.buildCar(CarType.MICRO, Location.USA));
		System.out.println(CarFactory.buildCar(CarType.MINI, Location.INDIA));
	}

}
