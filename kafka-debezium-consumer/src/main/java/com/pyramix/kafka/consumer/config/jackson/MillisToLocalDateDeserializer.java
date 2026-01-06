package com.pyramix.kafka.consumer.config.jackson;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;

import lombok.extern.slf4j.Slf4j;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;

@Slf4j
public class MillisToLocalDateDeserializer extends tools.jackson.databind.ValueDeserializer<LocalDate> {

	@Override
	public LocalDate deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws JacksonException {
		final long timestamp = jsonParser.getLongValue();
		log.info("JsonParser Reads: {}", jsonParser.getLongValue());
		return LocalDate.ofInstant(Instant.ofEpochMilli(timestamp), ZoneOffset.ofHours(+7));
	}

}
