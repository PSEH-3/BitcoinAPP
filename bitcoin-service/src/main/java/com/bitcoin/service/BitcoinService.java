package com.bitcoin.service;

import com.bitcoin.model.BitcoinServiceResponse;

public interface BitcoinService {

	BitcoinServiceResponse getBitcoinHistoryData(String startDate, String endDate, String currency) throws Exception;
}
