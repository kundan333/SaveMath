package com.justbyluck.savemath;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by Kundan on 28-Jun-17.
 */

public class SimpleAdd extends AppCompatActivity {
    Context context;
    TextView numOne,numTwo,numResult;
    Button right,wrongb,button;
    Animation shake;
    RelativeLayout relativeLayout;
    MediaPlayer correct,wrongs,splash;
    Boolean time = true;
    final Thread thread =new Thread() ;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.simple_add);
        correct = MediaPlayer.create(SimpleAdd.this,R.raw.correct);
        wrongs = MediaPlayer.create(SimpleAdd.this,R.raw.wrong);
        splash = MediaPlayer.create(SimpleAdd.this,R.raw.swipe);


        numOne = (TextView)findViewById(R.id.fristNum);
        numTwo = (TextView)findViewById(R.id.secondNum);
        numResult =(TextView)findViewById(R.id.resultNum);
        relativeLayout = (RelativeLayout)findViewById(R.id.rlayout);
        button = (Button)findViewById(R.id.button);

        right = (Button)findViewById(R.id.yes);
        wrongb = (Button)findViewById(R.id.no);
        shake = AnimationUtils.loadAnimation(this, R.anim.shakeanim);

        thread.start();

        if (time) {
            addupdate();
        }
        else {
            time = false;
            Toast.makeText(getApplicationContext(),"Time Up",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        }

    }

    public void addupdate() {


        splash.start();

        Random random = new Random();

        final int a = random.nextInt(10);

        final int b = random.nextInt(10);
        final int c = a + b;

        int f = 2;
        final int g = random.nextInt(f);
        final int d;
        if (g == 0) {
            d = random.nextInt(c + 1);
        } else {
            d = c;
        }


        numOne.setText(String.valueOf(a));
        numTwo.setText(String.valueOf(b));
        numResult.setText(String.valueOf(d));
        click(c,d);


      /*
      if (time) {
            addupdate();
        }else{
            Toast.makeText(getApplicationContext(),"Time Up",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);

        }
*/
    }
    public void click(final int c,final int d){
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                long start = System.currentTimeMillis();
                Toast.makeText(getApplicationContext(),"Milies is : =" +start,Toast.LENGTH_LONG ).show();

                long stop = start +1500;

                if (start == stop){
                    Toast.makeText(getApplicationContext(),"Time Up",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }


                if ( c == d){
                    Toast.makeText(getApplicationContext(),"You Are right",Toast.LENGTH_SHORT).show();
                    correct.start();
                    addupdate();

                    /*   Intent intent = getIntent();
                    finish();
                    startActivity(intent); */

                }
                else {
                    //button.startAnimation(shake);
                    wrongs.start();
                    relativeLayout.startAnimation(shake);
                    /*
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    */
                    Toast.makeText(getApplicationContext(),"Game Over",Toast.LENGTH_SHORT).show();
                    addupdate();
                }

            }
        });

        wrongb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                long starts = System.currentTimeMillis();
                Toast.makeText(getApplicationContext(),"Milies is : =" +starts,Toast.LENGTH_LONG ).show();

                if (starts ==1500 ){
                    Toast.makeText(getApplicationContext(),"Time Up",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }

                if ( c == d){
                    wrongs.start();
                    Toast.makeText(getApplicationContext(),"Game Over",Toast.LENGTH_SHORT).show();
                    //button.startAnimation(shake);
                    relativeLayout.startAnimation(shake);
                    addupdate();
                    //Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    //startActivity(intent);
                }
                else {
                    correct.start();
                    Toast.makeText(getApplicationContext(),"You Are right",Toast.LENGTH_SHORT).show();
                    addupdate();
                   /*
                   Intent intent = getIntent();
                   finish();
                   startActivity(intent);
                   */
                }

            }
        });


    }




}