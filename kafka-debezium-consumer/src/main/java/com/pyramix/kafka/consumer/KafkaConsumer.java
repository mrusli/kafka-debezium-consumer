package com.pyramix.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import com.pyramix.kafka.consumer.dto.DebeziumEventDto;
import com.pyramix.kafka.consumer.dto.Dto_Auth_User_Role;

import lombok.extern.slf4j.Slf4j;
import tools.jackson.databind.ObjectMapper;

@Slf4j
@Component
public class KafkaConsumer {
	
	private final SimpMessagingTemplate simpMessagingTemplate;
	
	public KafkaConsumer(SimpMessagingTemplate simpMessagingTemplate) {
		super();
		this.simpMessagingTemplate = simpMessagingTemplate;
		log.info("Kafka Consumer created");
	}

	@KafkaListener(topics = {"mysql-topic.e050_pyramix_schema.auth_user_role"})
	public void listen(DebeziumEventDto dto) {
        log.info(dto.toString());
	    // log.info("Database Schema:  {}", dto.getPayload().getSource().getDb());
	    // log.info("Database Table:   {}", dto.getPayload().getSource().getTable());
	    // log.info("Operation Type:   {}", dto.getPayload().getOperationType().toString());
	    // log.info("Result: {}", );
	    ObjectMapper objectMapper = new ObjectMapper();
	    try {
			if (dto.getPayload().getAfter() != null) {
				Dto_Auth_User_Role userRole = objectMapper.convertValue(dto.getPayload().getAfter(), Dto_Auth_User_Role.class);
				log.info(userRole.toString());
				
				String asJson = objectMapper.writeValueAsString(userRole);
				log.info(asJson);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	@KafkaListener(topics = {"mysql-topic.e050_pyramix_schema.customer_order_tmp"})
	public void listen_01(String message) {
		log.info("Message Received: {}", message);
	}
	
}
