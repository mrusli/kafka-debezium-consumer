package com.pyramix.kafka.consumer.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pyramix.kafka.consumer.config.jackson.MillisToLocalDateDeserializer;
import com.pyramix.kafka.consumer.config.jackson.MillisToLocalDateTimeDeserializer;

import lombok.Data;
import tools.jackson.databind.annotation.JsonDeserialize;

@Data
public class Dto_Auth_User_Role {

	private Long id;
	
	@JsonDeserialize(using = MillisToLocalDateDeserializer.class)
	@JsonFormat
	private LocalDate createdDate;
	
	@JsonDeserialize(using = MillisToLocalDateTimeDeserializer.class)
	@JsonFormat
	private LocalDateTime lastModifiedDate;
	
	private int version;
	
	private String user_role;
	
}
