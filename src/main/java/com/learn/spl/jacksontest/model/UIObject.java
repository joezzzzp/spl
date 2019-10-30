package com.learn.spl.jacksontest.model;

import java.util.List;

/**
 * @author created by zzz at 2019/10/30 20:48
 */

public interface UIObject {

    default String getRealType() {
        return "none";
    }

    default void setRealType(String realType) { }

    default boolean isContainer() {
        return false;
    }

    int getWidth();

    void setWidth(int width);

    int getHeight();

    void setHeight(int height);

    List<UIObject> getChildren();

    void setChildren(List<UIObject> children);

    void addChildren(UIObject uiObject);
}
