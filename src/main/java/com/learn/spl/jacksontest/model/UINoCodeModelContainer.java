package com.learn.spl.jacksontest.model;

/**
 * @author created by zzz at 2019/10/30 21:53
 */

public class UINoCodeModelContainer extends UINoCodeModel {

    @Override
    public String getRealType() {
        return "noCodeModelContainer";
    }

    @Override
    public boolean isContainer() {
        return true;
    }
}
