package com.microservices.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.limitsservice.bean.LimitsConfiguration;
import com.microservices.limitsservice.config.Configuration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class LimitsConfigurationController {

	@Autowired
	Configuration configuration;

	@GetMapping("/limits")
	public LimitsConfiguration retriveLimitsConfigurations() {
		return new LimitsConfiguration(configuration.getMaximum(), configuration.getMinimum());
	}

	@GetMapping("/fault-tolerance-example")
	@HystrixCommand(fallbackMethod = "fallbacktRetriveConfiguration")
	public LimitsConfiguration retriveConfiguration() {
		throw new RuntimeException("Not Avaiable");
	}

	// basic behaviour offer if exception occured in retriveConfiuration
	public LimitsConfiguration fallbacktRetriveConfiguration() {
		return new LimitsConfiguration(999, 9);
	}

}
