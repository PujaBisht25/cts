
public class LuxuryCarFactory implements AbstractCarFactory {

	private Location location;
	public LuxuryCarFactory(Location location) {
		this.location=location;
	}
	@Override
	public Car constructCar() {
		return new LuxuryCar(location);
	}

}
