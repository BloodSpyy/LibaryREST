package com.bloodspy.spring.libary.returnMessage;

import org.springframework.stereotype.Component;

@Component
public class ContainerReturnMessage {
    private String info;

    public ContainerReturnMessage() {
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}