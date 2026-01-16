package com.pyramix.kafka.consumer.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pyramix.kafka.consumer.config.jackson.BooleanTypeDeserializer;
import com.pyramix.kafka.consumer.config.jackson.IsoStringToLocalDateDeserializer;
import com.pyramix.kafka.consumer.config.jackson.PaymentTypeDeserializer;

import lombok.Data;
import tools.jackson.databind.annotation.JsonDeserialize;

@Data
public class Dto_Customer_Order_Tmp {

	private Long id;
	
	private int version;
	
	@JsonDeserialize(using = IsoStringToLocalDateDeserializer .class)
	@JsonFormat
	private LocalDate order_date;
	
	@JsonDeserialize(using = PaymentTypeDeserializer.class)
	@JsonFormat
	private PaymentType payment_type;
		
	private int jumlah_hari;
	
	@JsonDeserialize(using = BooleanTypeDeserializer.class)
	@JsonFormat
	private boolean use_ppn;
	
	private Double total_order;
	
	private Double total_ppn;
	
	@JsonDeserialize(using = BooleanTypeDeserializer.class)
	@JsonFormat
	private boolean payment_complete;
	
	private Double amount_paid;
	
	private String note;
}
