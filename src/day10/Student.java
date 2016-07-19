package day10;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable{
	Student(int id, String name, char gender, String addr){
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.addr = addr;
		this.date = new Date();
	}
	
	private int id;
	private String name;
	private char gender;
	private String addr;
	private Date date;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
}
