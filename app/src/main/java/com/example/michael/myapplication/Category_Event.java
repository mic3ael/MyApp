package com.example.michael.myapplication;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.ExpandableListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by michael on 5/10/15.
 */
public class Category_Event extends Activity {

    // more efficient than HashMap for mapping integers to objects
    SparseArray<Category> groups = new SparseArray<Category>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_event);
        createData();
        ExpandableListView listView = (ExpandableListView) findViewById(R.id.listView);
        Category_List adapter = new Category_List(this,
                groups);
        listView.setAdapter(adapter);

        new RetrieveTask().execute();

           }




    // Background task to retrieve locations from remote mysql server
    private class RetrieveTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {

//			ClassLoader classLoader = getClass().getClassLoader();
//			File file = new File(classLoader.getResource("file/retrieve.php").getFile());

            String strUrl = "http://192.168.43.49/config.php";
            URL url = null;
            StringBuffer sb = new StringBuffer();
            try {
                url = new URL(strUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream iStream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(iStream));
                String line = "";
                while( (line = reader.readLine()) != null){
                    sb.append(line);
                }

                reader.close();
                iStream.close();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return sb.toString();
        }



    }


    public void createData() {
        for (int j = 0; j < 5; j++) {
            Category group = new Category("Test " + j);
            for (int i = 0; i < 5; i++) {
                group.children.add("Sub Item" + i);
            }
            groups.append(j, group);
        }
    }







}
