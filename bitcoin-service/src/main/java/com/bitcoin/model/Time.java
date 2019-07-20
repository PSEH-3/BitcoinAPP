package com.bitcoin.model;

import java.util.Date;

public class Time {
	private Date updated;
	private Date updatedISO;
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public Date getUpdatedISO() {
		return updatedISO;
	}
	public void setUpdatedISO(Date updatedISO) {
		this.updatedISO = updatedISO;
	}
	@Override
	public String toString() {
		return "Time [updated=" + updated + ", updatedISO=" + updatedISO + "]";
	}
	
}
