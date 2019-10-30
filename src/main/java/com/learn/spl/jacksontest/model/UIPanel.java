package com.learn.spl.jacksontest.model;

/**
 * @author created by zzz at 2019/10/30 21:00
 */

public class UIPanel extends UIComponent{

    @Override
    public String getRealType() {
        return "panel";
    }

    @Override
    public boolean isContainer() {
        return true;
    }
}
