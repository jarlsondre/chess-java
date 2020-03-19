package of11.observable.lf;

import java.util.ArrayList;
import java.util.List;

public class Inbox implements MailingListSubscriber {
	
	private String address;
	private List<Mail> mail = new ArrayList<>();
	private List<MailingList> mailingLists = new ArrayList<>();
	
	public Inbox(String address) {
		this.address = address;
	}
	
	public void subscribeToMailingList(MailingList mailingList) {
		if (!mailingLists.contains(mailingList)) {
			mailingList.subscribe(this);
			mailingLists.add(mailingList);
		}
	}
	
	public void deleteInbox() {
		for (MailingList mailingList : mailingLists) {
			mailingList.unsubscribe(this);
		}
		
		mailingLists.clear();
		mail.clear();
	}
	
	public List<Mail> getMail() {
		return new ArrayList<>(mail);
	}

	@Override
	public void notifyNewMail(Mail mail) {
		this.mail.add(mail);
		
		System.out.println(address + " recieved mail: \n" + mail);
	}
	
}
