package com.cg.config;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.cg.entity.AuditLog;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Component
public class RabbitListenerImpl implements RabbitListener {

	
	
	public static Object fromJsonToJava(String json, Class type)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper jsonMapper = new ObjectMapper();
		return jsonMapper.readValue(json, type);
	}
	
	@Override
	public void onMessage(String message) {
		// TODO Auto-generated method stub

		AuditLog value = null;

		try {
			System.out.println("Message Number " + RabbitListenerImpl.fromJsonToJava(message, AuditLog.class) + " received.");
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
