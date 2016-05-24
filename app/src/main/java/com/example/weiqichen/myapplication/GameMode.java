package com.example.weiqichen.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;

/**
 * Created by WeiqiChen on 2016/5/23.
 */
public class GameMode extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_mode);
        Button start = (Button)findViewById(R.id.button2);
        /*final RadioButton rb1 = (RadioButton)findViewById(R.id.radioButton);
        final RadioButton rb2 = (RadioButton)findViewById(R.id.radioButton2);
        final RadioButton rb3 = (RadioButton)findViewById(R.id.radioButton3);
        final RadioButton rb4 = (RadioButton)findViewById(R.id.radioButton4);
        final RadioButton rb5 = (RadioButton)findViewById(R.id.radioButton5);
        final RadioButton rb6 = (RadioButton)findViewById(R.id.radioButton6);*/
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(GameMode.this, SinglePlay.class);
                startActivity(intent);
            }
        });
        /*rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!rb1.isChecked()){
                    rb1.setChecked(false);
                }
                else
                    rb1.setChecked(true);
            }
        });
        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!rb2.isChecked()){
                    rb2.setChecked(false);
                }
                else
                    rb2.setChecked(true);
            }
        });
        rb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!rb3.isChecked()){
                    rb3.setChecked(false);
                }
                else
                    rb3.setChecked(true);
            }
        });
        rb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!rb4.isChecked()){
                    rb4.setChecked(false);
                }
                else
                    rb4.setChecked(true);
            }
        });
        rb5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!rb5.isChecked()){
                    rb5.setChecked(false);
                }
                else
                    rb5.setChecked(true);
            }
        });
        rb6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!rb6.isChecked()){
                    rb6.setChecked(false);
                }
                else
                    rb6.setChecked(true);
            }
        });*/
    }
}
