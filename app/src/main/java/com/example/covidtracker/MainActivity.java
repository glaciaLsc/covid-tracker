package com.example.covidtracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import android.os.*;
import android.view.*;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.*;

public class MainActivity extends AppCompatActivity {
    Resources res;
    Drawable myImage;
    JSONObject obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create Drawable image object from resource file
        try {
            res = getResources();
            myImage = ResourcesCompat.getDrawable(res, R.drawable.globe_map, null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Obtain COVID-19 data from the John Hopkins CSSE Repository
        try {
            // Create network thread to handle data stream
            //NetworkThread thread = new NetworkThread("http://api.covid19api.com/summary");
            //thread.start();
            //thread.join();

            //obj = new JSONObject(thread.getJson());
            obj = new JSONObject(JSON.loadJSONFromFile(getAssets()));
        } catch ( JSONException e) {
            e.printStackTrace();
        }
    }

    // Check coordinates of user input to determine continent & launch appropriate activity
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN)
        {
            if (((event.getX() >= 251 && event.getX() <= 454) && (event.getY() >= 585 && event.getY() <= 712)) ||
                    ((event.getX() >= 98 && event.getX() <= 355) && (event.getY() >= 638 && event.getY() <= 794)) ||
                    ((event.getX() >= 146 && event.getX() <= 321) && (event.getY() >= 797 && event.getY() <= 936)))
                startActivity(new Intent(this, DisplayNorthAmericaActivity.class));
            else if (((event.getX() >= 262 && event.getX() <= 415)) && ((event.getY() >= 967 && event.getY() <= 1177)))
                startActivity(new Intent(this, DisplaySouthAmericaActivity.class));
            else if (((event.getX() >= 471 && event.getX() <= 610) && (event.getY() >= 885 && event.getY() <= 1092)) ||
                    ((event.getX() >= 602 && event.getX() <= 681) && (event.getY() >= 956 && event.getY() <= 1083)))
                startActivity(new Intent(this, DisplayAfricaActivity.class));
            else if (((event.getX() >= 457 && event.getX() <= 638) && (event.getY() >= 721 && event.getY() <= 828)) ||
                    ((event.getX() >= 537 && event.getX() <= 661) && (event.getY() >= 607 && event.getY() <= 760)))
                startActivity(new Intent(this, DisplayEuropeActivity.class));
            else if (((event.getX() >= 695 && event.getX() <= 1035) && (event.getY() >= 582 && event.getY() <= 826)) ||
                    ((event.getX() >= 675 && event.getX() <= 1015) && (event.getY() >= 803 && event.getY() <= 979)) ||
                    ((event.getX() >= 633 && event.getX() <= 706) && (event.getY() >= 848 && event.getY() <= 925)) ||
                    ((event.getX() >= 837 && event.getX() <= 944) && (event.getY() >= 953 && event.getY() <= 996)))
                startActivity(new Intent(this, DisplayAsiaActivity.class));
            else if (((event.getX() >= 873 && event.getX() <= 1063)) && ((event.getY() >= 1030 && event.getY() <= 1185)))
                startActivity(new Intent(this, DisplayAustraliaActivity.class));
        }

        return super.onTouchEvent(event);
    }

    // Network thread to handle URL stream
    class NetworkThread extends Thread {
        String url;
        String json;

        NetworkThread(String url) {
            this.url = url;
            this.json = null;
        }

        @Override
        public void run() {
            try {
                URL link = new URL(url);
                URLConnection connection = link.openConnection();
                InputStream in = connection.getInputStream();
                int size = in.available();
                byte[] buffer = new byte[size];

                in.read(buffer);
                in.close();
                json = new String(buffer, "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public String getJson() {
            return json;
        }
    }

}