package com.giri.customer.dto;

import java.io.Serializable;

import com.giri.customer.constant.Education;

public class CustomerDTO implements Serializable{
	private int id;
	private String name;
	private String from;
	private String to;
	private String address;
	private int passportNo;
	private boolean married;
	private Education  type;
public CustomerDTO() {}
public CustomerDTO(String name, String from, String to, String address, int passportNo, boolean married,
		Education type) {
	super();
	this.name = name;
	this.from = from;
	this.to = to;
	this.address = address;
	this.passportNo = passportNo;
	this.married = married;
	this.type = type;
}
@Override
public String toString() {
	return "CustomerDTO [id=" + id + ", name=" + name + ", from=" + from + ", to=" + to + ", address=" + address
			+ ", passportNo=" + passportNo + ", married=" + married + ", type=" + type + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((address == null) ? 0 : address.hashCode());
	result = prime * result + ((from == null) ? 0 : from.hashCode());
	result = prime * result + id;
	result = prime * result + (married ? 1231 : 1237);
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + passportNo;
	result = prime * result + ((to == null) ? 0 : to.hashCode());
	result = prime * result + ((type == null) ? 0 : type.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	CustomerDTO other = (CustomerDTO) obj;
	if (address == null) {
		if (other.address != null)
			return false;
	} else if (!address.equals(other.address))
		return false;
	if (from == null) {
		if (other.from != null)
			return false;
	} else if (!from.equals(other.from))
		return false;
	if (id != other.id)
		return false;
	if (married != other.married)
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (passportNo != other.passportNo)
		return false;
	if (to == null) {
		if (other.to != null)
			return false;
	} else if (!to.equals(other.to))
		return false;
	if (type != other.type)
		return false;
	return true;
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
public String getFrom() {
	return from;
}
public void setFrom(String from) {
	this.from = from;
}
public String getTo() {
	return to;
}
public void setTo(String to) {
	this.to = to;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public int getPassportNo() {
	return passportNo;
}
public void setPassportNo(int passportNo) {
	this.passportNo = passportNo;
}
public boolean isMarried() {
	return married;
}
public void setMarried(boolean married) {
	this.married = married;
}
public Education getType() {
	return type;
}
public void setType(Education type) {
	this.type = type;
}

}
