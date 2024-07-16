package com.zoo;

public class ContactDtls {

	private int id;
	private String name;
	private String emailid;
	private String contact;
	private String message;
	private String msgDate;
	private String isRead;
	private String password;
	
	public ContactDtls() {
	
	}

	public ContactDtls(String name, String emailid, String contact, String message, String msgDate, String isRead,
			String password) {
		super();
		this.name = name;
		this.emailid = emailid;
		this.contact = contact;
		this.message = message;
		this.msgDate = msgDate;
		this.isRead = isRead;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public String getMsgDate() {
		return msgDate;
	}
	public void setMsgDate(String msgDate) {
		this.msgDate = msgDate;
	}

	public String getIsRead() {
		return isRead;
	}
	public void setIsRead(String isRead) {
		this.isRead = isRead;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "ContactDtls [id=" + id + ", name=" + name + ", emailid=" + emailid + ", contact=" + contact
				+ ", message=" + message + ", msgDate=" + msgDate + ", isRead=" + isRead + ", password=" + password
				+ "]";
	}	
}