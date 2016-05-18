package com.example.weiqichen.myapplication;

/**
 * Created by WeiqiChen on 2016/5/18.
 */
//未完成
public class Move {
    Position pos[] = new Position[]{new Position(181,398),new Position(159,200)};
    public void start(){
        for(int i=0;i<2;i++){
            pos[i].GetX();
        }
    }
}
class Position{
    private int x;
    private int y;
    Position(int x,int y){
        this.x=x;
        this.y=y;
    }
    public int GetX(){
        return x;
    }
    public int GetY(){
        return y;
    }
}
