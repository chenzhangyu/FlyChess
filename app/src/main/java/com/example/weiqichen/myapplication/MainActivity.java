package com.example.weiqichen.myapplication;

import android.app.AlertDialog;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.content.Intent;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button single = (Button) findViewById(R.id.Singgle);
        Button Multi = (Button) findViewById(R.id.Multi);
        Button Exit = (Button) findViewById(R.id.Exit);
        ImageView img;
        Exit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
            }

        });
        single.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, SinglePlay.class);
                startActivity(intent);
            }
        });

    }
}

