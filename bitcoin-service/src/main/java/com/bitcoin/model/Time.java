package com.bitcoin.model;

public class Time {
	private String updated;
	private String updatedISO;
	
	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

	public String getUpdatedISO() {
		return updatedISO;
	}

	public void setUpdatedISO(String updatedISO) {
		this.updatedISO = updatedISO;
	}

	@Override
	public String toString() {
		return "Time [updated=" + updated + ", updatedISO=" + updatedISO + "]";
	}
	
}
