package com.gmmr.rms.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Roommate implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	private int no;
	private String name;
	private String address;
	private String mobile;
	private LocalDate dateOfJoining;
	
	public Roommate() {}

	public Roommate(int no, String name, String address, String mobile, LocalDate dateOfJoining) {
		this.no = no;
		this.name = name;
		this.address = address;
		this.mobile = mobile;
		this.dateOfJoining = dateOfJoining;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	@Override
	public String toString() {
		return "Roommate [no=" + no + ", name=" + name + ", address=" + address + ", mobile=" + mobile
				+ ", dateOfJoining=" + dateOfJoining + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + no;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Roommate)) {
			return false;
		}
		Roommate other = (Roommate) obj;
		if (no != other.no) {
			return false;
		}
		return true;
	}

}