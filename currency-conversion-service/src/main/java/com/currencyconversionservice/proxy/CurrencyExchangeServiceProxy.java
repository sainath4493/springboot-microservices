package com.currencyconversionservice.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.currencyconversionservice.bean.CurrencyConversionBean;

//name - service which are calling
//url -  where to be running
//@FeignClient(name = "currency-exchange-service", url = "localhost:8000")

//@FeignClient(name = "currency-exchange-service") -- to connect directly without zuul

@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

	// @GetMapping("/currency-exchange/from/{from}/to/{to}") -- to connect directly
	// without zuul

	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	// name should be written otherwise will get PathVariable annotation was empty
	// on param 0.
	public CurrencyConversionBean retriveExchangeValue(@PathVariable(name = "from") String from,
			@PathVariable(name = "to") String to);
}
