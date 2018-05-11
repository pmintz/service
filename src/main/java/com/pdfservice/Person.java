package com.pdfservice;

import org.springframework.web.bind.annotation.RequestMapping;


public class Person {
	
	String name;
	int age;
	String car;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCar() {
		return car;
	}
	public void setCar(String car) {
		this.car = car;
	}

}
