package com.example.weiqichen.myapplication.handler;

import com.example.weiqichen.myapplication.Client;
import com.example.weiqichen.myapplication.event.JoinRoomRequest;
import com.google.gson.Gson;

/**
 * Created by lance on 5/25/16.
 */
public class JoinRoom {
    public static void exec(String room_id) {
        JoinRoomRequest request = new JoinRoomRequest(14, Client.id, room_id);
        Gson gson = new Gson();
        String data = gson.toJson(request);
        Client.write(data);
    }
}
