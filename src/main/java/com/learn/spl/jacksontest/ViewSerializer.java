package com.learn.spl.jacksontest;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.learn.spl.jacksontest.model.View;

import java.io.IOException;

/**
 * @author created by zzz at 2019/10/30 21:58
 */

public class ViewSerializer extends JsonSerializer<View> {

    private ViewClassMapping viewClassMapping = ViewClassMapping.getInstance();

    @Override
    public Class<View> handledType() {
        return View.class;
    }

    @Override
    public void serialize(View value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        Class<? extends View> viewClass = viewClassMapping.get(value.getViewType());
        gen.writeObject(viewClass.cast(value));
    }
}
