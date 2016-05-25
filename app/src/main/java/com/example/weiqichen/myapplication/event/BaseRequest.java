package com.example.weiqichen.myapplication.event;

/**
 * Created by lance on 5/25/16.
 */
public class BaseRequest {
    public Integer eventId;
    public String id;

    public BaseRequest(Integer eventId, String id) {
        this.eventId = eventId;
        this.id = id;
    }
}