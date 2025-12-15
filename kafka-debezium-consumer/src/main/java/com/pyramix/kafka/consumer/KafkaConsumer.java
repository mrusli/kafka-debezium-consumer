package com.pyramix.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.pyramix.kafka.consumer.dto.DebeziumEventDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class KafkaConsumer {
	
	public KafkaConsumer() {
		super();
		log.info("Kafka Consumer created");
	}

	@KafkaListener(topics = {"mysql-topic.e050_pyramix_schema.customer"})
	public void listen(DebeziumEventDto dto) {
		log.info(dto.toString());
		log.info("Database Schema:	{}", dto.getPayload().getSource().getDb());
		log.info("Database Table:	{}", dto.getPayload().getSource().getTable());
		log.info("Operation Type:	{}", dto.getPayload().getOperationType().toString());
		// log.info("Result: {}", );
		// log.info(dto.getPayload().getAfter().get("id").toString());
		
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("id", dto.getPayload().getAfter().get("id").toString());
		// jsonObject.addProperty("createdDate", dto.getPayload().getAfter().get("createdDate"));
		// jsonObject.addProperty("lastModifiedDate", dto.getPayload().getAfter().get("lastModifiedDate").toString());
		jsonObject.addProperty("version", dto.getPayload().getAfter().get("version").toString());
		jsonObject.addProperty("active", dto.getPayload().getAfter().get("active").toString());
		
        Gson gson = new Gson();
        String jsonString = gson.toJson(jsonObject);
        log.info(jsonString);
        
        Gson prettyGson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        // Convert the Java object to a pretty-printed JSON string
        String prettyJson = prettyGson.toJson(jsonObject);
        log.info("\r"+prettyJson);
	}
	
}
