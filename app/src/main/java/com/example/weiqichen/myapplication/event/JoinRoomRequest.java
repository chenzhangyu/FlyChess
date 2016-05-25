package com.example.weiqichen.myapplication.event;

/**
 * Created by lance on 5/25/16.
 */
public class JoinRoomRequest extends BaseRequest{
    public String room_id;

    public JoinRoomRequest (Integer eventId, String id, String room_id) {
        super(eventId, id);
        this.room_id = room_id;
    }
}
