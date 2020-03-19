package of11.observable.kode;

import java.util.ArrayList;
import java.util.List;

public class Inbox  {
	
	private String address;
	private List<Mail> mail = new ArrayList<>();
	
	public Inbox(String address) {
		this.address = address;
	}
	
	public List<Mail> getMail() {
		return new ArrayList<>(mail);
	}
	
}
