package of11.observable.kode;

public class Mail {

	private String fromAddress;
	private String toAddress;
	private String subject;
	private String content;

	public Mail(String fromAddress, String toAddress, String subject, String content) {
		this.fromAddress = fromAddress;
		this.toAddress = toAddress;
		this.subject = subject;
		this.content = content;
	}

	public String getFromAddress() {
		return fromAddress;
	}

	public String getToAddress() {
		return toAddress;
	}

	public String getSubject() {
		return subject;
	}

	public String getContent() {
		return content;
	}

	@Override
	public String toString() {
		return "Mail from \"" + fromAddress + "\" to \"" + toAddress + "\" with subject \"" + subject
				+ "\"\nContent is as follows:\n" + content;
	}

}
