package com.bitcoin.service;

import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;
import com.bitcoin.client.BitcoinHistoryClient;
import com.bitcoin.model.BitcoinData;
import com.bitcoin.model.BitcoinHistoryResponse;
import com.bitcoin.model.BitcoinServiceResponse;
import com.bitcoin.model.Time;
import com.bitcoin.util.CommonUtil;

@RunWith(SpringRunner.class)
public class BitcoinServiceTest {

	@Mock
	BitcoinHistoryClient bitcoinHistoryClient;

	@Test
	public void getBitcoinHistoryData() throws Exception {
		String startDate = "19-06-2019";
		String endDate = "25-06-2019";
		Date startDateBH=CommonUtil.convertStringToDate(startDate);
		Date endDateBH=CommonUtil.convertStringToDate(endDate);
		
		BitcoinHistoryResponse bitcoinHistoryResp = prepareBitcoinHistoryResponse();
		BitcoinServiceResponse bitcoinServiceResp = new BitcoinServiceResponse();
		
		Mockito.when(bitcoinHistoryClient.getBitcoinHistoryData()).thenReturn(bitcoinHistoryResp);	
		bitcoinServiceResp = CommonUtil.processResponse(bitcoinHistoryResp, startDateBH,endDateBH);		
		assertNotNull(bitcoinServiceResp);

	}
	
	@Test
	public void getBitcoinHistoryDataThrowsException() {
		Mockito.when(bitcoinHistoryClient.getBitcoinHistoryData()).thenThrow(new Exception());
	}

	public BitcoinHistoryResponse prepareBitcoinHistoryResponse() throws Exception {
		BitcoinHistoryResponse bitcoinHistoryeResp = new BitcoinHistoryResponse();
		Map<Date, Double> bitcoinDataMap = new HashMap<>();
		bitcoinDataMap.put(CommonUtil.convertStringToDate("2019-06-19"), 9288.5367);
		bitcoinDataMap.put(CommonUtil.convertStringToDate("2019-06-20"), 9539.7883);
		bitcoinDataMap.put(CommonUtil.convertStringToDate("2019-06-21"), 9288.5367);
		bitcoinDataMap.put(CommonUtil.convertStringToDate("2019-06-22"), 9288.5367);
		bitcoinDataMap.put(CommonUtil.convertStringToDate("2019-06-23"), 9288.5367);
		BitcoinData bitcoinData = new BitcoinData();
		bitcoinData.setBitcoinData(bitcoinDataMap);

		Time time = new Time();
		time.setUpdated("Jul 20, 2019 00:03:00 UTC");
		time.setUpdatedISO("2019-07-20T00:03:00+00:00");

		bitcoinHistoryeResp.setBhi(bitcoinData);
		bitcoinHistoryeResp.setDisclaimer(
				"This data was produced from the CoinDesk Bitcoin Price Index. BPI value data returned as USD");
		bitcoinHistoryeResp.setTime(time);
		return bitcoinHistoryeResp;
	}
}
