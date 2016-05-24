package com.example.weiqichen.myapplication;

import android.os.AsyncTask;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

/**
 * Created by WeiqiChen on 2016/5/18.
 */
//未完成
public class Move {
    public static Position pos[] = new Position[]{
            new Position(95,387),new Position(94,365),new Position(103,341),new Position(86,324),new Position(64,334),new Position(43,331),
            new Position(19,324),new Position(10,299),new Position(10,279),new Position(10,257),new Position(10,235),new Position(9,214),
            new Position(17,190),new Position(42,181),new Position(63,181),new Position(86,190),new Position(103,175),new Position(95,151),
            new Position(95,129),new Position(103,105),new Position(127,97),new Position(148,97),new Position(168,97),new Position(191,99),
            new Position(211,97),new Position(235,108),new Position(244,132),new Position(244,152),new Position(235,177),new Position(251,192),
            new Position(276,184),new Position(298,184),new Position(320,195),new Position(328,215),new Position(328,236),new Position(328,258), new Position(328,278),
            new Position(328,300),new Position(321,324),new Position(297,332),new Position(277,332),new Position(252,324),new Position(235,339),
            new Position(244,365),new Position(244,385),new Position(236,410),new Position(213,417),new Position(191,419),new Position(170,417),new Position(149,418),new Position(126,418),new Position(104,410)};

    public static Position bluepos[] = new Position[]{
            new Position(95, 387), new Position(94, 365), new Position(103, 341), new Position(86, 324), new Position(64, 334), new Position(43, 331),
            new Position(19, 324), new Position(10, 299), new Position(10, 279), new Position(10, 257), new Position(10, 235), new Position(9, 214),
            new Position(17, 190), new Position(42, 181), new Position(63, 181), new Position(86, 190), new Position(103, 175), new Position(95, 151),
            new Position(95, 129), new Position(103, 105), new Position(127, 97), new Position(148, 97), new Position(168, 97), new Position(191, 99),
            new Position(211, 97), new Position(235, 108), new Position(244, 132), new Position(244, 152), new Position(235, 177), new Position(251, 192),
            new Position(276, 184), new Position(298, 184), new Position(320, 195), new Position(328, 215), new Position(328, 236), new Position(328, 258), new Position(328, 278),
            new Position(328, 300), new Position(321, 324), new Position(297, 332), new Position(277, 332), new Position(252, 324), new Position(235, 339),
            new Position(244, 365), new Position(244, 385), new Position(236, 410), new Position(213, 417), new Position(191, 419), new Position(170, 417),
            new Position(169, 386), new Position(170, 366), new Position(170, 344), new Position(170, 325),
            new Position(169, 303), new Position(169, 281)};
    //public static Position bluein[]=new Position[]{};
    //public static Position blueout[]=new Position[]{new Position(169,281),new Position(169,303),new Position(170,325),new Position(170,344),
    //new Position(170,366),new Position(169,386)};
    public static Position greenpos[] = new Position[]{new Position(42, 181), new Position(63, 181), new Position(86, 190), new Position(103, 175), new Position(95, 151),
            new Position(95, 129), new Position(103, 105), new Position(127, 97), new Position(148, 97), new Position(168, 97), new Position(191, 99),
            new Position(211, 97), new Position(235, 108), new Position(244, 132), new Position(244, 152), new Position(235, 177), new Position(251, 192),
            new Position(276, 184), new Position(298, 184), new Position(320, 195), new Position(328, 215), new Position(328, 236), new Position(328, 258), new Position(328, 278),
            new Position(328, 300), new Position(321, 324), new Position(297, 332), new Position(277, 332), new Position(252, 324), new Position(235, 339),
            new Position(244, 365), new Position(244, 385), new Position(236, 410), new Position(213, 417), new Position(191, 419), new Position(170, 417),
            new Position(148, 418), new Position(127, 418), new Position(103, 411), new Position(95, 387), new Position(94, 365), new Position(103, 341), new Position(86, 324), new Position(64, 334), new Position(43, 331),
            new Position(19, 324), new Position(10, 299), new Position(10, 279), new Position(10, 257), new Position(43, 258), new Position(64, 258), new Position(86, 258),
            new Position(105, 258), new Position(127, 258), new Position(148, 258)};
    public static Position redpos[] = new Position[]{new Position(244, 132), new Position(244, 152), new Position(235, 177), new Position(251, 192),
            new Position(276, 184), new Position(298, 184), new Position(320, 195), new Position(328, 215), new Position(328, 236), new Position(328, 258), new Position(328, 278),
            new Position(328, 300), new Position(321, 324), new Position(297, 332), new Position(277, 332), new Position(252, 324), new Position(235, 339),
            new Position(244, 365), new Position(244, 385), new Position(236, 410), new Position(213, 417), new Position(191, 419), new Position(170, 417),
            new Position(148, 418), new Position(127, 418), new Position(103, 411), new Position(95, 387), new Position(94, 365), new Position(103, 341), new Position(86, 324), new Position(64, 334), new Position(43, 331),
            new Position(19, 324), new Position(10, 299), new Position(10, 279), new Position(10, 257), new Position(10, 235), new Position(9, 214),
            new Position(17, 190), new Position(42, 181), new Position(63, 181), new Position(86, 190), new Position(103, 175), new Position(95, 151),
            new Position(95, 129), new Position(103, 105), new Position(127, 97), new Position(148, 97), new Position(168, 97), new Position(169, 133),
            new Position(169, 157), new Position(169, 176), new Position(169, 194), new Position(169, 216), new Position(169, 237)};
    public static Position yellowpos[] = new Position[]{new Position(297, 332), new Position(277, 332), new Position(252, 324), new Position(235, 339),
            new Position(244, 365), new Position(244, 385), new Position(236, 410), new Position(213, 417), new Position(191, 419), new Position(170, 417),
            new Position(148, 418), new Position(127, 418), new Position(103, 411), new Position(95, 387), new Position(94, 365), new Position(103, 341), new Position(86, 324), new Position(64, 334), new Position(43, 331),
            new Position(19, 324), new Position(10, 299), new Position(10, 279), new Position(10, 257), new Position(10, 235), new Position(9, 214),
            new Position(17, 190), new Position(42, 181), new Position(63, 181), new Position(86, 190), new Position(103, 175), new Position(95, 151),
            new Position(95, 129), new Position(103, 105), new Position(127, 97), new Position(148, 97), new Position(168, 97), new Position(191, 99),
            new Position(211, 97), new Position(235, 108), new Position(244, 132), new Position(244, 152), new Position(235, 177), new Position(251, 192),
            new Position(276, 184), new Position(298, 184), new Position(320, 195), new Position(328, 215), new Position(328, 236), new Position(328, 258),
            new Position(294, 258), new Position(277, 258), new Position(254, 258), new Position(232, 258), new Position(213, 258), new Position(193, 258)};


}

