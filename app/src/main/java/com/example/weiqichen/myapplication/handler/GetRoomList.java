package com.example.weiqichen.myapplication.handler;

import com.example.weiqichen.myapplication.Client;
import com.example.weiqichen.myapplication.event.BaseRequest;
import com.google.gson.Gson;

/**
 * Created by lance on 5/25/16.
 */
public class GetRoomList {
    public static void exec() {
        BaseRequest request = new BaseRequest(12, Client.id);
        Gson gson = new Gson();
        String data = gson.toJson(request);
        Client.write(data);
    }
}