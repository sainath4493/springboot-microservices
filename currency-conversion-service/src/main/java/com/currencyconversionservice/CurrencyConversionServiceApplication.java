package com.currencyconversionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableFeignClients("com.currencyconversionservice")
@EnableDiscoveryClient // to register with naming server
public class CurrencyConversionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionServiceApplication.class, args);
	}

	// for spring cloud sleuth zipkin distributed tracing
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}
