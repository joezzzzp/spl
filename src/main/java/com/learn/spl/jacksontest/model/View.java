package com.learn.spl.jacksontest.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author created by zzz at 2019/10/30 20:48
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"viewType", "width", "height"})
public interface View {

    String getViewType();

    default void setViewType(String viewType) { }

    int getWidth();

    void setWidth(int width);

    int getHeight();

    void setHeight(int height);

}
