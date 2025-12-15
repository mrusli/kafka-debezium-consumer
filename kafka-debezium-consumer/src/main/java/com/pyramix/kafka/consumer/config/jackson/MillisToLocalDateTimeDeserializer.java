package com.pyramix.kafka.consumer.config.jackson;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;

public class MillisToLocalDateTimeDeserializer extends tools.jackson.databind.ValueDeserializer<LocalDateTime> {

	@Override
	public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws JacksonException {
		final long timestamp = jsonParser.getLongValue();
		return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneOffset.ofHours(+7));
	}

}
