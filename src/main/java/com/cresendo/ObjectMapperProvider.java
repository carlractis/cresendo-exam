package com.cresendo;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ObjectMapperProvider {

	public <T> T convertJsonToObject(HttpEntity entity, Class<T> className)
			throws JsonParseException, JsonMappingException, UnsupportedOperationException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
		return mapper.readValue(entity.getContent(), className);
	}
}
