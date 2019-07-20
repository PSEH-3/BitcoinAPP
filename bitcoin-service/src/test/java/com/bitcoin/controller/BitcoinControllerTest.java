package com.bitcoin.controller;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;
import com.bitcoin.model.BitcoinServiceResponse;
import com.bitcoin.service.BitcoinService;

@RunWith(SpringRunner.class)
public class BitcoinControllerTest {
	
	@Mock
	BitcoinService bitcoinService;

	@Test
	public void getBitcoinHistoricalDataValidResponse() throws Exception {
		String startDate = "19-06-2019";
		String endDate = "25-06-2019";
		String currency = "INR";
		BitcoinServiceResponse bitcoinServiceResponse = prepareMockResponse();
		Mockito.when(bitcoinService.getBitcoinHistoryData(startDate, endDate, currency)).thenReturn(bitcoinServiceResponse);
		assertNotNull(bitcoinServiceResponse);
		
	}
	
	@Test
	public void getBitcoinHistoricalDataThrowsExecption() throws Exception {
		String startDate = "19-06-2019";
		String endDate = "25-06-2019";
		String currency = "INR";
		Mockito.when(bitcoinService.getBitcoinHistoryData(startDate, endDate, currency)).thenThrow(new Exception());		
	}
	
	public BitcoinServiceResponse prepareMockResponse() {
		BitcoinServiceResponse bitcoinServiceResp = new BitcoinServiceResponse();
		bitcoinServiceResp.setHistoricDate("23-06-2019");
		bitcoinServiceResp.setPrice("10860.8233 (highest)");
		bitcoinServiceResp.setCurrency("INR");
		return bitcoinServiceResp;
	}
}
