package com.example.suriya.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;


public class MainActivity extends AppCompatActivity {


    TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //getSupportActionBar().setDisplayShowTitleEnabled(false);
        RequestQueue queue = Volley.newRequestQueue(this);
        //String url = "https://www.google.com";
        String url = "http://192.168.1.132:5000";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.my_awesome_toolbar);
        //toolbar.setTitle(null);
        // Instantiate the RequestQueue.

        mTextView = (TextView) findViewById(R.id.text);

        // Request a string response from the provided URL.

        System.out.println(url);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        mTextView.setText(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //mTextView.setText("That didn't work!");
                mTextView.setText(error.toString());
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}
