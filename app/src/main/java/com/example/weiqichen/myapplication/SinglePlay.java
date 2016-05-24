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
    int lastValue=0;
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
        final fcViewImageButton yellow1 = (fcViewImageButton) findViewById(R.id.yellow1);
        final fcViewImageButton yellow2 = (fcViewImageButton) findViewById(R.id.yellow2);
        final fcViewImageButton yellow3 = (fcViewImageButton) findViewById(R.id.yellow3);
        final fcViewImageButton yellow4 = (fcViewImageButton) findViewById(R.id.yellow4);
        final fcViewImageButton green1 = (fcViewImageButton) findViewById(R.id.green1);
        final fcViewImageButton green2 = (fcViewImageButton) findViewById(R.id.green2);
        final fcViewImageButton green3 = (fcViewImageButton) findViewById(R.id.green3);
        final fcViewImageButton green4 = (fcViewImageButton) findViewById(R.id.green4);
        final fcViewImageButton red1 = (fcViewImageButton) findViewById(R.id.red1);
        final fcViewImageButton red2 = (fcViewImageButton) findViewById(R.id.red2);
        final fcViewImageButton red3 = (fcViewImageButton) findViewById(R.id.red3);
        final fcViewImageButton red4 = (fcViewImageButton) findViewById(R.id.red4);
        final ImageButton sz = (ImageButton) findViewById(R.id.sz);

        sz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Global.szStatus == 0 || (blue1.getFlystutas() == 0 && blue2.getFlystutas() == 0 && blue3.getFlystutas() == 0 && blue4.getFlystutas() == 0)||
                        (green1.getFlystutas()==0&&green2.getFlystutas()==0&&green3.getFlystutas()==0&&green4.getFlystutas()==0)||
                        (red1.getFlystutas()==0&&red2.getFlystutas()==0&&red3.getFlystutas()==0&&red4.getFlystutas()==0)||
                        (yellow1.getFlystutas()==0&&yellow2.getFlystutas()==0&&yellow3.getFlystutas()==0&&yellow4.getFlystutas()==0)) {

                    SzAsyncTask szasyncTask = new SzAsyncTask(sz);
                    szasyncTask.execute("a");
                    Global.szStatus = 1;
                    // if(!((Global.ran==5)||(lastValue==5))) {
                    Global.turn++;
                    Global.turn = Global.turn % 4;
                    //}
                    lastValue=Global.ran;
                    Global.showTurn(SinglePlay.this);
                }
            }
        });
        blue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((Global.turn==0)&&(Global.ran == 5 && blue1.getFlystutas() == 0 && Global.szStatus == 1)) {
                    v.setX(95 * scale + 0.5f);
                    v.setY((float) (387 * scale * 1.08) + 0.5f); //乘以屏幕尺寸缩放比 暂适配小米2s
                    blue1.setflystatus(1);
                    blue1.setId(0);
                    blue1.setcolor(1);
                    airport.blue_airport[0].setStatus(1);
                    int k = blue1.getId();
                    int j;
                    if(k <= 48){
                        j = Move.pos[blue1.getId()].Getre();
                    }
                    else {
                        j = 0;
                        k =-1;
                    }
                    if(j!=1&&j!=0){
                        fcViewImageButton btn = Move.pos[blue1.getId()].getBtn();
                        int m = btn.getcolor();
                        int reX=0,reY=0;
                        /////
                        switch(m){
                            case 2: for(int i=0;i<4;i++){
                                if (airport.green_airport[i].getStatus() == 1){
                                    reX = airport.green_airport[i].GetX();
                                    reY = airport.green_airport[i].GetY();
                                    airport.green_airport[i].setStatus(0);
                                    break;
                                }
                            } break;
                            case 3:for(int i=0;i<4;i++){
                                if (airport.red_airport[i].getStatus() == 1){
                                    reX = airport.red_airport[i].GetX();
                                    reY = airport.red_airport[i].GetY();
                                    airport.red_airport[i].setStatus(0);
                                    break;
                                }
                            } break;
                            case 4:for(int i=0;i<4;i++){
                                if (airport.yellow_airport[i].getStatus() == 1){
                                    reX = airport.yellow_airport[i].GetX();
                                    reY = airport.yellow_airport[i].GetY();
                                    airport.yellow_airport[i].setStatus(0);
                                    break;
                                }
                            } break;
                        }
                        //////
                        int flyX,flyY;
                        flyX = Move.pos[k].GetX();
                        flyY = Move.pos[k].GetY();
                        fbAsyncTask fbasy = new fbAsyncTask(btn,flyX,flyY,reX,reY);
                        fbasy.execute("a");
                    }
                    Move.pos[blue1.getId()].setre(1);
                    Move.pos[blue1.getId()].setid((fcViewImageButton) findViewById(R.id.blue1));

                } else if ((Global.turn==0)&&(blue1.getFlystutas() == 1 && Global.szStatus == 1)&& blue1.getFlyRoad()==0) {
                    int begin, end;
                    int k = blue1.getId();
                    int j;
                    if(k <= 48){
                        j = Move.pos[blue1.getId()].Getre();
                    }
                    else {
                        j = 0;
                        k = -1;
                    }
                    begin = blue1.getId();
                    blue1.setId(Global.ran + 1);
                    end = blue1.getId();
                    int m = 0;
                    if(end > 48){ m =1;}
                    fcViewImageButton btn1;
                    if (m == 0){
                        btn1 = Move.pos[end].getBtn();}
                    else {btn1 = null;}
                    mvAsyncTask mvasy = new mvAsyncTask(blue1, begin, end,Move.bluepos,btn1,j,blue1.getcolor(),end);
                    mvasy.execute("a");
                }
                Global.szStatus = 0;
            }
        });
        blue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((Global.turn==0)&&(Global.ran == 5&& blue2.getFlystutas() == 0 && Global.szStatus == 1)) {
                    v.setX(95 * scale + 0.5f);
                    v.setY((float) (387 * scale * 1.08) + 0.5f); //乘以屏幕尺寸缩放比 暂适配小米2s
                    blue2.setflystatus(1);
                    blue2.setId(0);
                    blue2.setcolor(1);
                    airport.blue_airport[1].setStatus(1);
                    int k = blue2.getId();
                    int j;
                    if(k <= 48){
                        j = Move.pos[blue2.getId()].Getre();
                    }
                    else {
                        j = 0;
                        k = -1;
                    }
                    if(j!=1&&j!=0){
                        fcViewImageButton btn = Move.pos[blue2.getId()].getBtn();
                        int m = btn.getcolor();
                        int reX=0,reY=0;
                        /////
                        switch(m){
                            case 2: for(int i=0;i<4;i++){
                                if (airport.green_airport[i].getStatus() == 1){
                                    reX = airport.green_airport[i].GetX();
                                    reY = airport.green_airport[i].GetY();
                                    airport.green_airport[i].setStatus(0);
                                    break;
                                }
                            } break;
                            case 3:for(int i=0;i<4;i++){
                                if (airport.red_airport[i].getStatus() == 1){
                                    reX = airport.red_airport[i].GetX();
                                    reY = airport.red_airport[i].GetY();
                                    airport.red_airport[i].setStatus(0);
                                    break;
                                }
                            } break;
                            case 4:for(int i=0;i<4;i++){
                                if (airport.yellow_airport[i].getStatus() == 1){
                                    reX = airport.yellow_airport[i].GetX();
                                    reY = airport.yellow_airport[i].GetY();
                                    airport.yellow_airport[i].setStatus(0);
                                    break;
                                }
                            } break;
                        }
                        //////
                        int flyX,flyY;
                        flyX = Move.pos[k].GetX();
                        flyY = Move.pos[k].GetY();
                        fbAsyncTask fbasy = new fbAsyncTask(btn,flyX,flyY,reX,reY);
                        fbasy.execute("a");
                    }
                    Move.pos[blue2.getId()].setre(1);
                    Move.pos[blue2.getId()].setid((fcViewImageButton) findViewById(R.id.blue2));

                } else if  ((Global.turn==0)&&(blue2.getFlystutas() == 1 && Global.szStatus == 1)&&blue2.getFlyRoad()==0) {
                    int begin, end;
                    int k = blue2.getId();
                    int j;
                    if(k<=48){
                        j = Move.pos[blue2.getId()].Getre();
                    }
                    else {
                        j = 0;
                        k = -1;
                    }
                    begin = blue2.getId();
                    blue2.setId(Global.ran + 1);
                    end = blue2.getId();
                    int m = 0;
                    if(end > 48){ m =1;}
                    fcViewImageButton btn1;
                    if (m == 0){
                        btn1 = Move.pos[end].getBtn();}
                    else {btn1 = null;}
                    mvAsyncTask mvasy = new mvAsyncTask(blue2, begin, end,Move.bluepos,btn1,j,blue2.getcolor(),end);
                    mvasy.execute("a");
                }
                Global.szStatus = 0;
            }
        });
        blue3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if  ((Global.turn==0)&&(Global.ran == 5 && blue3.getFlystutas() == 0 && Global.szStatus == 1)) {
                    v.setX(95 * scale + 0.5f);
                    v.setY((float) (387 * scale * 1.08) + 0.5f); //乘以屏幕尺寸缩放比 暂适配小米2s
                    blue3.setflystatus(1);
                    blue3.setId(0);
                    blue3.setcolor(1);
                    airport.blue_airport[2].setStatus(1);
                    int k = blue3.getId();
                    int j;
                    if(k<=48){
                        j = Move.pos[blue3.getId()].Getre();
                    }
                    else {
                        j = 0;
                        k = -1;
                    }
                    if(j!=1&&j!=0){
                        fcViewImageButton btn = Move.pos[blue3.getId()].getBtn();
                        int m = btn.getcolor();
                        int reX=0,reY=0;
                        /////
                        switch(m){
                            case 2: for(int i=0;i<4;i++){
                                if (airport.green_airport[i].getStatus() == 1){
                                    reX = airport.green_airport[i].GetX();
                                    reY = airport.green_airport[i].GetY();
                                    airport.green_airport[i].setStatus(0);
                                    break;
                                }
                            } break;
                            case 3:for(int i=0;i<4;i++){
                                if (airport.red_airport[i].getStatus() == 1){
                                    reX = airport.red_airport[i].GetX();
                                    reY = airport.red_airport[i].GetY();
                                    airport.red_airport[i].setStatus(0);
                                    break;
                                }
                            } break;
                            case 4:for(int i=0;i<4;i++){
                                if (airport.yellow_airport[i].getStatus() == 1){
                                    reX = airport.yellow_airport[i].GetX();
                                    reY = airport.yellow_airport[i].GetY();
                                    airport.yellow_airport[i].setStatus(0);
                                    break;
                                }
                            } break;
                        }
                        //////
                        int flyX,flyY;
                        flyX = Move.pos[k].GetX();
                        flyY = Move.pos[k].GetY();
                        fbAsyncTask fbasy = new fbAsyncTask(btn,flyX,flyY,reX,reY);
                        fbasy.execute("a");
                    }
                    Move.pos[blue3.getId()].setre(1);
                    Move.pos[blue3.getId()].setid((fcViewImageButton) findViewById(R.id.blue3));

                } else if ((Global.turn==0)&&(blue3.getFlystutas() == 1 && Global.szStatus == 1)&&blue3.getFlyRoad()==0) {
                    int k = blue3.getId();
                    int j;
                    if(k<=48){
                        j = Move.pos[blue3.getId()].Getre();
                    }
                    else {
                        j = 0;
                        k = -1;
                    }
                    int begin, end;
                    begin = blue3.getId();
                    blue3.setId(Global.ran + 1);
                    end = blue3.getId();
                    int m = 0;
                    if(end > 48){ m =1;}
                    fcViewImageButton btn1;
                    if (m == 0){
                        btn1 = Move.pos[end].getBtn();}
                    else {
                        btn1 = null;
                    }
                    mvAsyncTask mvasy = new mvAsyncTask(blue3, begin, end,Move.bluepos,btn1,j,blue3.getcolor(),end);
                    mvasy.execute("a");
                        /*if(!((Global.ran==5)||(lastValue==5))) {
                            Global.turn++;
                            Global.turn = Global.turn % 2;
                        }*/
                }
                Global.szStatus = 0;
            }
        });
        blue4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if  ((Global.turn==0)&&(Global.ran == 5&& blue4.getFlystutas() == 0 && Global.szStatus == 1)) {
                    v.setX(95 * scale + 0.5f);
                    v.setY((float) (387 * scale * 1.08) + 0.5f); //乘以屏幕尺寸缩放比 暂适配小米2s
                    blue4.setflystatus(1);
                    blue4.setId(0);
                    blue4.setcolor(1);
                    airport.blue_airport[3].setStatus(1);
                    int k = blue4.getId();
                    int j;
                    if(k <= 48){
                        j = Move.pos[blue4.getId()].Getre();
                    }
                    else {
                        j = 0;
                        k  = -1;
                    }
                    if(j!=1&&j!=0){
                        fcViewImageButton btn = Move.pos[blue4.getId()].getBtn();
                        int m = btn.getcolor();
                        int reX=0,reY=0;
                        /////
                        switch(m){
                            case 2: for(int i=0;i<4;i++){
                                if (airport.green_airport[i].getStatus() == 1){
                                    reX = airport.green_airport[i].GetX();
                                    reY = airport.green_airport[i].GetY();
                                    airport.green_airport[i].setStatus(0);
                                    break;
                                }
                            } break;
                            case 3:for(int i=0;i<4;i++){
                                if (airport.red_airport[i].getStatus() == 1){
                                    reX = airport.red_airport[i].GetX();
                                    reY = airport.red_airport[i].GetY();
                                    airport.red_airport[i].setStatus(0);
                                    break;
                                }
                            } break;
                            case 4:for(int i=0;i<4;i++){
                                if (airport.yellow_airport[i].getStatus() == 1){
                                    reX = airport.yellow_airport[i].GetX();
                                    reY = airport.yellow_airport[i].GetY();
                                    airport.yellow_airport[i].setStatus(0);
                                    break;
                                }
                            } break;
                        }
                        //////
                        int flyX,flyY;
                        flyX = Move.pos[k].GetX();
                        flyY = Move.pos[k].GetY();
                        fbAsyncTask fbasy = new fbAsyncTask(btn,flyX,flyY,reX,reY);
                        fbasy.execute("a");
                    }
                    Move.pos[blue4.getId()].setre(1);
                    Move.pos[blue4.getId()].setid((fcViewImageButton) findViewById(R.id.blue4));

                } else if ((Global.turn==0)&&(blue4.getFlystutas() == 1 && Global.szStatus == 1)&&blue4.getFlyRoad()==0) {
                    //float startX,startY,endX,endY;
                    int begin, end;
                    int k = blue4.getId();
                    int j;
                    if(k<=48){
                        j = Move.pos[blue4.getId()].Getre();
                    }
                    else {
                        j = 0;
                        k = -1;
                    }
                    begin = blue4.getId();
                    blue4.setId(Global.ran + 1);
                    //blue4.setId(26);
                    end = blue4.getId();
                    int m = 0;
                    if(end > 48){ m =1;}
                    fcViewImageButton btn1;
                    if (m == 0){
                        btn1 = Move.pos[end].getBtn();}
                    else {
                        btn1 = null;
                    }
                    mvAsyncTask mvasy = new mvAsyncTask(blue4, begin, end,Move.bluepos,btn1,j,blue4.getcolor(),end);
                    mvasy.execute("a");
                        /*if(!((Global.ran==5)||(lastValue==5))) {
                            Global.turn++;
                            Global.turn = Global.turn % 2;
                        }*/
                }
                Global.szStatus = 0;
            }
        });


            /*sz.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if ((Global.turn==1)&&(Global.szStatus == 0 || (green1.getFlystutas() == 0 && green2.getFlystutas() == 0 && green3.getFlystutas() == 0 && green4.getFlystutas() == 0))) {
                        SzAsyncTask szasyncTask = new SzAsyncTask(sz);
                        szasyncTask.execute("a");
                        Global.szStatus = 1;
                        //Global.turn++;
                       // Global.turn=Global.turn%2;
                    }
                }
            });*/
        green1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((Global.ran == 5 &&green1.getFlystutas() == 0 && Global.szStatus == 1)&&(Global.turn==1)) {
                    v.setX(42 * scale + 0.5f);
                    v.setY((float) (181 * scale * 1.08) + 0.5f); //乘以屏幕尺寸缩放比 暂适配小米2s
                    green1.setflystatus(1);
                    green1.setId(0);
                    green1.setcolor(2);
                    airport.green_airport[0].setStatus(1);
                    int k = green1.getId();
                    int p = 0;
                    if (k < 39) { k = k + 13;}
                    else{
                        if( k <= 48)
                            k  = k % 39;
                        else k = -1;
                    }
                    int j;
                    if(k != -1){
                        j = Move.pos[k].Getre();
                    }
                    else{
                        j = 0;
                    }
                    if(j!=2&&j!=0){
                        fcViewImageButton btn = Move.pos[k].getBtn();
                        int m = btn.getcolor();
                        int reX=0,reY=0;
                        /////
                        switch(m){
                            case 1: for(int i=0;i<4;i++){
                                if (airport.blue_airport[i].getStatus() == 1){
                                    reX = airport.blue_airport[i].GetX();
                                    reY = airport.blue_airport[i].GetY();
                                    airport.blue_airport[i].setStatus(0);
                                    break;
                                }
                            } break;
                            case 3:for(int i=0;i<4;i++){
                                if (airport.red_airport[i].getStatus() == 1){
                                    reX = airport.red_airport[i].GetX();
                                    reY = airport.red_airport[i].GetY();
                                    airport.red_airport[i].setStatus(0);
                                    break;
                                }
                            } break;
                            case 4:for(int i=0;i<4;i++){
                                if (airport.yellow_airport[i].getStatus() == 1){
                                    reX = airport.yellow_airport[i].GetX();
                                    reY = airport.yellow_airport[i].GetY();
                                    airport.yellow_airport[i].setStatus(0);
                                    break;
                                }
                            } break;
                        }
                        //////
                        int flyX,flyY;
                        flyX = Move.pos[k].GetX();
                        flyY = Move.pos[k].GetY();
                        fbAsyncTask fbasy = new fbAsyncTask(btn,flyX,flyY,reX,reY);
                        fbasy.execute("a");
                    }
                    if(k != -1){
                        Move.pos[k].setre(2);
                        Move.pos[k].setid((fcViewImageButton) findViewById(R.id.green1));
                    }

                } else if ((green1.getFlystutas() == 1 && Global.szStatus == 1)&&(Global.turn==1)&&green1.getFlyRoad()==0) {
                    int begin, end;
                    int k = green1.getId();
                    // int p = 0;
                    if (k < 39) { k =k+ 13;}
                    else{
                        if( k<= 48)
                            k = k % 39;
                        else k = -1;
                    }
                    int j;
                    if(k != -1){
                        j = Move.pos[k].Getre();
                    }
                    else{
                        j = 0;
                    }
                    begin = green1.getId();
                    green1.setId(Global.ran + 1);
                    end = green1.getId();
                    int m = 0;
                    if(end < 39){
                        k = end + 13;
                    }
                    else{
                        if(end <= 48){ k = end % 39;}
                        else { m = 1; }
                    }
                    fcViewImageButton btn1;
                    if(m == 0){
                        btn1= Move.pos[k].getBtn();}
                    else{ btn1 = null; }
                    mvAsyncTask mvasy = new mvAsyncTask(green1, begin, end,Move.greenpos,btn1,j,green1.getcolor(),k);
                    mvasy.execute("a");
                        /*if(!((Global.ran==5)||(lastValue==5))) {
                            Global.turn++;
                            Global.turn = Global.turn % 2;
                        }*/
                }
                Global.szStatus = 0;
            }
        });
        green2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((Global.ran == 5 && green2.getFlystutas() == 0 && Global.szStatus == 1)&&(Global.turn==1)) {
                    v.setX(42 * scale + 0.5f);
                    v.setY((float) (181 * scale * 1.08) + 0.5f); //乘以屏幕尺寸缩放比 暂适配小米2s
                    green2.setflystatus(1);
                    green2.setId(0);
                    green2.setcolor(2);
                    airport.green_airport[1].setStatus(1);
                    int k = green2.getId();
                    if (k < 39) { k += 13;}
                    else{
                        if( k<= 48)
                            k  = k % 39;
                        else k = -1;
                    }
                    int j;
                    if(k != -1){
                        j = Move.pos[k].Getre();
                    }
                    else{
                        j = 0;
                    }
                    if(j!=2&&j!=0){
                        fcViewImageButton btn = Move.pos[k].getBtn();
                        int m = btn.getcolor();
                        int reX=0,reY=0;
                        /////
                        switch(m){
                            case 1: for(int i=0;i<4;i++){
                                if (airport.blue_airport[i].getStatus() == 1){
                                    reX = airport.blue_airport[i].GetX();
                                    reY = airport.blue_airport[i].GetY();
                                    airport.blue_airport[i].setStatus(0);
                                    break;
                                }
                            } break;
                            case 3:for(int i=0;i<4;i++){
                                if (airport.red_airport[i].getStatus() == 1){
                                    reX = airport.red_airport[i].GetX();
                                    reY = airport.red_airport[i].GetY();
                                    airport.red_airport[i].setStatus(0);
                                    break;
                                }
                            } break;
                            case 4:for(int i=0;i<4;i++){
                                if (airport.yellow_airport[i].getStatus() == 1){
                                    reX = airport.yellow_airport[i].GetX();
                                    reY = airport.yellow_airport[i].GetY();
                                    airport.yellow_airport[i].setStatus(0);
                                    break;
                                }
                            } break;
                        }
                        int flyX,flyY;
                        flyX = Move.pos[k].GetX();
                        flyY = Move.pos[k].GetY();
                        fbAsyncTask fbasy = new fbAsyncTask(btn,flyX,flyY,reX,reY);
                        fbasy.execute("a");
                    }
                    if(k != -1){
                        Move.pos[k].setre(2);
                        Move.pos[k].setid((fcViewImageButton) findViewById(R.id.green2));
                    }

                } else if ((green2.getFlystutas() == 1 && Global.szStatus == 1)&&(Global.turn==1)&&green2.getFlyRoad()==0) {
                    int k = green2.getId();
                    if ( k < 39) { k += 13;}
                    else{
                        if( k <= 48)
                            k  = k % 39;
                        else k = -1;
                    }
                    int j;
                    if(k != -1){
                        j = Move.pos[k].Getre();
                    }
                    else{
                        j = 0;
                    }
                    int begin, end;
                    begin = green2.getId();
                    green2.setId(Global.ran + 1);
                    end = green2.getId();
                    int m = 0;
                    if(end < 39){
                        k = end + 13;
                    }
                    else{
                        if(end <= 48){ k = end % 39;}
                        else { m = 1; }
                    }
                    fcViewImageButton btn1;
                    if(m == 0){
                        btn1= Move.pos[k].getBtn();}
                    else{ btn1 = null; }
                    mvAsyncTask mvasy = new mvAsyncTask(green2, begin, end,Move.greenpos,btn1,j, green2.getcolor(),k);
                    mvasy.execute("a");
                }
                Global.szStatus = 0;
            }
        });
        green3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((Global.ran == 5 &&green3.getFlystutas() == 0 && Global.szStatus == 1)&&(Global.turn==1)) {
                    v.setX(42 * scale + 0.5f);
                    v.setY((float) (181 * scale * 1.08) + 0.5f); //乘以屏幕尺寸缩放比 暂适配小米2s
                    green3.setflystatus(1);
                    green3.setId(0);
                    green3.setcolor(2);
                    airport.green_airport[2].setStatus(1);
                    int k = green3.getId();
                    if (k < 39) { k += 13;}
                    else{
                        if( k<= 48)
                            k  = k % 39;
                        else k = -1;
                    }
                    int j;
                    if(k != -1){
                        j = Move.pos[k].Getre();
                    }
                    else{
                        j = 0;
                    }
                    if(j!=2&&j!=0){
                        fcViewImageButton btn = Move.pos[k].getBtn();
                        int m = btn.getcolor();
                        int reX=0,reY=0;
                        /////
                        switch(m){
                            case 1: for(int i=0;i<4;i++){
                                if (airport.blue_airport[i].getStatus() == 1){
                                    reX = airport.blue_airport[i].GetX();
                                    reY = airport.blue_airport[i].GetY();
                                    airport.blue_airport[i].setStatus(0);
                                    break;
                                }
                            } break;
                            case 3:for(int i=0;i<4;i++){
                                if (airport.red_airport[i].getStatus() == 1){
                                    reX = airport.red_airport[i].GetX();
                                    reY = airport.red_airport[i].GetY();
                                    airport.red_airport[i].setStatus(0);
                                    break;
                                }
                            } break;
                            case 4:for(int i=0;i<4;i++){
                                if (airport.yellow_airport[i].getStatus() == 1){
                                    reX = airport.yellow_airport[i].GetX();
                                    reY = airport.yellow_airport[i].GetY();
                                    airport.yellow_airport[i].setStatus(0);
                                    break;
                                }
                            } break;
                        }
                        //////
                        int flyX,flyY;
                        flyX = Move.pos[k].GetX();
                        flyY = Move.pos[k].GetY();
                        fbAsyncTask fbasy = new fbAsyncTask(btn,flyX,flyY,reX,reY);
                        fbasy.execute("a");
                    }
                    if(k != -1){
                        Move.pos[k].setre(2);
                        Move.pos[k].setid((fcViewImageButton) findViewById(R.id.green3));
                    }
                } else if ((green3.getFlystutas() == 1 && Global.szStatus == 1)&&(Global.turn==1)&&green3.getFlyRoad()==0) {
                    int k = green3.getId();
                    if ( k < 39) { k += 13;}
                    else{
                        if( k <= 48)
                            k  = k % 39;
                        else k = -1;
                    }
                    int j;
                    if(k != -1){
                        j = Move.pos[k].Getre();
                    }
                    else{
                        j = 0;
                    }
                    int begin, end;
                    begin = green3.getId();
                    green3.setId(Global.ran + 1);
                    end = green3.getId();
                    int m = 0;
                    if(end < 39){
                        k = end + 13;
                    }
                    else{
                        if(end <= 48){ k = end % 39;}
                        else { m = 1; }
                    }
                    fcViewImageButton btn1;
                    if(m == 0){
                        btn1= Move.pos[k].getBtn();}
                    else{ btn1 = null; }
                    mvAsyncTask mvasy = new mvAsyncTask(green3, begin, end,Move.greenpos,btn1,j, green3.getcolor(),k);
                    mvasy.execute("a");
                }
                Global.szStatus = 0;
            }
        });
        green4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((Global.ran == 5 && green4.getFlystutas() == 0 && Global.szStatus == 1)&&(Global.turn==1)) {
                    v.setX(42 * scale + 0.5f);
                    v.setY((float) (181 * scale * 1.08) + 0.5f); //乘以屏幕尺寸缩放比 暂适配小米2s
                    green4.setflystatus(1);
                    green4.setId(0);
                    green4.setcolor(2);
                    airport.green_airport[3].setStatus(1);
                    int k = green4.getId();
                    if (k < 39) { k += 13;}
                    else{
                        if( k<= 48)
                            k  = k % 39;
                        else k = -1;
                    }
                    int j;
                    if(k != -1){
                        j = Move.pos[k].Getre();
                    }
                    else{
                        j = 0;
                    }
                    if(j!=2&&j!=0){
                        fcViewImageButton btn = Move.pos[k].getBtn();
                        int m = btn.getcolor();
                        int reX=0,reY=0;
                        /////
                        switch(m){
                            case 1: for(int i=0;i<4;i++){
                                if (airport.blue_airport[i].getStatus() == 1){
                                    reX = airport.blue_airport[i].GetX();
                                    reY = airport.blue_airport[i].GetY();
                                    airport.blue_airport[i].setStatus(0);
                                    break;
                                }
                            } break;
                            case 3:for(int i=0;i<4;i++){
                                if (airport.red_airport[i].getStatus() == 1){
                                    reX = airport.red_airport[i].GetX();
                                    reY = airport.red_airport[i].GetY();
                                    airport.red_airport[i].setStatus(0);
                                    break;
                                }
                            } break;
                            case 4:for(int i=0;i<4;i++){
                                if (airport.yellow_airport[i].getStatus() == 1){
                                    reX = airport.yellow_airport[i].GetX();
                                    reY = airport.yellow_airport[i].GetY();
                                    airport.yellow_airport[i].setStatus(0);
                                    break;
                                }
                            } break;
                        }
                        //////
                        int flyX,flyY;
                        flyX = Move.pos[k].GetX();
                        flyY = Move.pos[k].GetY();
                        fbAsyncTask fbasy = new fbAsyncTask(btn,flyX,flyY,reX,reY);
                        fbasy.execute("a");
                    }
                    if(k != -1){
                        Move.pos[k].setre(2);
                        Move.pos[k].setid((fcViewImageButton) findViewById(R.id.green4));
                    }
                } else if ((green4.getFlystutas() == 1 && Global.szStatus == 1)&&(Global.turn==1)&&green4.getFlyRoad()==0) {
                    int k = green4.getId();
                    if ( k < 39) { k += 13;}
                    else{
                        if( k <= 48)
                            k  = k % 39;
                        else k = -1;
                    }
                    int j;
                    if(k != -1){
                        j = Move.pos[k].Getre();
                    }
                    else{
                        j = 0;
                    }
                    int begin, end;
                    begin = green4.getId();
                    green4.setId(Global.ran + 1);
                    end = green4.getId();
                    int m = 0;
                    if(end < 39){
                        k = end + 13;
                    }
                    else{
                        if(end <= 48){ k = end % 39;}
                        else { m = 1; }
                    }
                    fcViewImageButton btn1;
                    if(m == 0){
                        btn1= Move.pos[k].getBtn();}
                    else{ btn1 = null; }
                    mvAsyncTask mvasy = new mvAsyncTask(green4, begin, end,Move.greenpos,btn1,j, green4.getcolor(),k);
                    mvasy.execute("a");
                }
                Global.szStatus = 0;
            }
        });
        red1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((Global.ran == 5 && red1.getFlystutas() == 0 && Global.szStatus == 1)&&(Global.turn==2)) {
                    v.setX(244 * scale + 0.5f);
                    v.setY((float) (132 * scale * 1.08) + 0.5f); //乘以屏幕尺寸缩放比 暂适配小米2s
                    red1.setflystatus(1);
                    red1.setId(0);
                    red1.setcolor(3);
                    airport.red_airport[0].setStatus(1);
                    int k = red1.getId();
                    if (k < 26) { k += 26;}
                    else{
                        if( k<= 48)
                            k  = k - 26;
                        else k = -1;
                    }
                    int j;
                    if(k != -1){
                        j = Move.pos[k].Getre();
                    }
                    else{
                        j = 0;
                    }
                    if(j!=3&&j!=0){
                        fcViewImageButton btn = Move.pos[k].getBtn();
                        int m = btn.getcolor();
                        int reX=0,reY=0;
                        /////
                        switch(m){
                            case 1: for(int i=0;i<4;i++){
                                if (airport.blue_airport[i].getStatus() == 1){
                                    reX = airport.blue_airport[i].GetX();
                                    reY = airport.blue_airport[i].GetY();
                                    airport.blue_airport[i].setStatus(0);
                                    break;
                                }
                            } break;
                            case 2:for(int i=0;i<4;i++){
                                if (airport.green_airport[i].getStatus() == 1){
                                    reX = airport.green_airport[i].GetX();
                                    reY = airport.green_airport[i].GetY();
                                    airport.green_airport[i].setStatus(0);
                                    break;
                                }
                            } break;
                            case 4:for(int i=0;i<4;i++){
                                if (airport.yellow_airport[i].getStatus() == 1){
                                    reX = airport.yellow_airport[i].GetX();
                                    reY = airport.yellow_airport[i].GetY();
                                    airport.yellow_airport[i].setStatus(0);
                                    break;
                                }
                            } break;
                        }
                        //////
                        int flyX,flyY;
                        flyX = Move.pos[k].GetX();
                        flyY = Move.pos[k].GetY();
                        fbAsyncTask fbasy = new fbAsyncTask(btn,flyX,flyY,reX,reY);
                        fbasy.execute("a");
                    }
                    if(k != -1){
                        Move.pos[k].setre(3);
                        Move.pos[k].setid((fcViewImageButton) findViewById(R.id.red1));
                    }
                } else if ((red1.getFlystutas() == 1 && Global.szStatus == 1)&&(Global.turn==2)&&red1.getFlyRoad()==0) {
                    int k = red1.getId();
                    if ( k < 26) { k += 26;}
                    else{
                        if( k <= 48)
                            k  = k -26;
                        else k = -1;
                    }
                    int j;
                    if(k != -1){
                        j = Move.pos[k].Getre();
                    }
                    else{
                        j = 0;
                    }
                    int begin, end;
                    begin = red1.getId();
                    red1.setId(Global.ran + 1);
                    end = red1.getId();
                    int m = 0;
                    if(end < 26){
                        k = end + 26;
                    }
                    else{
                        if(end <= 48){ k = end - 26;}
                        else { m = 1; }
                    }
                    fcViewImageButton btn1;
                    if(m == 0){
                        btn1= Move.pos[k].getBtn();}
                    else{ btn1 = null; }
                    mvAsyncTask mvasy = new mvAsyncTask(red1, begin, end,Move.redpos,btn1,j, red1.getcolor(),k);
                    mvasy.execute("a");
                }
                Global.szStatus = 0;
            }
        });
        red2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((Global.ran == 5 && red2.getFlystutas() == 0 && Global.szStatus == 1)&&(Global.turn==2)) {
                    v.setX(244 * scale + 0.5f);
                    v.setY((float) (132 * scale * 1.08) + 0.5f); //乘以屏幕尺寸缩放比 暂适配小米2s
                    red2.setflystatus(1);
                    red2.setId(0);
                    red2.setcolor(3);
                    airport.red_airport[1].setStatus(1);
                    int k = red2.getId();
                    if (k < 26) { k += 26;}
                    else{
                        if( k<= 48)
                            k  = k - 26;
                        else k = -1;
                    }
                    int j;
                    if(k != -1){
                        j = Move.pos[k].Getre();
                    }
                    else{
                        j = 0;
                    }
                    if(j!=3&&j!=0){
                        fcViewImageButton btn = Move.pos[k].getBtn();
                        int m = btn.getcolor();
                        int reX=0,reY=0;
                        /////
                        switch(m){
                            case 1: for(int i=0;i<4;i++){
                                if (airport.blue_airport[i].getStatus() == 1){
                                    reX = airport.blue_airport[i].GetX();
                                    reY = airport.blue_airport[i].GetY();
                                    airport.blue_airport[i].setStatus(0);
                                    break;
                                }
                            } break;
                            case 2:for(int i=0;i<4;i++){
                                if (airport.green_airport[i].getStatus() == 1){
                                    reX = airport.green_airport[i].GetX();
                                    reY = airport.green_airport[i].GetY();
                                    airport.green_airport[i].setStatus(0);
                                    break;
                                }
                            } break;
                            case 4:for(int i=0;i<4;i++){
                                if (airport.yellow_airport[i].getStatus() == 1){
                                    reX = airport.yellow_airport[i].GetX();
                                    reY = airport.yellow_airport[i].GetY();
                                    airport.yellow_airport[i].setStatus(0);
                                    break;
                                }
                            } break;
                        }
                        //////
                        int flyX,flyY;
                        flyX = Move.pos[k].GetX();
                        flyY = Move.pos[k].GetY();
                        fbAsyncTask fbasy = new fbAsyncTask(btn,flyX,flyY,reX,reY);
                        fbasy.execute("a");
                    }
                    if(k != -1){
                        Move.pos[k].setre(3);
                        Move.pos[k].setid((fcViewImageButton) findViewById(R.id.red2));
                    }
                } else if ((red2.getFlystutas() == 1 && Global.szStatus == 1)&&(Global.turn==2)&&red2.getFlyRoad()==0) {
                    int k = red2.getId();
                    if ( k < 26) { k += 26;}
                    else{
                        if( k <= 48)
                            k  = k -26;
                        else k = -1;
                    }
                    int j;
                    if(k != -1){
                        j = Move.pos[k].Getre();
                    }
                    else{
                        j = 0;
                    }
                    int begin, end;
                    begin = red2.getId();
                    red2.setId(Global.ran + 1);
                    end = red2.getId();
                    int m = 0;
                    if(end < 26){
                        k = end + 26;
                    }
                    else{
                        if(end <= 48){ k = end - 26;}
                        else { m = 1; }
                    }
                    fcViewImageButton btn1;
                    if(m == 0){
                        btn1= Move.pos[k].getBtn();}
                    else{ btn1 = null; }
                    mvAsyncTask mvasy = new mvAsyncTask(red2, begin, end,Move.redpos,btn1,j, red2.getcolor(),k);
                    mvasy.execute("a");
                }
                Global.szStatus = 0;
            }
        });
