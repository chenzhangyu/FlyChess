package com.example.weiqichen.myapplication;

import android.os.AsyncTask;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

/**
 * Created by WeiqiChen on 2016/5/18.
 */
//未完成
public class Move {
    public static Position pos[] = new Position[]{new Position(170,417),new Position(149,418),new Position(126,418),new Position(104,410),
    new Position(95,387),new Position(94,365),new Position(103,341),new Position(86,324),new Position(64,334),new Position(43,331),
    new Position(19,324),new Position(10,299),new Position(10,279),new Position(10,257),new Position(10,235),new Position(9,214),
    new Position(17,190),new Position(42,181),new Position(63,181),new Position(86,190),new Position(103,175),new Position(95,151),
    new Position(95,129),new Position(103,105),new Position(127,97),new Position(148,97),new Position(168,97),new Position(191,99),
    new Position(211,97),new Position(235,108),new Position(244,132),new Position(244,152),new Position(235,177),new Position(251,192),
    new Position(276,184),new Position(298,184),new Position(320,195),new Position(328,215),new Position(328,236),new Position(328,258), new Position(328,278),
    new Position(328,300),new Position(321,324),new Position(297,332),new Position(277,332),new Position(252,324),new Position(235,339),
    new Position(244,365),new Position(244,385),new Position(236,410),new Position(213,417),new Position(191,419)};
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
class mvAsyncTask extends AsyncTask<String,Integer,String> {
    private fcViewImageButton fc;
    private int start;
    private int end;
    public mvAsyncTask(fcViewImageButton fc,int start,int end){
        super();
        this.fc=fc;
        this.start=start;
        this.end=end;
    }
    protected void onPreExecute(){
        ;
    }
    protected void onProgressUpdate(Integer... values){
        final int i=values[0];
        float startX,startY,endX,endY;
        startX = Move.pos[values[0]].GetX() * 2 + 0.5f;
        startY = (float) (Move.pos[values[0]].GetY() * 2 * 1.08) + 0.5f;
        endX = Move.pos[values[0]+1].GetX() * 2 + 0.5f;
        endY = (float) (Move.pos[values[0]+1].GetY() * 2 * 1.08) + 0.5f;
        Animation animation = new TranslateAnimation(0, endX - startX, 0, endY - startY);
        animation.setDuration(1000);
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
                fc.setX(Move.pos[i+1].GetX() * 2 + 0.5f);
                fc.setY((float) (Move.pos[i+1].GetY() * 2 * 1.08) + 0.5f);

            }
        });
    }

    @Override
    protected String doInBackground(String... params) {
        for(int i=this.start;i<this.end;i++){
            try{
                publishProgress(i);
                Thread.currentThread().sleep(1200);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        return null;
    }
}
