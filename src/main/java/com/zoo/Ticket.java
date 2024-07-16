package com.zoo;

public class Ticket {

	private int tid;
	private String TicketType;
	private String Price;
	
	public Ticket() {
		super();
	}

	public Ticket(int tid, String ticketType, String price) {
		super();
		this.tid = tid;
		TicketType = ticketType;
		Price = price;
	}
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTicketType() {
		return TicketType;
	}
	public void setTicketType(String ticketType) {
		TicketType = ticketType;
	}
	
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
		
	@Override
	public String toString() {
		return "Ticket [tid=" + tid + ", TicketType=" + TicketType + ", Price=" + Price + "]";
	}
}