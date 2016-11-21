package com.example.shruti5488.test.Services;

import android.util.Log;

import com.example.shruti5488.test.models.Legislator;

import java.util.ArrayList;

/**
 * Created by shruti5488 on 11/19/16.
 */

public class DataService {
    private static DataService ourInstance = new DataService();

    private  ArrayList<Legislator> stateList = new ArrayList<>();
    private  ArrayList<Legislator> HouseList = new ArrayList<>();
    private  ArrayList<Legislator> senateList = new ArrayList<>();
    public static DataService getInstance(){
        return ourInstance;
    }

    private DataService(){

    }

    public void setStateList(String image, String name, String state, String district){

        Legislator legislator = new Legislator(image,name,state,district);
        stateList.add(legislator);



    }

    public ArrayList<Legislator> getStateList(){
     //   Log.d("Hello","state list size "+ stateList.size());
        return stateList;

    }

    public void setHouseList(String image, String name, String state, String district){
     //   Log.d("Hello Now","item added 1" );
        HouseList.add(new Legislator(image,name,state,district));
    }
    public ArrayList<Legislator> getHouseList(){
       Log.d("Hello House","house list size "+ HouseList.size());
        return HouseList;

    }

    public void setSenateList(String image, String name, String state, String district){
        senateList.add(new Legislator(image,name,state,district));
    }
    public ArrayList<Legislator> getSenateList(){
      //  Log.d("Hello","senate list size "+ senateList.size());
        return senateList;

    }

}
