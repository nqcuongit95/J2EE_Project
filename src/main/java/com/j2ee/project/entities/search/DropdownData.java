package com.j2ee.project.entities.search;

public class DropdownData {
	String name;
	String value;
	String text;
	
	public DropdownData(){		
	}
	
	public DropdownData(String name, String value, String text) {
		
		this.name = name;
		this.value = value;
		this.text = text;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
