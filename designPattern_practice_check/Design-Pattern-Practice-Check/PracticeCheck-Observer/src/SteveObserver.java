
public class SteveObserver implements INotificationObserver {

	private String name = "Steve";
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void OnServerDown() {
		System.out.println(name + " notification has been received.");
	}

	@Override
	public String toString() {
		return "SteveObserver [name=" + name + "]";
	}

}
