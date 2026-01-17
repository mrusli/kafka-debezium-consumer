package com.pyramix.kafka.consumer.config.jackson;

import lombok.extern.slf4j.Slf4j;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;

@Slf4j
public class DoubleTypeDeserializer extends tools.jackson.databind.ValueDeserializer<Double> {
	
	@Override
	public Double deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws JacksonException {
		final String doubleValue = jsonParser.getString();
		log.info("JsonParser Reads: {}", doubleValue);
		return Double.valueOf(doubleValue);
	}

}
