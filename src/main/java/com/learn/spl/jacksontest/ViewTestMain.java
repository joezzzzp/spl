package com.learn.spl.jacksontest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.learn.spl.jacksontest.concrte.group.PageView;
import com.learn.spl.jacksontest.concrte.group.PanelView;
import com.learn.spl.jacksontest.concrte.single.ButtonView;
import com.learn.spl.jacksontest.concrte.single.TextView;
import com.learn.spl.jacksontest.model.*;
import com.learn.spl.jacksontest.nocode.NoCodeView;
import com.learn.spl.jacksontest.nocode.NoCodeViewGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author created by zzz at 2019/10/31 10:08
 */

public class ViewTestMain {

    private static final Logger logger = LoggerFactory.getLogger(ViewTestMain.class);

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule simpleModule = new SimpleModule();
//        simpleModule.addSerializer(new ViewSerializer());
        simpleModule.addDeserializer(View.class, new ViewDeserializer());
        objectMapper.registerModule(simpleModule);

        View panel = buildTestPanel();
        String testString = objectMapper.writeValueAsString(panel);
        logger.info("{}", testString);
        objectMapper.readValue(testString, View.class);
    }

    private static View buildTestPanel() {
        //系统页面
        PageView page = new PageView();

        //系统页面 增加系统及自定义容器及组件
        PanelView panelView1 = new PanelView();
        NoCodeViewGroup noCodeViewGroup1 = new NoCodeViewGroup();
        addChildren(page, panelView1, noCodeViewGroup1, new NoCodeView(), new TextView(), new ButtonView());

        //系统页面->系统容器 增加组件，包括系统容器，自定义容器，自定义组件
        PanelView panelView11 = new PanelView();
        NoCodeViewGroup noCodeViewGroup11 = new NoCodeViewGroup();
        addChildren(panelView1, panelView11, noCodeViewGroup11, new NoCodeView(), new ButtonView());

        //系统页面->系统容器->自定义容器 增加系统组件以及自定义组件
        addChildren(noCodeViewGroup11, new TextView(), new ButtonView(), new PanelView(), new NoCodeView());

        //系统页面->自定义容器 增加组件，包括系统和自定义
        PanelView panelView21 = new PanelView();
        NoCodeViewGroup noCodeViewGroup21 = new NoCodeViewGroup();
        addChildren(noCodeViewGroup1, panelView21, noCodeViewGroup21, new ButtonView());

        //系统页面->自定义容器->自定义容器 增加组件
        addChildren(noCodeViewGroup21, new NoCodeView(), new TextView(), new ButtonView());

        //系统页面->自定义容器->系统容器 增加组件
        addChildren(panelView21, new ButtonView(), new NoCodeView());

        return page;
    }

    private static void addChildren(ViewGroup viewGroup, View... views) {
        for (View view : views) {
            viewGroup.addChild(view);
        }
    }

    private String testString() {
        return "{ \"viewType\": \"pageView\", \"width\": 123, \"height\": 224, \"children\": [ { \"viewType\": \"noCodeViewGroup\", \"width\": 432, \"height\": 43, \"children\": [ { \"viewType\": \"panelView\", \"width\": 12, \"height\": 34, \"children\": [ { \"viewType\": \"noCodeView\", \"width\": 12, \"height\": 78, \"customProperties\": { \"number\": \"3\", \"other\": \"呵呵呵呵\" } } ] }, { \"viewType\": \"buttonView\", \"content\": \"啦啦啦\", \"width\": 45, \"height\": 78 } ] } ] }";
    }
}
