package com.nikhil.uni.dataproducer.model;

public class Sensor {
	private String id;
	private String ts;
	private String val;
	
	public Sensor(String id, String ts, String val) {
		super();
		this.id = id;
		this.ts = ts;
		this.val = val;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

}
