package com.cm.cryo.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CryoBaseDTO  implements Serializable{
private int id;
private String name;
private int orderBy;
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
public int getOrderBy() {
	return orderBy;
}
public void setOrderBy(int orderBy) {
	this.orderBy = orderBy;
}

}
