package com.shawn.entity;

import java.util.Date;

public class Location {

	private int id;
	private double longitude;
	private double latitude;
	private double speed;
	private double direction;
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
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public double getDirection() {
		return direction;
	}
	public void setDirection(double direction) {
		this.direction = direction;
	}
	@Override
	public String toString() {
		return "Location [id=" + id + ", longitude=" + longitude
				+ ", latitude=" + latitude + ", speed=" + speed
				+ ", direction=" + direction + ", date=" + date + "]";
	}
}
