package com.pyramix.kafka.consumer.dto;

import lombok.Getter;

@Getter
public enum PaymentType {
	Transfer(0),
	Giro(1),
	Tunai(2);
	
	private final int value;

	PaymentType(int value) {
		this.value = value;
	}
	
	public static PaymentType fromValue(int value) {
		for (PaymentType type : PaymentType.values()) {
			if (type.getValue()==value) {
				return type;
			}
		}
		throw new IllegalArgumentException("Unknow payment type value: " + value);
	}
}
