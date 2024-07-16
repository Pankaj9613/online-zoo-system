package com.zoo;

public class TicketForeign {
	
	private int id;
	private int TicketID;
	private String NoAdult;
	private String NoChildren;
	private String AdultUnitprice;
	private String ChildUnitprice;
	private String PostingDate;
	
	public TicketForeign() {
		super();
	}
	
	public TicketForeign(int ticketID, String noAdult, String noChildren, String adultUnitprice,
			String childUnitprice) {
		super();
		TicketID = ticketID;
		NoAdult = noAdult;
		NoChildren = noChildren;
		AdultUnitprice = adultUnitprice;
		ChildUnitprice = childUnitprice;		
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getTicketID() {
		return TicketID;
	}
	public void setTicketID(int ticketID) {
		TicketID = ticketID;
	}
	
	public String getNoAdult() {
		return NoAdult;
	}
	public void setNoAdult(String noAdult) {
		NoAdult = noAdult;
	}
	
	public String getNoChildren() {
		return NoChildren;
	}
	public void setNoChildren(String noChildren) {
		NoChildren = noChildren;
	}
	
	public String getAdultUnitprice() {
		return AdultUnitprice;
	}
	public void setAdultUnitprice(String adultUnitprice) {
		AdultUnitprice = adultUnitprice;
	}
	
	public String getChildUnitprice() {
		return ChildUnitprice;
	}
	public void setChildUnitprice(String childUnitprice) {
		ChildUnitprice = childUnitprice;
	}
	
	public String getPostingDate() {
		return PostingDate;
	}
	public void setPostingDate(String postingDate) {
		PostingDate = postingDate;
	}
	
	@Override
	public String toString() {
		return "TicketForeign [id=" + id + ", TicketID=" + TicketID + ", NoAdult=" + NoAdult + ", NoChildren="
				+ NoChildren + ", AdultUnitprice=" + AdultUnitprice + ", ChildUnitprice=" + ChildUnitprice
				+ ", PostingDate=" + PostingDate + "]";
	}
}