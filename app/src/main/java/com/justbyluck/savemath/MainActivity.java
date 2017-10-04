package com.justbyluck.savemath;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ImageView imageView;

        final Context context =getApplicationContext() ;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        imageView = (ImageView)findViewById(R.id.play);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN ) {
                    Intent myIntent = new Intent(getApplicationContext(), SimpleAdd.class);
                    myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    ActivityOptions options = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.slide_in, R.anim.slide_out);
                    context.startActivity(myIntent, options.toBundle());
                }else{
                    Intent intent = new Intent(getApplicationContext(), SimpleAdd.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                }
            }
        });


    }
}
