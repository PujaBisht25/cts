
public class MiniCarFactory implements AbstractCarFactory {

	private Location location;
	public MiniCarFactory(Location location) {
		this.location=location;
	}
	
	@Override
	public Car constructCar() {
		return new MiniCar(location);
	}

}
