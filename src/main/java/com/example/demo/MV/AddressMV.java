package com.example.demo.MV;

public class AddressMV {

	private int locationPin;
	private String localAddress;
	private String landMark;

	public int getLocationPin() {
		return locationPin;
	}

	public void setLocationPin(int locationPin) {
		this.locationPin = locationPin;
	}

	public String getLocalAddress() {
		return localAddress;
	}

	public void setLocalAddress(String localAddress) {
		this.localAddress = localAddress;
	}

	public String getLandMark() {
		return landMark;
	}

	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}

	@Override
	public String toString() {
		return "Address [locationPin=" + locationPin + ", localAddress=" + localAddress + ", landMark=" + landMark
				+ "]";
	}

	public AddressMV(int locationPin, String localAddress, String landMark) {
		super();
		this.locationPin = locationPin;
		this.localAddress = localAddress;
		this.landMark = landMark;
	}

	public AddressMV() {
		super();
	}

}
