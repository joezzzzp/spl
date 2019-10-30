package com.learn.spl.jacksontest;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.learn.spl.jacksontest.model.UIObject;

import java.io.IOException;

/**
 * @author created by zzz at 2019/10/30 21:58
 */

public class UIObjectSerializer extends JsonSerializer<UIObject> {
    @Override
    public void serialize(UIObject value, JsonGenerator gen, SerializerProvider serializers) throws IOException {

    }
}
