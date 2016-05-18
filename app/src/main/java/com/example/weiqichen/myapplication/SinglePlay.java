package com.example.weiqichen.myapplication;

import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.lang.ref.SoftReference;

/**
 * Created by WeiqiChen on 2016/4/20.
 */
public class SinglePlay extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_play);
        ImageButton blue1 = (ImageButton) findViewById(R.id.blue1);
        ImageButton blue2 = (ImageButton) findViewById(R.id.blue2);
        ImageButton blue3 = (ImageButton) findViewById(R.id.blue3);
        ImageButton blue4 = (ImageButton) findViewById(R.id.blue4);
        final ImageButton sz = (ImageButton) findViewById(R.id.sz);
        sz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    SzAsyncTask szasyncTask = new SzAsyncTask(sz);
                    szasyncTask.execute("a");
            }
        });
        blue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Global.ran==5) {
                    float scale = getResources().getDisplayMetrics().density;
                    float scaleDenesity = getResources().getDisplayMetrics().scaledDensity;
                    v.setX(86*scale+0.5f);
                    v.setY((float)(190*scale*1.08)+0.5f); //乘以屏幕尺寸缩放比 暂适配小米2s
                }
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
}

