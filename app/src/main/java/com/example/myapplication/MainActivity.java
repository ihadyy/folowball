package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Thread thread;
    private int levelSpeed=1000,counet=0;
    private ImageView img;
    private boolean play=true;
    private float x,y;
    private TextView txt2;
    private Button stop;
    private RadioButton level1,level2,level3;
    private Dialog d;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       level1=findViewById(R.id.level1);
       level2=findViewById(R.id.level2);
       level3=findViewById(R.id.level3);
       stop=findViewById(R.id.stop);
        d = new Dialog(this);
        d.setContentView(R.layout.points);
        d.setCancelable(true);


       level1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               levelSpeed=500;
           }
       });
        level2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                levelSpeed=200;
            }
        });
        level3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                levelSpeed=100;
            }
        });


                img=findViewById(R.id.emojy);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counet=counet+1;
            }
        });
        thread=new Thread(()->{
            try {
                while (play){
                    srartMoveImage();
                    Thread.sleep(levelSpeed);
                }
            }
            catch (InterruptedException e) {
            }
        });
        thread.start();

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play=false;
                txt2=d.findViewById(R.id.txt2);
                txt2.setText(counet+"");
                d.show();
            }
        });
    }
    private void srartMoveImage(){
        x = (float) Math.random()*800;
        y = (float) Math.random()*800;
        img.setX(x);
        img.setY(y);

    }
}