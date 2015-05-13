package com.example.michael.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {


    Button bt;
    protected MyApplication app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = (Button) findViewById(R.id.createE);

        bt.setOnClickListener(creatEvent);

        // Get the application instance
        app = (MyApplication)getApplication();

        // Call a custom application method
        app.customAppMethod();

        // Call a custom method in MySingleton
        MySingleton.getInstance().customSingletonMethod();

        // Read the value of a variable in MySingleton
        String singletonVar = MySingleton.getInstance().customVar;

    }



    private View.OnClickListener creatEvent = new View.OnClickListener() {
        @Override
        public void onClick(View v)
        {
            Intent intent = new Intent(MainActivity.this, Category_Event.class);
            startActivity(intent);
            }
        };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
