package com.learn.spl.jacksontest.model;

import java.util.HashMap;

/**
 * @author created by zzz at 2019/10/30 21:25
 */

public class UIObjectMapping extends HashMap<String, Class<? extends UIObject>> {

    public UIObjectMapping() {
        put("component", UIComponent.class);
        put("panel", UIPanel.class);
        put("noCodeModel", UINoCodeModel.class);
        put("noCodeModelContainer", UINoCodeModelContainer.class);
    }
}