class Position{
    private int x;
    private int y;
    private fcViewImageButton btn;
    private fcViewImageButton btn1;
    private int status;
    private int re;
    Position(int x,int y){
        this.x=x;
        this.y=y;
        this.btn = null;
        this.re = 0;
        this.status = 0;
    }

    public int GetX(){
        return x;
    }
    public int GetY(){
        return y;
    }
    public void setre(int re){ this.re = re;}
    public int Getre(){ return re;}
    public void setid(fcViewImageButton btn) {this.btn = btn;}
    public fcViewImageButton getBtn(){ return btn;}
    public void setStatus(int i) { this.status = i;}
    public int getStatus(){ return status; }
}
class mvAsyncTask extends AsyncTask<String,Integer,String> {
    private fcViewImageButton fc;
    private int start;
    private int end;
    private int flyflag=0;
    private int turn=0;
    private Position []position;
    private fcViewImageButton btn;
    private fcViewImageButton btn1;
    private int color;
    private int j;
    private int posi;
    //private int status;
    public mvAsyncTask(fcViewImageButton fc,int start,int end,Position[] position,fcViewImageButton btn,int j,int color,int posi){
        super();
        this.fc=fc;
        this.start=start;
        this.end=end;
        this.position=position;
        this.btn  = btn;
        this.color = color;
        this.j = j;
        this.posi = posi;
        //this.status=status;
    }
    protected void onPreExecute(){
        ;
    }
    protected void onProgressUpdate(Integer... values){
        if(values[0]==53){
            fc.setFlyroad(1);
        }
        if(values[0] == start && start<= 48){
            if(color == 1){
                Move.pos[values[0]].setre(0);
                Move.pos[values[0]].setid(btn1);
            }
            else if(color == 2){
                if( values[0] < 39 ){
                    Move.pos[values[0] + 13].setre(0);
                    Move.pos[values[0] + 13].setid(btn1);
                }
                else if(values[0] <= 48){
                    Move.pos[values[0] - 39].setre(0);
                    Move.pos[values[0] - 39].setid(btn1);
                }
                else{ ; }
            }
            else if(color == 3){
                if(values[0] < 26){
                    Move.pos[values[0] + 26].setre(0);
                    Move.pos[values[0] + 26].setid(btn1);
                }
                else if(values[0] <= 48){
                    Move.pos[values[0] - 26].setre(0);
                    Move.pos[values[0] - 26].setid(btn1);
                }
                else { ; }
            }
            else if(color == 4){
                if(values[0] < 13){
                    Move.pos[values[0] + 39].setre(0);
                    Move.pos[values[0] + 39].setid(btn1);
                }
                else if(values[0] <= 48){
                    Move.pos[values[0] - 13].setre(0);
                    Move.pos[values[0] - 13].setid(btn1);
                }
                else { ; }
            }
        }

        final int i = values[0];
        ////////////////////////////

        ////////////////////////////
        float startX, startY, endX, endY;
        startX = position[i].GetX() * 2 + 0.5f;
        startY = (float) (position[i].GetY() * 2 * 1.08) + 0.5f;
        endX = position[(i + 1)].GetX() * 2 + 0.5f;
        endY = (float) (position[(i + 1)].GetY() * 2 * 1.08) + 0.5f;
        Animation animation = new TranslateAnimation(0, endX - startX, 0, endY - startY);
        animation.setDuration(500);
        animation.setFillAfter(true);
        fc.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
// TODO Auto-generated method stub
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
// TODO Auto-generated method stub
            }

