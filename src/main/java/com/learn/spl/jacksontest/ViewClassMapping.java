package com.learn.spl.jacksontest;

import com.learn.spl.jacksontest.concrte.group.PageView;
import com.learn.spl.jacksontest.concrte.group.PanelView;
import com.learn.spl.jacksontest.concrte.single.ButtonView;
import com.learn.spl.jacksontest.concrte.single.TextView;
import com.learn.spl.jacksontest.model.*;
import com.learn.spl.jacksontest.nocode.NoCodeView;
import com.learn.spl.jacksontest.nocode.NoCodeViewGroup;

import java.util.HashMap;

/**
 * @author created by zzz at 2019/10/30 21:25
 */

public class ViewClassMapping extends HashMap<String, Class<? extends View>> {

    public static ViewClassMapping getInstance() {
        return UIObjectMappingHolder.instance;
    }

    private ViewClassMapping() {
        put("pageView", PageView.class);
        put("panelView", PanelView.class);
        put("textView", TextView.class);
        put("buttonView", ButtonView.class);
        put("noCodeView", NoCodeView.class);
        put("noCodeViewGroup", NoCodeViewGroup.class);
    }

    private static class UIObjectMappingHolder {
        private static ViewClassMapping instance = new ViewClassMapping();
    }
}
