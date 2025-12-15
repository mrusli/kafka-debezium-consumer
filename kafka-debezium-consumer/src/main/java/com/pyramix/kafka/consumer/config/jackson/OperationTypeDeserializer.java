package com.pyramix.kafka.consumer.config.jackson;

import com.pyramix.kafka.consumer.dto.DebeziumEventDto;
import com.pyramix.kafka.consumer.dto.DebeziumEventDto.OperationType;

import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;

public class OperationTypeDeserializer extends tools.jackson.databind.ValueDeserializer<DebeziumEventDto.OperationType> {

	@Override
	public OperationType deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws JacksonException {
		return DebeziumEventDto.OperationType.fromCode(jsonParser.getValueAsString());
	}
	
}
