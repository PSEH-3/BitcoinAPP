package com.bitcoin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bitcoin.model.BitcoinServiceResponse;
import com.bitcoin.service.BitcoinService;

@RestController("/api/bitcoin-service")
public class BitcoinController {

	@Autowired
	BitcoinService bitcoinService;

	@GetMapping("/fetchBitcoinData")
	public ResponseEntity<?> getBitcoinHistoricalData(@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate, @RequestParam("currentcy") String currency) throws Exception {
		BitcoinServiceResponse bitcoinServiceResp = bitcoinService.getBitcoinHistoryData(startDate, endDate, currency);
		System.out.println("bitcoinServiceResp: " + bitcoinServiceResp);
		return new ResponseEntity<BitcoinServiceResponse>(bitcoinServiceResp, HttpStatus.OK);
	}
}