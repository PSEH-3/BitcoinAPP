package com.bitcoin.model;

import java.util.Date;
import java.util.Map;

public class BitcoinData {
	
	private Map<Date, Double> bitcoinData;

	public Map<Date, Double> getBitcoinData() {
		return bitcoinData;
	}

	public void setBitcoinData(Map<Date, Double> bitcoinData) {
		this.bitcoinData = bitcoinData;
	}

	@Override
	public String toString() {
		return "BitcoinData [bitcoinData=" + bitcoinData + "]";
	}

	
}
