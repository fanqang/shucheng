package com.entity;

import java.util.Date;

public class Orderform {
	private String orderNO;
	private Date time;
	private float sumprice;
	private String name;
	private String phone;
	private String address;
	private String orderstatus; //书评 0表示未评价 1表示已评价
	private String user_name;
	public String getOrderNO() {
		return orderNO;
	}
	public void setOrderNO(String orderNO) {
		this.orderNO = orderNO;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public float getSumprice() {
		return sumprice;
	}
	public void setSumprice(float sumprice) {
		this.sumprice = sumprice;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOrderstatus() {
		return orderstatus;
	}
	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public Orderform() {
		super();
	}
	public Orderform(String orderNO, Date time, float sumprice, String name, String phone, String address,
			String orderstatus, String user_name) {
		super();
		this.orderNO = orderNO;
		this.time = time;
		this.sumprice = sumprice;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.orderstatus = orderstatus;
		this.user_name = user_name;
	}
	@Override
	public String toString() {
		return "Orderform [orderNO=" + orderNO + ", time=" + time + ", sumprice=" + sumprice + ", name=" + name
				+ ", phone=" + phone + ", address=" + address + ", orderstatus=" + orderstatus + ", user_name="
				+ user_name + "]";
	}
    
	
	
}
