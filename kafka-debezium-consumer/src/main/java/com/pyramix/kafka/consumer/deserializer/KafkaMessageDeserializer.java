package com.pyramix.kafka.consumer.deserializer;

import org.springframework.kafka.support.serializer.JacksonJsonDeserializer;

import com.pyramix.kafka.consumer.dto.DebeziumEventDto;

public class KafkaMessageDeserializer extends JacksonJsonDeserializer<DebeziumEventDto> {

	public KafkaMessageDeserializer() {
		super();	
	}

}
