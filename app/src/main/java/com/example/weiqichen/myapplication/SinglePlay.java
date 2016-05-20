package com.example.weiqichen.myapplication;

import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.content.Context;
import java.lang.ref.SoftReference;
import java.util.Timer;
import java.util.TimerTask;

import android.util.AttributeSet;
/**
 * Created by WeiqiChen on 2016/4/20.
 */
public class SinglePlay extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_play);
        final float scale = getResources().getDisplayMetrics().density;
        final fcViewImageButton blue1 = (fcViewImageButton) findViewById(R.id.blue1);
        final fcViewImageButton blue2 = (fcViewImageButton) findViewById(R.id.blue2);
        final fcViewImageButton blue3 = (fcViewImageButton) findViewById(R.id.blue3);
        final fcViewImageButton blue4 = (fcViewImageButton) findViewById(R.id.blue4);
        final ImageButton sz = (ImageButton) findViewById(R.id.sz);
        sz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Global.szStatus==0) {
                    SzAsyncTask szasyncTask = new SzAsyncTask(sz);
                    szasyncTask.execute("a");
                    Global.szStatus=1;
                }
            }
        });
        blue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Global.ran==5&&blue1.getFlystutas()==0&&Global.szStatus==1) {
                    v.setX(170 * scale + 0.5f);
                    v.setY((float) (417 * scale * 1.08) + 0.5f); //乘以屏幕尺寸缩放比 暂适配小米2s
                    blue1.setflystatus(1);
                    blue1.setId(0);
                }
                else if(blue1.getFlystutas()==1&&Global.szStatus==1){
                    blue1.setId(Global.ran + 1);
                    blue1.setX(Move.pos[blue1.getId()].GetX() * scale + 0.5f);
                    blue1.setY((float)(Move.pos[blue1.getId()].GetY()*scale*1.08)+0.5f);
                }
                Global.szStatus=0;
            }
        });
        blue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Global.ran==5&&blue2.getFlystutas()==0&&Global.szStatus==1) {
                    v.setX(170 * scale + 0.5f);
                    v.setY((float) (417 * scale * 1.08) + 0.5f); //乘以屏幕尺寸缩放比 暂适配小米2s
                    blue2.setflystatus(1);
                    blue2.setId(0);
                }
                else if(blue2.getFlystutas()==1&&Global.szStatus==1){
                    blue2.setId(Global.ran + 1);
                    blue2.setX(Move.pos[blue2.getId()].GetX() * scale + 0.5f);
                    blue2.setY((float)(Move.pos[blue2.getId()].GetY()*scale*1.08)+0.5f);
                }
                Global.szStatus=0;
            }
        });
        blue3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Global.ran==5&&blue3.getFlystutas()==0&&Global.szStatus==1) {
                    v.setX(170 * scale + 0.5f);
                    v.setY((float) (417 * scale * 1.08) + 0.5f); //乘以屏幕尺寸缩放比 暂适配小米2s
                    blue3.setflystatus(1);
                    blue3.setId(0);
                }
                else if(blue3.getFlystutas()==1&&Global.szStatus==1){
                    blue3.setId(Global.ran + 1);
                    blue3.setX(Move.pos[blue3.getId()].GetX() * scale + 0.5f);
                    blue3.setY((float)(Move.pos[blue3.getId()].GetY()*scale*1.08)+0.5f);
                }
                Global.szStatus=0;
            }
        });
        blue4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Global.ran==5&&blue4.getFlystutas()==0&&Global.szStatus==1) {
                    v.setX(170 * scale + 0.5f);
                    v.setY((float) (417 * scale * 1.08) + 0.5f); //乘以屏幕尺寸缩放比 暂适配小米2s
                    blue4.setflystatus(1);
                    blue4.setId(0);
                }
                else if(blue4.getFlystutas()==1&&Global.szStatus==1){
                    //float startX,startY,endX,endY;
                    int begin,end;
                    begin=blue4.getId();
                    blue4.setId(Global.ran + 1);
                    end=blue4.getId();
                    mvAsyncTask mvasy = new mvAsyncTask(blue4,begin,end);
                    mvasy.execute("a");
                    /*for(int i=begin;i<end;i++) {
                        startX = Move.pos[i].GetX() * scale + 0.5f;
                        startY = (float) (Move.pos[i].GetY() * scale * 1.08) + 0.5f;
                        endX = Move.pos[i+1].GetX() * scale + 0.5f;
                        endY = (float) (Move.pos[i+1].GetY() * scale * 1.08) + 0.5f;
                        Animation animation = new TranslateAnimation(0, endX - startX, 0, endY - startY);
                        animation.setDuration(1000);
                        animation.setFillAfter(true);
                        blue4.startAnimation(animation);
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
                                blue4.clearAnimation();

                            }
                        });
                    }*/
                    //blue4.setX(Move.pos[blue4.getId()].GetX() * scale + 0.5f);
                    //blue4.setY((float) (Move.pos[blue4.getId()].GetY() * scale * 1.08) + 0.5f);
                }
                Global.szStatus=0;
            }
        });
    }
}
class SzAsyncTask extends AsyncTask<String,Integer,String>{
    private ImageButton sz;
    public SzAsyncTask(ImageButton sz){
        super();
        this.sz=sz;
    }
    protected void onPreExecute(){
        ;
    }
    protected void onProgressUpdate(Integer... values){
        Global.ran = (int) (Math.random() * 6) % 6;
        switch (Global.ran) {
            case 0:
                sz.setBackgroundResource(R.drawable.sz1);
                break;
            case 1:
                sz.setBackgroundResource(R.drawable.sz2);
                break;
            case 2:
                sz.setBackgroundResource(R.drawable.sz3);
                break;
            case 3:
                sz.setBackgroundResource(R.drawable.sz4);
                break;
            case 4:
                sz.setBackgroundResource(R.drawable.sz5);
                break;
            case 5:
                sz.setBackgroundResource(R.drawable.sz6);
                break;
        }
    }

    @Override
    protected String doInBackground(String... params) {
        for(int i=0;i<20;i++){
            try{
                publishProgress();
                Thread.currentThread().sleep(50);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        return null;
    }
    protected void onPostExecute(){
        if(Global.ran==5){
            Global.szStatus=1;
        }
    }
}
class fcViewImageButton extends ImageButton{
    private int CurrentId=0,flystutas;
    public fcViewImageButton(Context context){
        super(context);
    }
    public fcViewImageButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    public fcViewImageButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
    }
    public void setId(int ran){
        CurrentId+=ran;
    }
    public int getId(){
        return CurrentId;
    }
    public void setflystatus(int status){
        flystutas=status;
    }
    public int getFlystutas(){
        return flystutas;
    }
}