            @Override
            public void onAnimationEnd(Animation animation) {
// TODO Auto-generated method stub
                fc.clearAnimation();
                int reX = 0, reY = 0;
                ///////////////////////////
                if ((i == end - 1) && end <= 48) {
                    int k;
                    if (color == 1) {
                        if (posi != -1) {
                            k = Move.pos[posi].Getre();
                            if (k != j && k != 0) {
                                int m = btn.getcolor();
                                // int reX = 0,reY = 0;
                                switch (m) {
                                    case 2:
                                        for (int i = 0; i < 4; i++) {
                                            if (airport.green_airport[i].getStatus() == 1) {
                                                reX = airport.green_airport[i].GetX();
                                                reY = airport.green_airport[i].GetY();
                                                airport.green_airport[i].setStatus(0);
                                                break;
                                            }
                                        }
                                        break;
                                    case 3:
                                        for (int i = 0; i < 4; i++) {
                                            if (airport.red_airport[i].getStatus() == 1) {
                                                reX = airport.red_airport[i].GetX();
                                                reY = airport.red_airport[i].GetY();
                                                airport.red_airport[i].setStatus(0);
                                                break;
                                            }
                                        }
                                        break;
                                    case 4:
                                        for (int i = 0; i < 4; i++) {
                                            if (airport.yellow_airport[i].getStatus() == 1) {
                                                reX = airport.yellow_airport[i].GetX();
                                                reY = airport.yellow_airport[i].GetY();
                                                airport.yellow_airport[i].setStatus(0);
                                                break;
                                            }
                                        }
                                        break;
                                }
                            }
                        }
                    } else if (color == 2) {
                        k = Move.pos[posi].Getre();
                        if (k != j && k != 0) {
                            int m = btn.getcolor();
                            //int reX = 0,reY = 0;
                            switch (m) {
                                case 1:
                                    for (int i = 0; i < 4; i++) {
                                        if (airport.blue_airport[i].getStatus() == 1) {
                                            reX = airport.blue_airport[i].GetX();
                                            reY = airport.blue_airport[i].GetY();
                                            airport.blue_airport[i].setStatus(0);
                                            break;
                                        }
                                    }
                                    break;
                                case 3:
                                    for (int i = 0; i < 4; i++) {
                                        if (airport.red_airport[i].getStatus() == 1) {
                                            reX = airport.red_airport[i].GetX();
                                            reY = airport.red_airport[i].GetY();
                                            airport.red_airport[i].setStatus(0);
                                            break;
                                        }
                                    }
                                    break;
                                case 4:
                                    for (int i = 0; i < 4; i++) {
                                        if (airport.yellow_airport[i].getStatus() == 1) {
                                            reX = airport.yellow_airport[i].GetX();
                                            reY = airport.yellow_airport[i].GetY();
                                            airport.yellow_airport[i].setStatus(0);
                                            break;
                                        }
                                    }
                                    break;
                            }
                        }
                    }
                    if (color == 3) {
                        if (posi != -1) {
                            k = Move.pos[posi].Getre();
                            if (k != j && k != 0) {
                                int m = btn.getcolor();
                                // int reX = 0,reY = 0;
                                switch (m) {
                                    case 2:
                                        for (int i = 0; i < 4; i++) {
                                            if (airport.green_airport[i].getStatus() == 1) {
                                                reX = airport.green_airport[i].GetX();
                                                reY = airport.green_airport[i].GetY();
                                                airport.green_airport[i].setStatus(0);
                                                break;
                                            }
                                        }
                                        break;
                                    case 1:
                                        for (int i = 0; i < 4; i++) {
                                            if (airport.blue_airport[i].getStatus() == 1) {
                                                reX = airport.blue_airport[i].GetX();
                                                reY = airport.blue_airport[i].GetY();
                                                airport.blue_airport[i].setStatus(0);
                                                break;
                                            }
                                        }
                                        break;
                                    case 4:
                                        for (int i = 0; i < 4; i++) {
                                            if (airport.yellow_airport[i].getStatus() == 1) {
                                                reX = airport.yellow_airport[i].GetX();
                                                reY = airport.yellow_airport[i].GetY();
                                                airport.yellow_airport[i].setStatus(0);
                                                break;
                                            }
                                        }
                                        break;
                                }
                            }
                        }
                    }
                    if (color == 4) {
                        if (posi != -1) {
                            k = Move.pos[posi].Getre();
                            if (k != j && k != 0) {
                                int m = btn.getcolor();
                                // int reX = 0,reY = 0;
                                switch (m) {
                                    case 2:
                                        for (int i = 0; i < 4; i++) {
                                            if (airport.green_airport[i].getStatus() == 1) {
                                                reX = airport.green_airport[i].GetX();
                                                reY = airport.green_airport[i].GetY();
                                                airport.green_airport[i].setStatus(0);
                                                break;
                                            }
                                        }
                                        break;
                                    case 3:
                                        for (int i = 0; i < 4; i++) {
                                            if (airport.red_airport[i].getStatus() == 1) {
                                                reX = airport.red_airport[i].GetX();
                                                reY = airport.red_airport[i].GetY();
                                                airport.red_airport[i].setStatus(0);
                                                break;
                                            }
                                        }
                                        break;
                                    case 1:
                                        for (int i = 0; i < 4; i++) {
                                            if (airport.blue_airport[i].getStatus() == 1) {
                                                reX = airport.blue_airport[i].GetX();
                                                reY = airport.blue_airport[i].GetY();
                                                airport.blue_airport[i].setStatus(0);
                                                break;
                                            }
                                        }
                                        break;
                                }
                            }
                        }
                    }
                    if(reX!=0 && reY!=0){
                        int flyX,flyY;
                        flyX = position[end].GetX();
                        flyY = position[end].GetY();
                        fbAsyncTask fbasy = new fbAsyncTask(btn,flyX,flyY,reX,reY);
                        fbasy.execute("a");
                    }
                    Move.pos[posi].setre(j);
                    Move.pos[posi].setid(fc);
                }
                ////////////////////////////////
                ///////////////////////////////
                fc.setX(position[(i + 1)].GetX() * 2 + 0.5f);
                fc.setY((float) (position[(i + 1)].GetY() * 2 * 1.08) + 0.5f);
            }
        });
    }

    @Override
    protected String doInBackground(String... params) {
        for (int i = this.start; i < this.end; i++) {
            if(i==54){
                int pp = 0;
                pp++;
                break;
            }
            try {
                publishProgress(i);
                Thread.currentThread().sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
