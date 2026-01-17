package com.pyramix.kafka.consumer.config.jackson;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;

@Slf4j
public class IsoStringToLocalDateTimeDeserializer extends tools.jackson.databind.ValueDeserializer<LocalDateTime> {

	@Override
	public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws JacksonException {
		SimpleDateFormat sourceFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		final String timestampStr = jsonParser.getString();
		log.info("DateTime as String: {}", timestampStr);
		Date convertedDatetime = null;
		try {
			convertedDatetime = sourceFormat.parse(timestampStr);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return convertedDatetime.toInstant()
				.atZone(ZoneId.of("Asia/Jakarta"))
				.toLocalDateTime();
	}

}
