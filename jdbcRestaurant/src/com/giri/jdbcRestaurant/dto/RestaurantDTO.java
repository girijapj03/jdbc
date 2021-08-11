package com.giri.jdbcRestaurant.dto;

import java.io.Serializable;

import com.giri.jdbcRestaurant.ENUMCONstant.*;

public class RestaurantDTO implements Serializable{
private String name;
private String location;
private String special;
private TypeEnum type;
private boolean best;
public RestaurantDTO() {}
public RestaurantDTO(String name, String location, String special, TypeEnum type, boolean best) {
	super();
	this.name = name;
	this.location = location;
	this.special = special;
	this.type = type;
	this.best = best;
}
@Override
public String toString() {
	return "RestaurantDTO [name=" + name + ", location=" + location + ", special=" + special + ", type=" + type
			+ ", best=" + best + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (best ? 1231 : 1237);
	result = prime * result + ((location == null) ? 0 : location.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + ((special == null) ? 0 : special.hashCode());
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
	RestaurantDTO other = (RestaurantDTO) obj;
	if (best != other.best)
		return false;
	if (location == null) {
		if (other.location != null)
			return false;
	} else if (!location.equals(other.location))
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (special == null) {
		if (other.special != null)
			return false;
	} else if (!special.equals(other.special))
		return false;
	if (type != other.type)
		return false;
	return true;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getSpecial() {
	return special;
}
public void setSpecial(String special) {
	this.special = special;
}
public TypeEnum getType() {
	return type;
}
public void setType(TypeEnum type) {
	this.type = type;
}
public boolean isBest() {
	return best;
}
public void setBest(boolean best) {
	this.best = best;
}

}
