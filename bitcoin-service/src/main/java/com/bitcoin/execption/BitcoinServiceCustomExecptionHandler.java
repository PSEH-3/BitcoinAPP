package com.bitcoin.execption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.bitcoin.model.BitcoinServiceExecptionResponse;
import com.bitcoin.util.CommonConstants;

@RestControllerAdvice
public class BitcoinServiceCustomExecptionHandler {
	
	@ResponseStatus
	@ExceptionHandler
	public ResponseEntity<BitcoinServiceExecptionResponse> handleExecption(BitcoinServiceCustomExecption ex) {
		BitcoinServiceExecptionResponse bitcoinServiceExecptionResp =  new BitcoinServiceExecptionResponse();
		bitcoinServiceExecptionResp.setCode(CommonConstants.CODE);
		bitcoinServiceExecptionResp.setMessage(ex.getMessage());		
		return new ResponseEntity<BitcoinServiceExecptionResponse>(bitcoinServiceExecptionResp, HttpStatus.SERVICE_UNAVAILABLE);
	}
}
