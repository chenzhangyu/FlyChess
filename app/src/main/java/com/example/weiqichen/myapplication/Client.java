package com.example.weiqichen.myapplication;

import java.io.*;
import java.net.Socket;

import com.example.weiqichen.myapplication.event.CreateRoomSuccess;
import com.example.weiqichen.myapplication.event.JoinRoomSuccess;
import com.example.weiqichen.myapplication.event.MsgFailed;
import com.example.weiqichen.myapplication.event.RoomList;
import com.google.gson.Gson;
import com.example.weiqichen.myapplication.event.BaseResponse;
import com.example.weiqichen.myapplication.event.Connection;


/**
 * Created by lance on 5/25/16.
 */
public class Client {
    public static final String IP_ADDR = "127.0.0.1";
    public static final int PORT = 8787;
    public static String id = "";

    private static DataOutputStream out;
    private static DataInputStream in;
    private static BufferedReader reader;

    public static void run() {
        System.out.println("Client start");
        try {
            Socket socket = new Socket(IP_ADDR, PORT);

            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String ret = reader.readLine();
            Gson gson = new Gson();
            Connection connection = gson.fromJson(ret, Connection.class);
            id = connection.id;

            out = new DataOutputStream(socket.getOutputStream());

            while (true) {
                ret = reader.readLine();
                if (ret == null || ret.length() == 0) break;
                BaseResponse br = gson.fromJson(ret, BaseResponse.class);
                switch (br.eventId) {
                    case 11:
                        //创建房间的返回消息
                        if (br.status == 0) {
                            //创建失败
                            //MsgFailed msg = gson.fromJson(ret, MsgFailed.class);
                        }
                        else {
                            //CreateRoomSuccess msg = gson.fromJson(ret, CreateRoomSuccess.class);
                        }
                        break;
                    case 13:
                        //获取房间列表
                        //RoomList msg = gson.fromJson(ret, RoomList.class);
                        break;
                    case 15:
                        //加入房间的返回消息
                        if (br.status == 0) {
                            //加入失败
                            //MsgFailed msg = gson.fromJson(ret, MsgFailed.class);
                        }
                        else {
                            //JoinRoomSuccess msg = gson.fromJson(ret, JoinRoomSuccess.class);
                        }
                        break;
                    case 16:
                        //有人进入房间
                        //JoinRoomSuccess msg = gson.fromJson(ret, JoinRoomSuccess.class);
                        break;
                    default:
                        System.err.println("Wrong message format: " + ret);
                }
                System.out.print(ret);
            }
        } catch (Exception e) {
            System.out.println("ERROR CLIENT: " + e.getMessage());
        } finally {
        }
    }

    public static void write(String data) {
        try {
            out.writeUTF(data);
            out.flush();
        } catch (Exception e) {
            System.out.println("write ERROR: " + e.getMessage());
        }
    }
}
