
public class MicroCarFactory implements AbstractCarFactory {

	private Location location;
	public MicroCarFactory(Location location) {
		this.location=location;
	}
	
	@Override
	public Car constructCar() {
		return new MicroCar(location);
	}

}
