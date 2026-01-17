package com.pyramix.kafka.consumer.config.jackson;

import lombok.extern.slf4j.Slf4j;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;

@Slf4j
public class BooleanTypeDeserializer extends tools.jackson.databind.ValueDeserializer<Boolean> {

	@Override
	public Boolean deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws JacksonException {
		final String booleanValue = jsonParser.getString();
		log.info("JsonParser Reads: {}", jsonParser.getString());
		return booleanValue.equals("T") ? true : false;
	}
}
