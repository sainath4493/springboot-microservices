package com.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.currencyexchangeservice.bean.ExchangeValue;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {

	public ExchangeValue findByFromAndTo(String from, String to);
}
