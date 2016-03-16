package com.linbin.eventbus;

/**
 * Created by linbin_dian91 on 2016/3/16.
 */
public class WhateverEvent {
    private String message;

    public WhateverEvent(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
