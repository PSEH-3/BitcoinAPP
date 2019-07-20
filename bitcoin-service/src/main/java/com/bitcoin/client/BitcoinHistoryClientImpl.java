package com.bitcoin.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.bitcoin.model.BitcoinHistoryResponse;

@Component
public class BitcoinHistoryClientImpl implements BitcoinHistoryClient {

	@Autowired
	RestTemplate restTemplate;

	@Override
	public BitcoinHistoryResponse getBitcoinHistoryData() {
		BitcoinHistoryResponse bitcoinHistoryResp = new BitcoinHistoryResponse();

		try {
			final String uri = "https://api.coindesk.com/v1/bpi/historical/close.json";
			bitcoinHistoryResp = restTemplate.getForObject(uri, BitcoinHistoryResponse.class);
			System.out.println("bitcoinHistoryResp: " + bitcoinHistoryResp);
		} catch (Exception e) {
			System.out.println("Unable to connect to bitcoin history service: " + e.getStackTrace());
		}
		return bitcoinHistoryResp;
	}

}
