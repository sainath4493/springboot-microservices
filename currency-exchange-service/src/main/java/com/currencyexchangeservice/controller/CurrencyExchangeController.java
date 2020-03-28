package com.currencyexchangeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.currencyexchangeservice.bean.ExchangeValue;
import com.currencyexchangeservice.repository.ExchangeValueRepository;

@RestController
public class CurrencyExchangeController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private Environment environment;

	@Autowired
	private ExchangeValueRepository repository;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retriveExchangeValue(@PathVariable String from, @PathVariable String to) {

		/*
		 * for static
		 * 
		 * ExchangeValue exchangeValue = new ExchangeValue(1000L, from, to,
		 * BigDecimal.valueOf(65));
		 * exchangeValue.setPort(Integer.valueOf(environment.getProperty(
		 * "local.server.port")));
		 */

		ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);

		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));

		logger.info("{}", exchangeValue);

		return exchangeValue;
	}
}
