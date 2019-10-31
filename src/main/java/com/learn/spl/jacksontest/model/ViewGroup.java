package com.learn.spl.jacksontest.model;

import java.util.List;

/**
 * @author created by zzz at 2019/10/31 11:32
 */

public interface ViewGroup {

    List<View> getChildren();

    void setChildren(List<View> children);

    void addChild(View view);
}
