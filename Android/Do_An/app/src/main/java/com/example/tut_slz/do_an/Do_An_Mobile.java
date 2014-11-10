package com.example.tut_slz.do_an;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.concurrent.ExecutionException;


public class Do_An_Mobile extends Activity {

    private Button btnRefresh;
    private TextView txtTemp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do__an__mobile);
        btnRefresh=(Button) findViewById(R.id.btnRefresh);

        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onStart();
            }
        });
    }

    @Override
    protected  void  onStart()
    {
        super.onStart();
        AsyncTask<Void, Void, Item> cnt=new Connect().execute();
        txtTemp=(TextView)findViewById(R.id.txtvDID);
        try {
            Item item=cnt.get();
            txtTemp.setText(Integer.toString(item.getId()));
            txtTemp=(TextView)findViewById(R.id.txtvDName);
            txtTemp.setText(item.getName());
            txtTemp=(TextView)findViewById(R.id.txtvDResName);
            txtTemp.setText(item.getRestaurant_name());
            txtTemp=(TextView)findViewById(R.id.txtvDCreDate);
            txtTemp.setText(item.getCreateDate().toString());
            txtTemp=(TextView)findViewById(R.id.txtvDUpdate);
            txtTemp.setText(item.getUpdateDate().toString());
            txtTemp=(TextView)findViewById(R.id.txtvDPrice);
            txtTemp.setText(item.getPrice().toString());
            txtTemp=(TextView)findViewById(R.id.txtvDStat);
            txtTemp.setText( Integer.toString(item.getStatus()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_do__an__mobile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
