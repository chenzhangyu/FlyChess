package com.example.weiqichen.myapplication;
import android.app.Activity;
import android.content.Context;
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
import android.content.Context;
import java.lang.ref.SoftReference;
import android.util.AttributeSet;
/**
 * Created by WeiqiChen on 2016/5/15.
 */
public class Global {
    static int ran=0; //方便测试临时设置
    static int szStatus=0;
    static int turn=0;
    static public void showTurn(Activity current){
        Toast toast = Toast.makeText(current,"当前位次"+String.valueOf(turn),Toast.LENGTH_SHORT);
        toast.show();
    }
    //static float scale = getResources().getDisplayMetrics().density;
}
