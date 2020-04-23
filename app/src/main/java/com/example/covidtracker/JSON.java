package com.example.covidtracker;

import android.content.Context;
import android.content.res.AssetManager;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public abstract class JSON {

    public static String loadJSONFromFile(AssetManager manager) {
        String json = null;

        try {
            InputStream in = manager.open("data.json");
            int size = in.available();
            byte[] buffer = new byte[size];

            in.read(buffer);
            in.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return json;
    }

}