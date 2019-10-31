package com.learn.spl.jacksontest.model;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author created by zzz at 2019/10/31 11:40
 */

public abstract class BaseViewGroup extends BaseView implements ViewGroup {

    private List<View> children;

    @Override
    public List<View> getChildren() {
        return children;
    }

    @Override
    public void setChildren(List<View> children) {
        this.children = children;
    }

    @Override
    public void addChild(View view) {
        if (CollectionUtils.isEmpty(children)) {
            this.children = new ArrayList<>();
        }
        this.children.add(view);
    }
}
