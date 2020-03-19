package of11.observable.lf;

import java.util.ArrayList;
import java.util.List;

public class MailingList {

	private List<MailingListSubscriber> subscribers = new ArrayList<>();
	
	public void subscribe(MailingListSubscriber subscriber) {
		if (!subscribers.contains(subscriber)) {
			subscribers.add(subscriber);
		}
	}
	
	public void unsubscribe(MailingListSubscriber subscriber) {
		if (subscribers.contains(subscriber)) {
			subscribers.remove(subscriber);
		}
	}
	
	public void sendMail(Mail mail) {
		for (MailingListSubscriber subscriber : subscribers) {
			subscriber.notifyNewMail(mail);
		}
		
		// subscribers.forEach((subscriber) -> subscriber.notifyNewMail(mail)); 
	}
	
	public static void main(String[] args) {
		MailingList list = new MailingList();
		
		Inbox inbox1 = new Inbox("halvard.hummel@ntnu.no");
		Inbox inbox2 = new Inbox("it@ntnu.no");
		
		//list.subscribe(inbox2);
		inbox2.subscribeToMailingList(list);
		
		list.sendMail(new Mail("halvard.hummel@ntnu.no", "orakel@ntnu.no", "HJELP!!!!", "Eclipse fungerer ikke, hva gjør jeg!!!"));
		
		inbox2.deleteInbox();
		
		list.sendMail(new Mail("halvard.hummel@ntnu.no", "orakel@ntnu.no", "HJELP!!!!", "Eclipse fungerer ikke, hva gjør jeg!!!"));
		
		//inbox2.getMail().forEach((mail) -> System.out.println(mail));
		
		//inbox1.getMail().forEach((mail) -> System.out.println(mail));
	}
	
}
