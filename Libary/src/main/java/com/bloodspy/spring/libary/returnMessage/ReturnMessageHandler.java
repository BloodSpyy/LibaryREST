package com.bloodspy.spring.libary.returnMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReturnMessageHandler {
    ContainerReturnMessage containerReturnMessage;

    @Autowired
    public ReturnMessageHandler(ContainerReturnMessage containerReturnMessage) {
        this.containerReturnMessage = containerReturnMessage;
    }

    public ContainerReturnMessage getUpdateMessage(String entityName, int id) {
        containerReturnMessage.setInfo(
                entityName + " with id " + id + " was updated"
        );

        return containerReturnMessage;
    }
    
    public ContainerReturnMessage getAddMessage(String entityName, int id) {
        containerReturnMessage.setInfo(
                entityName + " was added with id " + id
        );

        return containerReturnMessage;
    }

    public ContainerReturnMessage getDeleteMessage(String entityName, int id) {
        containerReturnMessage.setInfo(
                entityName + " with id" + id + " was deleted"
        );

        return containerReturnMessage;
    }
}
