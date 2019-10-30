package com.learn.spl.jacksontest.model;

import java.util.List;

/**
 * @author created by zzz at 2019/10/30 21:04
 */

public class UIComponent implements UIObject {

    private int width;

    private int height;

    private List<UIObject> children;

    @Override
    public String getRealType() {
        return "component";
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public List<UIObject> getChildren() {
        if (isContainer()) {
            return children;
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public void setChildren(List<UIObject> children) {
        if (isContainer()) {
            this.children = children;
        }
        throw new UnsupportedOperationException();
    }
}
