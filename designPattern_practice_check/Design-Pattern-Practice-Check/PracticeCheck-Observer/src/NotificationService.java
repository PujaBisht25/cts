import java.util.List;
import java.util.*;

public class NotificationService implements INotificationService {

	private List<INotificationObserver> subscriber = new ArrayList<>();
	@Override
	public void addSubscriber(INotificationObserver observer) {
		subscriber.add(observer);
		for(INotificationObserver subscriber : subscriber) {
			System.out.println(subscriber);
		}
	}

	@Override
	public void removeSubscriber(INotificationObserver observer) {
		subscriber.remove(observer);
		for(INotificationObserver subscriber : subscriber) {
			System.out.println(subscriber);
		}
	}

	@Override
	public void notifySubscriber() {
		for(INotificationObserver subscriber : subscriber) {
			subscriber.OnServerDown();
		}
	}

}
