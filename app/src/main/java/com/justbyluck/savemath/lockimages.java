package com.justbyluck.savemath;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Kundan on 19-Jul-17.
 */

public class lockimages extends AppCompatActivity {


    public Bitmap addimage(){

        Bitmap bitmap = Bitmap.createBitmap(500,500, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        Bitmap bmp = BitmapFactory.decodeResource(getResources(),R.drawable.lockpn);
        canvas.drawBitmap(bmp,250,250,null);



        return bitmap;
    }






}
