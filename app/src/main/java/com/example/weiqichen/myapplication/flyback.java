package com.example.weiqichen.myapplication;

import android.os.AsyncTask;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

/**
 * Created by sevev on 2016/5/24 0024.
 */
public class flyback {
          ;
}




class fbAsyncTask extends AsyncTask<String,Integer,String> {
    private fcViewImageButton fc;
    private int startX;
    private int startY;
    private int endX;
    private int endY;
    //private int status;
    public fbAsyncTask(fcViewImageButton fc,int startX,int startY,int endX,int endY){
        super();
        this.fc=fc;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        //this.status=status;
    }
    protected void onPreExecute(){
        ;
    }
    protected void onProgressUpdate(Integer... values){

        final float startX, startY, endX, endY;
        startX = this.startX * 2 + 0.5f;
        startY = (float) (this.startY * 2 * 1.08) + 0.5f;
        endX = this.endX * 2 + 0.5f;
        endY = (float) (this.endY * 2 * 1.08) + 0.5f;
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
                fc.setX(endX);
                fc.setY(endY);
                fc.setflystatus(0);
                fc.initid();
            }
        });
    }

    @Override
    protected String doInBackground(String... params) {
            try {
                publishProgress();
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        return null;
    }
}