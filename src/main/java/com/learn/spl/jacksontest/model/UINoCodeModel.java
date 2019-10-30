package com.learn.spl.jacksontest.model;

import java.util.Properties;

/**
 * @author created by zzz at 2019/10/30 21:45
 */

public class UINoCodeModel extends UIComponent{

    private Properties customProperties;

    @Override
    public String getRealType() {
        return "noCodeModel";
    }

    public Properties getCustomProperties() {
        return customProperties;
    }

    public void setCustomProperties(Properties customProperties) {
        this.customProperties = customProperties;
    }
}