///////////////////////////
        red3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((Global.ran == 5 && red3.getFlystutas() == 0 && Global.szStatus == 1)&&(Global.turn==2)) {
                    v.setX(244 * scale + 0.5f);
                    v.setY((float) (132 * scale * 1.08) + 0.5f); //乘以屏幕尺寸缩放比 暂适配小米2s
                    red3.setflystatus(1);
                    red3.setId(0);
                    red3.setcolor(3);
                    airport.red_airport[2].setStatus(1);
                    int k = red3.getId();
                    if (k < 26) { k += 26;}
                    else{
                        if( k<= 48)
                            k  = k - 26;
                        else k = -1;
                    }
                    int j;
                    if(k != -1){
                        j = Move.pos[k].Getre();
                    }
                    else{
                        j = 0;
                    }
                    if(j!=3&&j!=0){
                        fcViewImageButton btn = Move.pos[k].getBtn();
                        int m = btn.getcolor();
                        int reX=0,reY=0;
                        /////
                        switch(m){
                            case 1: for(int i=0;i<4;i++){
                                if (airport.blue_airport[i].getStatus() == 1){
                                    reX = airport.blue_airport[i].GetX();
                                    reY = airport.blue_airport[i].GetY();
                                    airport.blue_airport[i].setStatus(0);
                                    break;
                                }
                            } break;
                            case 2:for(int i=0;i<4;i++){
                                if (airport.green_airport[i].getStatus() == 1){
                                    reX = airport.green_airport[i].GetX();
                                    reY = airport.green_airport[i].GetY();
                                    airport.green_airport[i].setStatus(0);
                                    break;
                                }
                            } break;
                            case 4:for(int i=0;i<4;i++){
                                if (airport.yellow_airport[i].getStatus() == 1){
                                    reX = airport.yellow_airport[i].GetX();
                                    reY = airport.yellow_airport[i].GetY();
                                    airport.yellow_airport[i].setStatus(0);
                                    break;
                                }
                            } break;
                        }
                        //////
                        int flyX,flyY;
                        flyX = Move.pos[k].GetX();
                        flyY = Move.pos[k].GetY();
                        fbAsyncTask fbasy = new fbAsyncTask(btn,flyX,flyY,reX,reY);
                        fbasy.execute("a");
                    }
                    if(k != -1){
                        Move.pos[k].setre(3);
                        Move.pos[k].setid((fcViewImageButton) findViewById(R.id.red3));
                    }
                } else if ((red3.getFlystutas() == 1 && Global.szStatus == 1)&&(Global.turn==2)&&red3.getFlyRoad()==0) {
                    int k = red3.getId();
                    if ( k < 26) { k += 26;}
                    else{
                        if( k <= 48)
                            k  = k -26;
                        else k = -1;
                    }
                    int j;
                    if(k != -1){
                        j = Move.pos[k].Getre();
                    }
                    else{
                        j = 0;
                    }
                    int begin, end;
                    begin = red3.getId();
                    red3.setId(Global.ran + 1);
                    end = red3.getId();
                    int m = 0;
                    if(end < 26){
                        k = end + 26;
                    }
                    else{
                        if(end <= 48){ k = end - 26;}
                        else { m = 1; }
                    }
                    fcViewImageButton btn1;
                    if(m == 0){
                        btn1= Move.pos[k].getBtn();}
                    else{ btn1 = null; }
                    mvAsyncTask mvasy = new mvAsyncTask(red3, begin, end,Move.redpos,btn1,j, red3.getcolor(),k);
                    mvasy.execute("a");
                }
                Global.szStatus = 0;
            }
        });

        red4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((Global.ran == 5 && red4.getFlystutas() == 0 && Global.szStatus == 1)&&(Global.turn==2)) {
                    v.setX(244 * scale + 0.5f);
                    v.setY((float) (132 * scale * 1.08) + 0.5f); //乘以屏幕尺寸缩放比 暂适配小米2s
                    red4.setflystatus(1);
                    red4.setId(0);
                    red4.setcolor(3);
                    airport.red_airport[3].setStatus(1);
                    int k = red4.getId();
                    if (k < 26) { k += 26;}
                    else{
                        if( k<= 48)
                            k  = k - 26;
                        else k = -1;
                    }
                    int j;
                    if(k != -1){
                        j = Move.pos[k].Getre();
                    }
                    else{
                        j = 0;
                    }
                    if(j!=3&&j!=0){
                        fcViewImageButton btn = Move.pos[k].getBtn();
                        int m = btn.getcolor();
                        int reX=0,reY=0;
                        /////
                        switch(m){
                            case 1: for(int i=0;i<4;i++){
                                if (airport.blue_airport[i].getStatus() == 1){
                                    reX = airport.blue_airport[i].GetX();
                                    reY = airport.blue_airport[i].GetY();
                                    airport.blue_airport[i].setStatus(0);
                                    break;
                                }
                            } break;
                            case 2:for(int i=0;i<4;i++){
                                if (airport.green_airport[i].getStatus() == 1){
                                    reX = airport.green_airport[i].GetX();
                                    reY = airport.green_airport[i].GetY();
                                    airport.green_airport[i].setStatus(0);
                                    break;
                                }
                            } break;
                            case 4:for(int i=0;i<4;i++){
                                if (airport.yellow_airport[i].getStatus() == 1){
                                    reX = airport.yellow_airport[i].GetX();
                                    reY = airport.yellow_airport[i].GetY();
                                    airport.yellow_airport[i].setStatus(0);
                                    break;
                                }
                            } break;
                        }
                        //////
                        int flyX,flyY;
                        flyX = Move.pos[k].GetX();
                        flyY = Move.pos[k].GetY();
                        fbAsyncTask fbasy = new fbAsyncTask(btn,flyX,flyY,reX,reY);
                        fbasy.execute("a");
                    }
                    if(k != -1){
                        Move.pos[k].setre(3);
                        Move.pos[k].setid((fcViewImageButton) findViewById(R.id.red4));
                    }
                } else if ((red4.getFlystutas() == 1 && Global.szStatus == 1)&&(Global.turn==2)&&red4.getFlyRoad()==0) {
                    int k = red4.getId();
                    if ( k < 26) { k += 26;}
                    else{
                        if( k <= 48)
                            k  = k -26;
                        else k = -1;
                    }
                    int j;
                    if(k != -1){
                        j = Move.pos[k].Getre();
                    }
                    else{
                        j = 0;
                    }
                    int begin, end;
                    begin = red4.getId();
                    red4.setId(Global.ran + 1);
                    end = red4.getId();
                    int m = 0;
                    if(end < 26){
                        k = end + 26;
                    }
                    else{
                        if(end <= 48){ k = end - 26;}
                        else { m = 1; }
                    }
                    fcViewImageButton btn1;
                    if(m == 0){
                        btn1= Move.pos[k].getBtn();}
                    else{ btn1 = null; }
                    mvAsyncTask mvasy = new mvAsyncTask(red4, begin, end,Move.redpos,btn1,j, red4.getcolor(),k);
                    mvasy.execute("a");
                }
                Global.szStatus = 0;
            }
        });

        yellow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((Global.ran == 5 &&yellow1.getFlystutas() == 0 && Global.szStatus == 1)&&(Global.turn==3)) {
                    v.setX(297 * scale + 0.5f);
                    v.setY((float) (332 * scale * 1.08) + 0.5f); //乘以屏幕尺寸缩放比 暂适配小米2s
                    yellow1.setflystatus(1);
                    yellow1.setId(0);
                    yellow1.setcolor(4);
                    airport.yellow_airport[0].setStatus(1);
                    int k = yellow1.getId();
                    if (k < 13) { k += 39;}
                    else{
                        if( k<= 48)
                            k  = k - 13;
                        else k = -1;
                    }
                    int j = 0;
                    if(k != -1){
                        j = Move.pos[k].Getre();
                    }
                    else{
                        j = 0;
                    }
                    if(j!=4&&j!=0){
                        fcViewImageButton btn = Move.pos[k].getBtn();
                        int m = btn.getcolor();
                        int reX=0,reY=0;
                        /////
                        switch(m){
                            case 1: for(int i=0;i<4;i++){
                                if (airport.blue_airport[i].getStatus() == 1){
                                    reX = airport.blue_airport[i].GetX();
                                    reY = airport.blue_airport[i].GetY();
                                    airport.blue_airport[i].setStatus(0);
                                    break;
                                }
                            } break;
                            case 2:for(int i=0;i<4;i++){
                                if (airport.green_airport[i].getStatus() == 1){
                                    reX = airport.green_airport[i].GetX();
                                    reY = airport.green_airport[i].GetY();
                                    airport.green_airport[i].setStatus(0);
                                    break;
                                }
                            } break;
                            case 3:for(int i=0;i<4;i++){
                                if (airport.red_airport[i].getStatus() == 1){
                                    reX = airport.red_airport[i].GetX();
                                    reY = airport.red_airport[i].GetY();
                                    airport.red_airport[i].setStatus(0);
                                    break;
                                }
                            } break;
                        }
                        //////
                        int flyX,flyY;
                        flyX = Move.pos[k].GetX();
                        flyY = Move.pos[k].GetY();
                        fbAsyncTask fbasy = new fbAsyncTask(btn,flyX,flyY,reX,reY);
                        fbasy.execute("a");
                    }
                    if(k != -1){
                        Move.pos[k].setre(4);
                        Move.pos[k].setid((fcViewImageButton) findViewById(R.id.yellow1));
                    }
                } else if ((yellow1.getFlystutas() == 1 && Global.szStatus == 1)&&(Global.turn==3)&&yellow1.getFlyRoad()==0) {
                    int k = yellow1.getId();
                    if ( k < 13) { k += 39;}
                    else{
                        if( k <= 48)
                            k  = k - 13;
                        else k = -1;
                    }
                    int j;
                    if(k != -1){
                        j = Move.pos[k].Getre();
                    }
                    else{
                        j = 0;
                    }
                    int begin, end;
                    begin = yellow1.getId();
                    yellow1.setId(Global.ran + 1);
                    end = yellow1.getId();
                    int m = 0;
                    if(end < 13){
                        k = end + 39;
                    }
                    else{
                        if(end <= 48){ k = end - 13;}
                        else { m = 1; }
                    }
                    fcViewImageButton btn1;
                    if(m == 0){
                        btn1= Move.pos[k].getBtn();}
                    else{ btn1 = null; }
                    mvAsyncTask mvasy = new mvAsyncTask(yellow1, begin, end,Move.yellowpos,btn1,j, yellow1.getcolor(),k);
                    mvasy.execute("a");
                }
                Global.szStatus = 0;
            }
        });

        yellow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((Global.ran == 5 &&yellow2.getFlystutas() == 0 && Global.szStatus == 1)&&(Global.turn==3)) {
                    v.setX(297 * scale + 0.5f);
                    v.setY((float) (332 * scale * 1.08) + 0.5f); //乘以屏幕尺寸缩放比 暂适配小米2s
                    yellow2.setflystatus(1);
                    yellow2.setId(0);
                    yellow2.setcolor(4);
                    airport.yellow_airport[1].setStatus(1);
                    int k = yellow2.getId();
                    if (k < 13) { k += 39;}
                    else{
                        if( k<= 48)
                            k  = k - 13;
                        else k = -1;
                    }
                    int j;
                    if(k != -1){
                        j = Move.pos[k].Getre();
                    }
                    else{
                        j = 0;
                    }
                    if(j!=4&&j!=0){
                        fcViewImageButton btn = Move.pos[k].getBtn();
                        int m = btn.getcolor();
                        int reX=0,reY=0;
                        /////
                        switch(m){
                            case 1: for(int i=0;i<4;i++){
                                if (airport.blue_airport[i].getStatus() == 1){
                                    reX = airport.blue_airport[i].GetX();
                                    reY = airport.blue_airport[i].GetY();
                                    airport.blue_airport[i].setStatus(0);
                                    break;
                                }
                            } break;
                            case 2:for(int i=0;i<4;i++){
                                if (airport.green_airport[i].getStatus() == 1){
                                    reX = airport.green_airport[i].GetX();
                                    reY = airport.green_airport[i].GetY();
                                    airport.green_airport[i].setStatus(0);
                                    break;
                                }
                            } break;
                            case 3:for(int i=0;i<4;i++){
                                if (airport.red_airport[i].getStatus() == 1){
                                    reX = airport.red_airport[i].GetX();
                                    reY = airport.red_airport[i].GetY();
                                    airport.red_airport[i].setStatus(0);
                                    break;
                                }
                            } break;
                        }
                        //////
                        int flyX,flyY;
                        flyX = Move.pos[k].GetX();
                        flyY = Move.pos[k].GetY();
                        fbAsyncTask fbasy = new fbAsyncTask(btn,flyX,flyY,reX,reY);
                        fbasy.execute("a");
                    }
                    if(k != -1){
                        Move.pos[k].setre(4);
                        Move.pos[k].setid((fcViewImageButton) findViewById(R.id.yellow2));
                    }
                } else if ((yellow2.getFlystutas() == 1 && Global.szStatus == 1)&&(Global.turn==3)&&yellow2.getFlyRoad()==0) {
                    int k = yellow2.getId();
                    if ( k < 13) { k += 39;}
                    else{
                        if( k <= 48)
                            k  = k -13;
                        else k = -1;
                    }
                    int j;
                    if(k != -1){
                        j = Move.pos[k].Getre();
                    }
                    else{
                        j = 0;
                    }
                    int begin, end;
                    begin = yellow2.getId();
                    yellow2.setId(Global.ran + 1);
                    end = yellow2.getId();
                    int m = 0;
                    if(end < 13){
                        k = end + 39;
                    }
                    else{
                        if(end <= 48){ k = end - 13;}
                        else { m = 1; }
                    }
                    fcViewImageButton btn1;
                    if(m == 0){
                        btn1= Move.pos[k].getBtn();}
                    else{ btn1 = null; }
                    mvAsyncTask mvasy = new mvAsyncTask(yellow2, begin, end,Move.yellowpos,btn1,j, yellow2.getcolor(),k);
                    mvasy.execute("a");
                }
                Global.szStatus = 0;
            }
        });

        yellow3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((Global.ran == 5 &&yellow3.getFlystutas() == 0 && Global.szStatus == 1)&&(Global.turn==3)) {
                    v.setX(297 * scale + 0.5f);
                    v.setY((float) (332 * scale * 1.08) + 0.5f); //乘以屏幕尺寸缩放比 暂适配小米2s
                    yellow3.setflystatus(1);
                    yellow3.setId(0);
                    yellow3.setcolor(4);
                    airport.yellow_airport[2].setStatus(1);
                    int k = yellow3.getId();
                    if (k < 13) { k += 39;}
                    else{
                        if( k<= 48)
                            k  = k - 13;
                        else k = -1;
                    }
                    int j;
                    if(k != -1){
                        j = Move.pos[k].Getre();
                    }
                    else{
                        j = 0;
                    }
                    if(j!=4&&j!=0){
                        fcViewImageButton btn = Move.pos[k].getBtn();
                        int m = btn.getcolor();
                        int reX=0,reY=0;
                        /////
                        switch(m){
                            case 1: for(int i=0;i<4;i++){
                                if (airport.blue_airport[i].getStatus() == 1){
                                    reX = airport.blue_airport[i].GetX();
                                    reY = airport.blue_airport[i].GetY();
                                    airport.blue_airport[i].setStatus(0);
                                    break;
                                }
                            } break;
                            case 2:for(int i=0;i<4;i++){
                                if (airport.green_airport[i].getStatus() == 1){
                                    reX = airport.green_airport[i].GetX();
                                    reY = airport.green_airport[i].GetY();
                                    airport.green_airport[i].setStatus(0);
                                    break;
                                }
                            } break;
                            case 3:for(int i=0;i<4;i++){
                                if (airport.red_airport[i].getStatus() == 1){
                                    reX = airport.red_airport[i].GetX();
                                    reY = airport.red_airport[i].GetY();
                                    airport.red_airport[i].setStatus(0);
                                    break;
                                }
                            } break;
                        }
                        //////
                        int flyX,flyY;
                        flyX = Move.pos[k].GetX();
                        flyY = Move.pos[k].GetY();
                        fbAsyncTask fbasy = new fbAsyncTask(btn,flyX,flyY,reX,reY);
                        fbasy.execute("a");
                    }
                    if(k != -1){
                        Move.pos[k].setre(4);
                        Move.pos[k].setid((fcViewImageButton) findViewById(R.id.yellow3));
                    }
                } else if ((yellow3.getFlystutas() == 1 && Global.szStatus == 1)&&(Global.turn==3)&&yellow3.getFlyRoad()==0) {
                    int k = yellow3.getId();
                    if ( k < 13) { k += 39;}
                    else{
                        if( k <= 48)
                            k  = k -13;
                        else k = -1;
                    }
                    int j;
                    if(k != -1){
                        j = Move.pos[k].Getre();
                    }
                    else{
                        j = 0;
                    }
                    int begin, end;
                    begin = yellow3.getId();
                    yellow3.setId(Global.ran + 1);
                    end = yellow3.getId();
                    int m = 0;
                    if(end < 13){
                        k = end + 39;
                    }
                    else{
                        if(end <= 48){ k = end - 13;}
                        else { m = 1; }
                    }
                    fcViewImageButton btn1;
                    if(m == 0){
                        btn1= Move.pos[k].getBtn();}
                    else{ btn1 = null; }
                    mvAsyncTask mvasy = new mvAsyncTask(yellow3, begin, end,Move.yellowpos,btn1,j, yellow3.getcolor(),k);
                    mvasy.execute("a");
                }
                Global.szStatus = 0;
            }
        });

        yellow4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((/*Global.ran == 5 &&*/yellow4.getFlystutas() == 0 && Global.szStatus == 1)&&(Global.turn==3)) {
                    v.setX(297 * scale + 0.5f);
                    v.setY((float) (332 * scale * 1.08) + 0.5f); //乘以屏幕尺寸缩放比 暂适配小米2s
                    yellow4.setflystatus(1);
                    yellow4.setId(0);
                    yellow4.setcolor(4);
                    airport.yellow_airport[3].setStatus(1);
                    int k = yellow4.getId();
                    if (k < 13) { k += 39;}
                    else{
                        if( k<= 48)
                            k  = k - 13;
                        else k = -1;
                    }
                    int j;
                    if(k != -1){
                        j = Move.pos[k].Getre();
                    }
                    else{
                        j = 0;
                    }
                    if(j!=4&&j!=0){
                        fcViewImageButton btn = Move.pos[k].getBtn();
                        int m = btn.getcolor();
                        int reX=0,reY=0;
                        /////
                        switch(m){
                            case 1: for(int i=0;i<4;i++){
                                if (airport.blue_airport[i].getStatus() == 1){
                                    reX = airport.blue_airport[i].GetX();
                                    reY = airport.blue_airport[i].GetY();
                                    airport.blue_airport[i].setStatus(0);
                                    break;
                                }
                            } break;
                            case 2:for(int i=0;i<4;i++){
                                if (airport.green_airport[i].getStatus() == 1){
                                    reX = airport.green_airport[i].GetX();
                                    reY = airport.green_airport[i].GetY();
                                    airport.green_airport[i].setStatus(0);
                                    break;
                                }
                            } break;
                            case 3:for(int i=0;i<4;i++){
                                if (airport.red_airport[i].getStatus() == 1){
                                    reX = airport.red_airport[i].GetX();
                                    reY = airport.red_airport[i].GetY();
                                    airport.red_airport[i].setStatus(0);
                                    break;
                                }
                            } break;
                        }
                        //////
                        int flyX,flyY;
                        flyX = Move.pos[k].GetX();
                        flyY = Move.pos[k].GetY();
                        fbAsyncTask fbasy = new fbAsyncTask(btn,flyX,flyY,reX,reY);
                        fbasy.execute("a");
                    }
                    if(k != -1){
                        Move.pos[k].setre(4);
                        Move.pos[k].setid((fcViewImageButton) findViewById(R.id.yellow4));
                    }
                } else if ((yellow4.getFlystutas() == 1 && Global.szStatus == 1)&&(Global.turn==3)&&yellow4.getFlyRoad()==0) {
                    int k = yellow4.getId();
                    if ( k < 13) { k += 39;}
                    else{
                        if( k <= 48)
                            k  = k -13;
                        else k = -1;
                    }
                    int j;
                    if(k != -1){
                        j = Move.pos[k].Getre();
                    }
                    else{
                        j = 0;
                    }
                    int begin, end;
                    begin = yellow4.getId();
                    yellow4.setId(Global.ran + 1);
                    //yellow4.setId(13);
                    end = yellow4.getId();
                    int m = 0;
                    if(end < 13){
                        k = end + 39;
                    }
                    else{
                        if(end <= 48){ k = end - 13;}
                        else { m = 1; }
                    }
                    fcViewImageButton btn1;
                    if(m == 0){
                        btn1= Move.pos[k].getBtn();}
                    else{ btn1 = null; }
                    mvAsyncTask mvasy = new mvAsyncTask(yellow4, begin, end,Move.yellowpos,btn1,j, yellow4.getcolor(),k);
                    mvasy.execute("a");
                }
                Global.szStatus = 0;
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
    private int flyRoad=0;
    private int isNew=0;
    private int direction=0;
    private int color;
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
    public void initid(){ CurrentId = 0;}
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
    public void setFlyroad(int a){
        flyRoad=a;
    }
    public int getFlyRoad(){
        return flyRoad;
    }
    public void setNew(int m){
        this.isNew=m;
    }
    public int getNew(){
        return isNew;
    }
    public void setDirection(int n){
        this.direction=n;
    }
    public int getDirection(){
        return this.direction;
    }
    public void setcolor(int color){ this.color = color;}
    public int getcolor(){return color;}
}

