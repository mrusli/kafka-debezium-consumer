package com.pyramix;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LongToLocalDateExample {

	public static void main(String[] args) {
		log.info("Hello World!!!");
		
		String epochMillisStr = "1768547389000";
		long epochMillis = Long.parseLong(epochMillisStr);
		
		LocalDate localDateDefaultZone = Instant.ofEpochMilli(epochMillis)
				.atZone(ZoneId.systemDefault())
				.toLocalDate();
		log.info("LocalDate: {}", localDateDefaultZone);
	}

}
