
public class Main {

	public static void main(String[] args) {
		JohnObserver john  = new JohnObserver();
		SteveObserver steve = new SteveObserver();
		
		NotificationService n = new NotificationService();
		n.addSubscriber(john);
		n.addSubscriber(steve);
		
		n.notifySubscriber();
		
		n.removeSubscriber(john);
	}

}
