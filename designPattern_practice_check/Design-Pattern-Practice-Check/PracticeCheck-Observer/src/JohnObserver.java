
public class JohnObserver implements INotificationObserver {

	private String name = "John";
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "JohnObserver [name=" + name + "]";
	}

	@Override
	public void OnServerDown() {
		System.out.println(name + " notification has been received.");
	}

}
