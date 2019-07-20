package com.bitcoin.model;

public class BitcoinServiceResponse {
	private String historicDate;
	private String price;
	private String currency;

	
	public String getHistoricDate() {
		return historicDate;
	}
	public void setHistoricDate(String historicDate) {
		this.historicDate = historicDate;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	@Override
	public String toString() {
		return "BitcoinServiceResponse [historicDate=" + historicDate + ", price=" + price + ", currency=" + currency
				+ "]";
	}
}
