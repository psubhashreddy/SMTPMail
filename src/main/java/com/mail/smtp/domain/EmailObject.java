package com.mail.smtp.domain;

public class EmailObject {
	
	private String mailTo;
	private String mailFrom;
	private String mailsubject;
	private String mailBody;
	
	private String attachementPath;

	public String getMailTo() {
		return mailTo;
	}

	public void setMailTo(String mailTo) {
		this.mailTo = mailTo;
	}

	public String getMailFrom() {
		return mailFrom;
	}

	public void setMailFrom(String mailFrom) {
		this.mailFrom = mailFrom;
	}

	public String getMailsubject() {
		return mailsubject;
	}

	public void setMailsubject(String mailsubject) {
		this.mailsubject = mailsubject;
	}

	public String getMailBody() {
		return mailBody;
	}

	public void setMailBody(String mailBody) {
		this.mailBody = mailBody;
	}

	public String getAttachementPath() {
		return attachementPath;
	}

	public void setAttachementPath(String attachementPath) {
		this.attachementPath = attachementPath;
	}

}
