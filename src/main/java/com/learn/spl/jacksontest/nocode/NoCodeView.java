package com.learn.spl.jacksontest.nocode;

import com.learn.spl.jacksontest.model.BaseView;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author created by zzz at 2019/10/30 21:45
 */

public class NoCodeView extends BaseView {

   private Map<String, String> customProperties;

   public NoCodeView() {
       Map<String, String> randomCustomProperties = new HashMap<>();
       Random random = new Random();
       for (int i = 0; i < 5; i++) {
           randomCustomProperties.put("customKey" + random.nextInt(1000), "customValue" + random.nextInt(1000));
           setCustomProperties(randomCustomProperties);
       }
   }

    @Override
    public String getViewType() {
        return "noCodeView";
    }

    public Map<String, String> getCustomProperties() {
        return customProperties;
    }

    public void setCustomProperties(Map<String, String> customProperties) {
        this.customProperties = customProperties;
    }
}
