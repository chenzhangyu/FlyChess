package com.example.weiqichen.myapplication;

/**
 * Created by WeiqiChen on 2016/5/18.
 */
//未完成
public class Move {
    public static Position pos[] = new Position[]{new Position(170,417),new Position(149,418),new Position(126,418),new Position(104,410),
    new Position(95,387),new Position(94,365),new Position(103,341),new Position(86,324),new Position(64,334),new Position(43,331),
    new Position(19,324),new Position(10,299),new Position(10,279),new Position(10,257),new Position(10,235),new Position(9,214),
    new Position(17,190),new Position(42,181),new Position(63,181),new Position(86,190),new Position(103,175),new Position(95,151),
    new Position(95,129),new Position(103,105),new Position(127,97),new Position(148,97),new Position(168,97)};
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
