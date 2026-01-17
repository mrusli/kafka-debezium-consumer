package com.pyramix.kafka.consumer;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import com.pyramix.kafka.consumer.dto.DebeziumEventDto;
import com.pyramix.kafka.consumer.dto.Dto_Auth_User_Role;
import com.pyramix.kafka.consumer.dto.Dto_Customer_Order_Tmp;

import lombok.extern.slf4j.Slf4j;
import tools.jackson.databind.ObjectMapper;

@Slf4j
@Component
public class KafkaConsumer {
	
	private final SimpMessagingTemplate simpMessagingTemplate;
	private ObjectMapper objectMapper = new ObjectMapper();
	
	public KafkaConsumer(SimpMessagingTemplate simpMessagingTemplate) {
		super();
		this.simpMessagingTemplate = simpMessagingTemplate;
		log.info("Kafka Consumer created");
	}

	@KafkaListener(topics = {"mysql-topic.e050_pyramix_schema.auth_user_role"})
	public void listen_01(DebeziumEventDto dto) {
        log.info(dto.toString());
        log.info("Database Schema:  {}", dto.getPayload().getSource().getDb());
        log.info("Database Table:   {}", dto.getPayload().getSource().getTable());
        log.info("Operation Type:   {}", dto.getPayload().getOperationType().toString());
	    
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
	public void listen_02(DebeziumEventDto dto) {
        log.info(dto.toString());
        log.info("Database Schema:  {}", dto.getPayload().getSource().getDb());
        log.info("Database Table:   {}", dto.getPayload().getSource().getTable());
        log.info("Operation Type:   {}", dto.getPayload().getOperationType().toString());

        try {
			if (dto.getPayload().getAfter() != null) {
				Dto_Customer_Order_Tmp customerOrder = 
						objectMapper.convertValue(dto.getPayload().getAfter(), 
								Dto_Customer_Order_Tmp.class);
				log.info(customerOrder.toString());
				
				Locale locale = new Locale.Builder()
						.setLanguage("id")
						.setRegion("ID")
						.build();
				DecimalFormat decimalFormatInstance = 
						(DecimalFormat) NumberFormat.getNumberInstance(locale);
				decimalFormatInstance.applyLocalizedPattern("###.###.###,00");
				log.info(
					decimalFormatInstance.format(customerOrder.getTotal_order()));
				log.info(
					decimalFormatInstance.format(customerOrder.getTotal_ppn()));
				log.info(
					decimalFormatInstance.format(customerOrder.getAmount_paid()));
				
				Double beforePpn = customerOrder.getTotal_order() - customerOrder.getTotal_ppn();

				log.info(
						decimalFormatInstance.format(beforePpn));

				String asJson =
						objectMapper.writeValueAsString(customerOrder);
				log.info(asJson);
			}
        	
		} catch (Exception e) {
			log.error(e.getMessage());
		}
        
	}
	
}
