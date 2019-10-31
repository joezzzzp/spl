package com.learn.spl.jacksontest.nocode;

import com.learn.spl.jacksontest.model.BaseViewGroup;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author created by zzz at 2019/10/30 21:53
 */

public class NoCodeViewGroup extends BaseViewGroup {

    private Map<String, String> customProperties;

    public NoCodeViewGroup() {
        Map<String, String> randomCustomProperties = new HashMap<>();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            randomCustomProperties.put("customKey" + random.nextInt(1000), "customValue" + random.nextInt(1000));
            setCustomProperties(randomCustomProperties);
        }
    }

    @Override
    public String getViewType() {
        return "noCodeViewGroup";
    }

    public Map<String, String> getCustomProperties() {
        return customProperties;
    }

    public void setCustomProperties(Map<String, String> customProperties) {
        this.customProperties = customProperties;
    }
}
