package com.mj.restaurantapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import static com.mj.restaurantapp.MainActivity.foodmenuList;


public class restfoodmenu_retrieve extends AsyncTask<String,Void,String> {
    Context context;


    private  String foodname,foodtype,price;
    public restfoodmenu_retrieve(Context ctx)
    {
        context=ctx;

    }
    @Override
    protected String doInBackground(String... voids) {

        String login_url= "http://192.168.43.221/retrieve2.php";

        //  String login_url= "http://192.168.43.201/food/Accnt.php";
        try {
            URL url=new URL(login_url);
            HttpURLConnection httpURLConnection =(HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);

            InputStream inputStream=httpURLConnection.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
            String result="";
            String line="";
            while((line=bufferedReader.readLine())!=null)
            {
                result+=line;


            }
            bufferedReader.close();
            inputStream.close();
            return  result;
        }catch (Exception e)
        {
            return e.toString();
        }

    }
    @Override
    protected void onPreExecute() {

    }

    @Override
    protected void onPostExecute(String result) {
     //   Toast.makeText(context,result,Toast.LENGTH_LONG).show();
        try {
            String foodname="";
            String foodtype="";
            String price="";
            int resid=1;
            JSONArray jsonArray = new JSONArray(result);

            for(int i=0;i<jsonArray.length();i++)
            {
                JSONObject obj=jsonArray.getJSONObject(i);


                foodmenuList.add(new Foodmenu(obj.getString("foodname"),obj.getString("price"),obj.getString("foodtype")));

                // Toast.makeText(context,obj.getString("foodname"),Toast.LENGTH_SHORT).show();
            }
            //  getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Menuu()).commit();
            //FragmentManager fragmentManager=context.getApplicationContext().get
            //fm.beginTransaction().replace(R.id.fragment_container,new Menuu()).commit();
//context.getApplicationContext().getSupp
        }catch (Exception e){

            Toast.makeText(context,e.toString(),Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }


}
