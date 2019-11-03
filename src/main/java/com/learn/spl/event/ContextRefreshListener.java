package com.learn.spl.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ContextRefreshListener implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @EventListener(ContextRefreshedEvent.class)
    public void handleEvent() {
        System.out.println("监听到contextRefreshEvent事件");
        System.out.println("生成自定义事件");
        CustomEvent customEvent = new CustomEvent();
        customEvent.setContent(getClass().getCanonicalName());
        applicationContext.publishEvent(customEvent);
    }

    @EventListener(CustomEvent.class)
    public void handleEvent(CustomEvent customEvent) {
        System.out.println("接收到自定义事件:" + customEvent.getContent());
    }
}
