package com.learn.spl.jacksontest.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author created by zzz at 2019/12/3 16:04
 */

public class ObjectMapperTest {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws JsonProcessingException {
        String a = "hello";

        byte[] b = a.getBytes();

        System.out.println(objectMapper.writeValueAsString(a));

        System.out.println(objectMapper.writeValueAsString(b));
    }
}
