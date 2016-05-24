package com.example.weiqichen.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by WeiqiChen on 2016/5/23.
 */
public class MultiPlay extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multiplayer);
        Button create=(Button)findViewById(R.id.button3);
        final EditText txt = (EditText)findViewById(R.id.editText);
        final String string = txt.getHint().toString();
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MultiPlay.this, ClientSocket.class);
                startActivity(intent);
            }
        });
        txt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    txt.setHint(null);
                }
                else{
                    txt.setHint(string);
                }
            }
        });
    }
}
