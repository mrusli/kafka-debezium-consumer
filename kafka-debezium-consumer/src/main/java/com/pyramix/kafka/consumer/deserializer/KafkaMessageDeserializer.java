package com.pyramix.kafka.consumer.deserializer;

import org.apache.kafka.common.header.Headers;
import org.jspecify.annotations.Nullable;
import org.springframework.kafka.support.serializer.JacksonJsonDeserializer;

import com.pyramix.kafka.consumer.dto.DebeziumEventDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class KafkaMessageDeserializer extends JacksonJsonDeserializer<DebeziumEventDto> {

	public KafkaMessageDeserializer() {
		super();	
	}

	@Override
	public @Nullable DebeziumEventDto deserialize(String topic, Headers headers, byte[] data) {
		// TODO Auto-generated method stub
		return super.deserialize(topic, headers, data);
	}

	@Override
	public @Nullable DebeziumEventDto deserialize(String topic, byte[] data) {
		// TODO Auto-generated method stub
		return super.deserialize(topic, data);
	}

}
