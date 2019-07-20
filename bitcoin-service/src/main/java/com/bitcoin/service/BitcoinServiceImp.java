package com.bitcoin.service;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bitcoin.client.BitcoinHistoryClient;
import com.bitcoin.model.BitcoinHistoryResponse;
import com.bitcoin.model.BitcoinServiceResponse;
import com.bitcoin.util.CommonUtil;

@Service
public class BitcoinServiceImp implements BitcoinService{
	
	@Autowired
	BitcoinHistoryClient bitcoinHistoryClient;

	@Override
	public BitcoinServiceResponse getBitcoinHistoryData(String startDate, String endDate, String currency) throws Exception {
		BitcoinHistoryResponse bitcoinHistoryResp= bitcoinHistoryClient.getBitcoinHistoryData();
				
		Date bitcoinStartDate = CommonUtil.convertStringToDate(startDate);
		Date bitcoinEndDate = CommonUtil.convertStringToDate(endDate);
		
		//process the response
		return CommonUtil.processResponse(bitcoinHistoryResp, bitcoinStartDate, bitcoinEndDate);		 
	}
}
