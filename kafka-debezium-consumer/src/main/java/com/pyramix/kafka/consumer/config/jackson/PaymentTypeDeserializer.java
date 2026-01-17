package com.pyramix.kafka.consumer.config.jackson;

import com.pyramix.kafka.consumer.dto.PaymentType;

import lombok.extern.slf4j.Slf4j;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;

@Slf4j
public class PaymentTypeDeserializer extends tools.jackson.databind.ValueDeserializer<PaymentType> {
	
	@Override
	public PaymentType deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws JacksonException {
		return PaymentType.fromValue(jsonParser.getValueAsInt());
	}
}
