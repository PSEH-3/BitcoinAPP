package com.bitcoin.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.bitcoin.model.BitcoinHistoryResponse;

@Component
public class BitcoinHistoryClientImpl implements BitcoinHistoryClient{
	
	@Autowired
	RestTemplate restTemplate;

	@Override
	public BitcoinHistoryResponse getBitcoinHistoryData() {
		
		final String uri = "https://api.coindesk.com/v1/bpi/historical/close.json";
	     	    
		BitcoinHistoryResponse bitcoinHistoryResp = restTemplate.getForObject(uri, BitcoinHistoryResponse.class);	     
	    System.out.println("bitcoinHistoryResp: "+bitcoinHistoryResp);	    
	    return bitcoinHistoryResp;
	}
	
}
