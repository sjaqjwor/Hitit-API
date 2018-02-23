package me.hitit.api.utils.res;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JsonFormat.class
 * 
 * @author seungki
 *
 */
public class ObjectJsonMapper {
	public static String process(Object object) throws JsonProcessingException{
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }
}
