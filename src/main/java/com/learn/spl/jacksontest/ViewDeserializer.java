package com.learn.spl.jacksontest;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.TextNode;
import com.learn.spl.jacksontest.model.View;

import java.io.IOException;

/**
 * @author created by zzz at 2019/10/30 21:59
 */

public class ViewDeserializer extends JsonDeserializer<View> {

    private ViewClassMapping mapping = ViewClassMapping.getInstance();

    @Override
    public View deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ObjectCodec objectCodec = p.getCodec();
        TreeNode node = p.readValueAsTree();
        String realType = ((TextNode) node.get("viewType")).textValue();
        Class<? extends View> realClass = mapping.get(realType);
        return objectCodec.treeToValue(node, realClass);
    }
}
