package com.learn.spl.jacksontest.concrte.single;

/**
 * @author created by zzz at 2019/10/31 11:47
 */

public class ButtonView extends TextView {

    private int backgroundColor = 161616;

    @Override
    public String getViewType() {
        return "buttonView";
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
}
