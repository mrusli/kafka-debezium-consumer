package com.pyramix.kafka.consumer.config.jackson;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;

@Slf4j
public class IsoStringToLocalDateDeserializer extends tools.jackson.databind.ValueDeserializer<LocalDate> {

	@Override
	public LocalDate deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws JacksonException {
		SimpleDateFormat sourceFormat = new SimpleDateFormat("yyyy-MM-dd'Z'");
		final String timestampStr = jsonParser.getString();
		log.info("Date as String: {}", timestampStr);
		Date convertedDate = null;
		try {
			convertedDate = sourceFormat.parse(timestampStr);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return convertedDate.toInstant()
				.atZone(ZoneId.of("Asia/Jakarta"))
				.toLocalDate();
	}
}
