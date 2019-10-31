package com.learn.spl.jacksontest.concrte.single;

import com.learn.spl.jacksontest.model.BaseView;

/**
 * @author created by zzz at 2019/10/30 21:00
 */

public class TextView extends BaseView {

    private String content = "defaultContent";

    @Override
    public String getViewType() {
        return "textView";
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
