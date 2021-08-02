package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ListWork {
	@Id
	private int date;
	private int start;
	private int end;
	private String work;
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	@Override
	public String toString() {
		return "ListWork: Date:" +date + ", Start hour:" + start + ", End hour:" + end + ", Work:" + work + "";
	}
}
