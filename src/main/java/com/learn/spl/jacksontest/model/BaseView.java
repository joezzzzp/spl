package com.learn.spl.jacksontest.model;

/**
 * @author created by zzz at 2019/10/30 21:04
 */

public abstract class BaseView implements View {

    private int width;

    private int height;

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
}
