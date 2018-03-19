package me.hitit.api.utils.res;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectJsonMapper {
    private static final ObjectMapper om = new ObjectMapper();

    public static String process(Object object) throws JsonProcessingException {
        return om.writeValueAsString(object);
    }
}
