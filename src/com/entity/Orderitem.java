package com.entity;

public class Orderitem {
	private int ID;
	private String orderNO;
	private String bookISBN;
	private float bookPrice;
	private int count;
	private int commentstatus;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getOrderNO() {
		return orderNO;
	}
	public void setOrderNO(String orderNO) {
		this.orderNO = orderNO;
	}
	public String getBookISBN() {
		return bookISBN;
	}
	public void setBookISBN(String bookISBN) {
		this.bookISBN = bookISBN;
	}
	public float getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(Float bookPrice) {
		this.bookPrice = bookPrice;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getCommentstatus() {
		return commentstatus;
	}
	public void setCommentstatus(int commentstatus) {
		this.commentstatus = commentstatus;
	}
	public Orderitem() {
		super();
	}
	public Orderitem(int iD, String orderNO, String bookISBN, float bookPrice, int count, int commentstatus) {
		super();
		ID = iD;
		this.orderNO = orderNO;
		this.bookISBN = bookISBN;
		this.bookPrice = bookPrice;
		this.count = count;
		this.commentstatus = commentstatus;
	}
	@Override
	public String toString() {
		return "Orderitem [ID=" + ID + ", orderNO=" + orderNO + ", bookISBN=" + bookISBN + ", bookPrice=" + bookPrice
				+ ", count=" + count + ", commentstatus=" + commentstatus + "]";
	}
	
	
}
