package me.hitit.api.utils.res;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JsonFormat.class
 *
 * @author seungki
 */
public class ObjectJsonMapper {
    static ObjectMapper om;
    public static String process(Object object) throws JsonProcessingException {
        om = new ObjectMapper();
        return om.writeValueAsString(object);
    }
}
