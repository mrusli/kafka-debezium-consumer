package com.pyramix.kafka.consumer.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pyramix.kafka.consumer.config.jackson.IsoStringToLocalDateTimeDeserializer;

import lombok.Data;
import tools.jackson.databind.annotation.JsonDeserialize;

@Data
public class Dto_Auth_User_Role {

	private Long id;
	
	@JsonDeserialize(using = IsoStringToLocalDateTimeDeserializer.class)
	@JsonFormat
	private LocalDateTime createdDate;
	
	@JsonDeserialize(using =IsoStringToLocalDateTimeDeserializer.class)
	@JsonFormat
	private LocalDateTime lastModifiedDate;
	
	private int version;
	
	private String user_role;
	
}
