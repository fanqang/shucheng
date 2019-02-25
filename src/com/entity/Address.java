package com.entity;

public class Address {
	private int ID;
	private String collect_people;
	private String telephone;
	private int zipcode;
	private String address;
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getCollect_people() {
		return collect_people;
	}

	public void setCollect_people(String collect_people) {
		this.collect_people = collect_people;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public Address() {
		super();
	}

	public Address(int iD, String collect_people, String telephone, int zipcode, String address) {
		super();
		ID = iD;
		this.collect_people = collect_people;
		this.telephone = telephone;
		this.zipcode = zipcode;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Address [ID=" + ID + ", collect_people=" + collect_people + ", telephone=" + telephone + ", zipcode="
				+ zipcode + ", address=" + address + "]";
	}
	
	
}
