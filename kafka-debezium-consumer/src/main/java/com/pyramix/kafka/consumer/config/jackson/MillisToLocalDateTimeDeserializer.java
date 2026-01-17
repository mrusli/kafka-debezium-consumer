package com.pyramix.kafka.consumer.config.jackson;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import lombok.extern.slf4j.Slf4j;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;

@Slf4j
public class MillisToLocalDateTimeDeserializer extends tools.jackson.databind.ValueDeserializer<LocalDateTime> {

	@Override
	public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws JacksonException {
		final String timestampStr = jsonParser.getString();
		log.info("DateTime as String: {}", timestampStr);
		final long timestamp = Long.parseLong(timestampStr);
		log.info("DateTime as Long: {}", timestamp);
		return Instant.ofEpochMilli(timestamp)
				.atZone(ZoneId.of("Asia/Jakarta"))
				.toLocalDateTime();
		
		// log.info("DateTimeDeserializer - JsonParser Reads: {}", jsonParser.getLongValue());
		// log.info("System ZoneId: {}", ZoneId.systemDefault());
		//return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneOffset.ofHours(+7));
	}

}
