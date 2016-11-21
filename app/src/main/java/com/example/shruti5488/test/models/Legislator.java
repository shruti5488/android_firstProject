package com.example.shruti5488.test.models;

/**
 * Created by shruti5488 on 11/19/16.
 */
public class Legislator {
    private static Legislator ourInstance = new Legislator();

    public static Legislator getInstance() {
        return ourInstance;
    }

    private String image;
    private String name;
    private String state;
    private String district;

    private Legislator() {
    }
    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public String getDistrict() {
        return district;
    }
    public Legislator(String image, String name, String state, String district) {
        this.image = image;
        this.name = name;
        this.state = state;
        this.district = district;
    }


}
