package com.bitcoin.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;
import com.bitcoin.model.BitcoinHistoryResponse;
import com.bitcoin.model.BitcoinServiceResponse;

public class CommonUtil {

	public static String formateDate(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(CommonConstants.BITCOIN_SERVICE_DATE_FORMATE);
		return simpleDateFormat.format(date);
	}

	public static Date convertStringToDate(String strDate) throws Exception {
		DateFormat formatter = new SimpleDateFormat(CommonConstants.BITCOIN_DATE_FORMATE);
		return (Date) formatter.parse(strDate);
	}

	public static BitcoinServiceResponse processResponse(BitcoinHistoryResponse bitcoinHistoryResp, Date startDate,
			Date endDate) {
		BitcoinServiceResponse bitcoinServiceResp = new BitcoinServiceResponse();
		@SuppressWarnings("deprecation")
		Map<Date, Double> result = bitcoinHistoryResp.getBhi().getBitcoinData().entrySet().stream().filter(
				map -> map.getKey().getDate() >= startDate.getDate() || map.getKey().getDate() <= endDate.getDate())
				.collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
		Double maxPriceValue=0.0;
		Date key = null;
		for (Map.Entry<Date, Double> entry : result.entrySet()) {
			if(maxPriceValue<entry.getValue()) {
				maxPriceValue = entry.getValue();
				key = entry.getKey();
			}
		}
		bitcoinServiceResp.setHistoricDate(CommonUtil.formateDate(key));
		bitcoinServiceResp.setPrice(maxPriceValue.toString()+CommonConstants.HIGHEST);
		bitcoinServiceResp.setCurrency(CommonConstants.CURRENCY);
		return bitcoinServiceResp;
	}
}
