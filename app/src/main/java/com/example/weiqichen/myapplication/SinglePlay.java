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
                        if(!((Global.ran==5)||(lastValue==5))) {
                            Global.turn++;
                            Global.turn = Global.turn % 4;
                        }
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
                    } else if ((Global.turn==0)&&(blue1.getFlystutas() == 1 && Global.szStatus == 1)&& blue1.getFlyRoad()==0) {
                        int begin, end;
                        begin = blue1.getId();
                            blue1.setId(Global.ran + 1);
                            end = blue1.getId();
                            mvAsyncTask mvasy = new mvAsyncTask(blue1, begin, end,Move.bluepos);
                            mvasy.execute("a");
                        /*if(!((Global.ran==5)||(lastValue==5))) {
                            Global.turn++;
                            Global.turn = Global.turn % 2;
                        }*/
                    }
                    Global.szStatus = 0;
                }
            });
            blue2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if ((Global.turn==0)&&(Global.ran == 5 && blue2.getFlystutas() == 0 && Global.szStatus == 1)) {
                        v.setX(95 * scale + 0.5f);
                        v.setY((float) (387 * scale * 1.08) + 0.5f); //乘以屏幕尺寸缩放比 暂适配小米2s
                        blue2.setflystatus(1);
                        blue2.setId(0);
                    } else if  ((Global.turn==0)&&(blue2.getFlystutas() == 1 && Global.szStatus == 1)&&blue2.getFlyRoad()==0) {
                        int begin, end;
                        begin = blue2.getId();
                        blue2.setId(Global.ran + 1);
                        end = blue2.getId();
                        mvAsyncTask mvasy = new mvAsyncTask(blue2, begin, end,Move.bluepos);
                        mvasy.execute("a");
                        /*if(!((Global.ran==5)||(lastValue==5))) {
                            Global.turn++;
                            Global.turn = Global.turn % 2;
                        }*/
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
                    } else if ((Global.turn==0)&&(blue3.getFlystutas() == 1 && Global.szStatus == 1)&&blue3.getFlyRoad()==0) {
                        int begin, end;
                        begin = blue3.getId();
                        blue3.setId(Global.ran + 1);
                        end = blue3.getId();
                        mvAsyncTask mvasy = new mvAsyncTask(blue3, begin, end,Move.bluepos);
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
                    if  ((Global.turn==0)&&(Global.ran == 5 && blue4.getFlystutas() == 0 && Global.szStatus == 1)) {
                        v.setX(95 * scale + 0.5f);
                        v.setY((float) (387 * scale * 1.08) + 0.5f); //乘以屏幕尺寸缩放比 暂适配小米2s
                        blue4.setflystatus(1);
                        blue4.setId(0);
                    } else if ((Global.turn==0)&&(blue4.getFlystutas() == 1 && Global.szStatus == 1)&&blue4.getFlyRoad()==0) {
                        //float startX,startY,endX,endY;
                        int begin, end;
                        begin = blue4.getId();
                        blue4.setId(Global.ran + 1);
                        end = blue4.getId();
                        mvAsyncTask mvasy = new mvAsyncTask(blue4, begin, end,Move.bluepos);
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
                    if((Global.ran == 5 && green1.getFlystutas() == 0 && Global.szStatus == 1)&&(Global.turn==1)) {
                        v.setX(42 * scale + 0.5f);
                        v.setY((float) (181 * scale * 1.08) + 0.5f); //乘以屏幕尺寸缩放比 暂适配小米2s
                        green1.setflystatus(1);
                        green1.setId(0);
                    } else if ((green1.getFlystutas() == 1 && Global.szStatus == 1)&&(Global.turn==1)&&green1.getFlyRoad()==0) {
                        int begin, end;
                        begin = green1.getId();
                        green1.setId(Global.ran + 1);
                        end = green1.getId();
                        mvAsyncTask mvasy = new mvAsyncTask(green1, begin, end,Move.greenpos);
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
                    } else if ((green2.getFlystutas() == 1 && Global.szStatus == 1)&&(Global.turn==1)&&green2.getFlyRoad()==0) {
                        int begin, end;
                        begin = green2.getId();
                        green2.setId(Global.ran + 1);
                        end = green2.getId();
                        mvAsyncTask mvasy = new mvAsyncTask(green2, begin, end,Move.greenpos);
                        mvasy.execute("a");
                        /*if(!((Global.ran==5)||(lastValue==5))) {
                            Global.turn++;
                            Global.turn = Global.turn % 2;
                        }*/
                    }
                    Global.szStatus = 0;
                }
            });
            green3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if ((Global.ran == 5 && green3.getFlystutas() == 0 && Global.szStatus == 1)&&(Global.turn==1)) {
                        v.setX(42 * scale + 0.5f);
                        v.setY((float) (181 * scale * 1.08) + 0.5f); //乘以屏幕尺寸缩放比 暂适配小米2s
                        green3.setflystatus(1);
                        green3.setId(0);
                    } else if ((green3.getFlystutas() == 1 && Global.szStatus == 1)&&(Global.turn==1)&&green3.getFlyRoad()==0) {
                        int begin, end;
                        begin = green3.getId();
                        green3.setId(Global.ran + 1);
                        end = green3.getId();
                        mvAsyncTask mvasy = new mvAsyncTask(green3, begin, end,Move.greenpos);
                        mvasy.execute("a");
                        /*if(!((Global.ran==5)||(lastValue==5))) {
                            Global.turn++;
                            Global.turn = Global.turn % 2;
                        }*/
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
                    } else if ((green4.getFlystutas() == 1 && Global.szStatus == 1)&&(Global.turn==1)&&green4.getFlyRoad()==0) {
                        //float startX,startY,endX,endY;
                        int begin, end;
                        begin = green4.getId();
                        green4.setId(Global.ran + 1);
                        end = green4.getId();
                        mvAsyncTask mvasy = new mvAsyncTask(green4, begin, end,Move.greenpos);
                        mvasy.execute("a");
                        /*if(!((Global.ran==5)||(lastValue==5))) {
                            Global.turn++;
                            Global.turn = Global.turn % 2;
                        }*/
                    }
                    Global.szStatus = 0;
                }
            });
        red1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((Global.turn==2)&&(Global.ran == 5 && red1.getFlystutas() == 0 && Global.szStatus == 1)) {
                    v.setX(244 * scale + 0.5f);
                    v.setY((float) (132 * scale * 1.08) + 0.5f); //乘以屏幕尺寸缩放比 暂适配小米2s
                    red1.setflystatus(1);
                    red1.setId(0);
                } else if ((Global.turn==2)&&(red1.getFlystutas() == 1 && Global.szStatus == 1)&&red1.getFlyRoad()==0) {
                    int begin, end;
                    begin = red1.getId();
                    red1.setId(Global.ran + 1);
                    end = red1.getId();
                    mvAsyncTask mvasy = new mvAsyncTask(red1, begin, end,Move.redpos);
                    mvasy.execute("a");
                        /*if(!((Global.ran==5)||(lastValue==5))) {
                            Global.turn++;
                            Global.turn = Global.turn % 2;
                        }*/
                }
                Global.szStatus = 0;
            }
        });
        red2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((Global.turn == 2) && (Global.ran == 5 && red2.getFlystutas() == 0 && Global.szStatus == 1)) {
                    v.setX(244 * scale + 0.5f);
                    v.setY((float) (132 * scale * 1.08) + 0.5f); //乘以屏幕尺寸缩放比 暂适配小米2s
                    red2.setflystatus(1);
                    red2.setId(0);
                } else if ((Global.turn == 2) && (red2.getFlystutas() == 1 && Global.szStatus == 1)&&red2.getFlyRoad()==0) {
                    int begin, end;
                    begin = red2.getId();
                    red2.setId(Global.ran + 1);
                    end = red2.getId();
                    mvAsyncTask mvasy = new mvAsyncTask(red2, begin, end,Move.redpos);
                    mvasy.execute("a");
                        /*if(!((Global.ran==5)||(lastValue==5))) {
                            Global.turn++;
                            Global.turn = Global.turn % 2;
                        }*/
                }
                Global.szStatus = 0;
            }
        });
        red3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if  ((Global.turn==2)&&(Global.ran == 5 && red3.getFlystutas() == 0 && Global.szStatus == 1)) {
                    v.setX(244 * scale + 0.5f);
                    v.setY((float) (132 * scale * 1.08) + 0.5f); //乘以屏幕尺寸缩放比 暂适配小米2s
                    red3.setflystatus(1);
                    red3.setId(0);
                } else if ((Global.turn==2)&&(red3.getFlystutas() == 1 && Global.szStatus == 1)&&red3.getFlyRoad()==0) {
                    int begin, end;
                    begin = red3.getId();
                    red3.setId(Global.ran + 1);
                    end = red3.getId();
                    mvAsyncTask mvasy = new mvAsyncTask(red3, begin, end,Move.redpos);
                    mvasy.execute("a");
                        /*if(!((Global.ran==5)||(lastValue==5))) {
                            Global.turn++;
                            Global.turn = Global.turn % 2;
                        }*/
                }
                Global.szStatus = 0;
            }
        });
        red4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((Global.turn == 2) && (Global.ran == 5 && red4.getFlystutas() == 0 && Global.szStatus == 1)) {
                    v.setX(244 * scale + 0.5f);
                    v.setY((float) (132 * scale * 1.08) + 0.5f); //乘以屏幕尺寸缩放比 暂适配小米2s
                    red4.setflystatus(1);
                    red4.setId(0);
                } else if ((Global.turn == 2) && (red4.getFlystutas() == 1 && Global.szStatus == 1)&&red4.getFlyRoad()==0) {
                    //float startX,startY,endX,endY;
                    int begin, end;
                    begin = red4.getId();
                    red4.setId(Global.ran + 1);
                    end = red4.getId();
                    mvAsyncTask mvasy = new mvAsyncTask(red4, begin, end,Move.redpos);
                    mvasy.execute("a");
                        /*if(!((Global.ran==5)||(lastValue==5))) {
                            Global.turn++;
                            Global.turn = Global.turn % 2;
                        }*/
                }
                Global.szStatus = 0;
            }
        });
        yellow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((Global.turn==3)&&(Global.ran == 5 && yellow1.getFlystutas() == 0 && Global.szStatus == 1)) {
                    v.setX(297 * scale + 0.5f);
                    v.setY((float) (332 * scale * 1.08) + 0.5f); //乘以屏幕尺寸缩放比 暂适配小米2s
                    yellow1.setflystatus(1);
                    yellow1.setId(0);
                } else if ((Global.turn==3)&&(yellow1.getFlystutas() == 1 && Global.szStatus == 1)&&yellow1.getFlyRoad()==0) {
                    int begin, end;
                    begin = yellow1.getId();
                    yellow1.setId(Global.ran + 1);
                    end = yellow1.getId();
                    mvAsyncTask mvasy = new mvAsyncTask(yellow1, begin, end,Move.yellowpos);
                    mvasy.execute("a");
                        /*if(!((Global.ran==5)||(lastValue==5))) {
                            Global.turn++;
                            Global.turn = Global.turn % 2;
                        }*/
                }
                Global.szStatus = 0;
            }
        });
        yellow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((Global.turn == 3) && (Global.ran == 5 && yellow2.getFlystutas() == 0 && Global.szStatus == 1)) {
                    v.setX(297 * scale + 0.5f);
                    v.setY((float) (332 * scale * 1.08) + 0.5f); //乘以屏幕尺寸缩放比 暂适配小米2s
                    yellow2.setflystatus(1);
                    yellow2.setId(0);
                } else if ((Global.turn == 3) && (yellow2.getFlystutas() == 1 && Global.szStatus == 1)&&yellow2.getFlyRoad()==0) {
                    int begin, end;
                    begin = yellow2.getId();
                    yellow2.setId(Global.ran + 1);
                    end = yellow2.getId();
                    mvAsyncTask mvasy = new mvAsyncTask(yellow2, begin, end,Move.yellowpos);
                    mvasy.execute("a");
                        /*if(!((Global.ran==5)||(lastValue==5))) {
                            Global.turn++;
                            Global.turn = Global.turn % 2;
                        }*/
                }
                Global.szStatus = 0;
            }
        });
        yellow3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if  ((Global.turn==3)&&(Global.ran == 5 && yellow3.getFlystutas() == 0 && Global.szStatus == 1)) {
                    v.setX(297 * scale + 0.5f);
                    v.setY((float) (332 * scale * 1.08) + 0.5f); //乘以屏幕尺寸缩放比 暂适配小米2s
                    yellow3.setflystatus(1);
                    yellow3.setId(0);
                } else if ((Global.turn==3)&&(yellow3.getFlystutas() == 1 && Global.szStatus == 1)&&yellow3.getFlyRoad()==0) {
                    int begin, end;
                    begin = yellow3.getId();
                    yellow3.setId(Global.ran + 1);
                    end = yellow3.getId();
                    mvAsyncTask mvasy = new mvAsyncTask(yellow3, begin, end,Move.yellowpos);
                    mvasy.execute("a");
                        /*if(!((Global.ran==5)||(lastValue==5))) {
                            Global.turn++;
                            Global.turn = Global.turn % 2;
                        }*/
                }
                Global.szStatus = 0;
            }
        });
        yellow4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((Global.turn == 3) && (Global.ran == 5 && yellow4.getFlystutas() == 0 && Global.szStatus == 1)) {
                    v.setX(297 * scale + 0.5f);
                    v.setY((float) (332 * scale * 1.08) + 0.5f); //乘以屏幕尺寸缩放比 暂适配小米2s
                    yellow4.setflystatus(1);
                    yellow4.setId(0);
                } else if ((Global.turn == 3) && (yellow4.getFlystutas() == 1 && Global.szStatus == 1)&&yellow4.getFlyRoad()==0) {
                    //float startX,startY,endX,endY;
                    int begin, end;
                    begin = yellow4.getId();
                    yellow4.setId(Global.ran + 1);
                    end = yellow4.getId();
                    mvAsyncTask mvasy = new mvAsyncTask(yellow4, begin, end,Move.yellowpos);
                    mvasy.execute("a");
                        /*if(!((Global.ran==5)||(lastValue==5))) {
                            Global.turn++;
                            Global.turn = Global.turn % 2;
                        }*/
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
}

