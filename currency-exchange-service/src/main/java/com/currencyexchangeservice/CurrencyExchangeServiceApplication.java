package com.currencyexchangeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableDiscoveryClient
public class CurrencyExchangeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeServiceApplication.class, args);
	}

	// for spring cloud sleuth zipkin distributed tracing
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}
