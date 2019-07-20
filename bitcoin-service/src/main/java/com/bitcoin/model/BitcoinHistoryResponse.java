package com.bitcoin.model;

public class BitcoinHistoryResponse {
	private BitcoinData bhi;	
	private String disclaimer;
	private Time time;
	public BitcoinData getBhi() {
		return bhi;
	}
	public void setBhi(BitcoinData bhi) {
		this.bhi = bhi;
	}
	public String getDisclaimer() {
		return disclaimer;
	}
	public void setDisclaimer(String disclaimer) {
		this.disclaimer = disclaimer;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "BitcoinHistoryResponse [bhi=" + bhi + ", disclaimer=" + disclaimer + ", time=" + time + "]";
	}
	
}
