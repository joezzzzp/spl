package com.learn.spl.jacksontest;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.TextNode;
import com.learn.spl.jacksontest.model.UIObject;
import com.learn.spl.jacksontest.model.UIObjectMapping;

import java.io.IOException;

/**
 * @author created by zzz at 2019/10/30 21:59
 */

public class UIObjectDeserializer extends JsonDeserializer<UIObject> {

    private UIObjectMapping mapping = new UIObjectMapping();

    @Override
    public UIObject deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        TreeNode node = p.readValueAsTree();
        String realType = ((TextNode) node.get("realType")).textValue();
        return null;
    }
}
