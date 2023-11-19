package com.example.demo.Model;

import java.io.Serializable;
import java.util.List;

public class Attraction implements Serializable {
    private final List<String> attImg;
    private final String attName;
    private final String attIntroduction;
    private final String attAddress;
    private final String attModified;
    private final String attUrl;

    public Attraction(List<String> img, String name, String introduction, String address, String modified, String url){
        this.attImg = img;
        this.attName = name;
        this.attIntroduction = introduction;
        this.attAddress = address;
        this.attModified = modified;
        this.attUrl = url;
    }

//    public Attraction(String name, String introduction, String address, String modified, String url){
//        this.attName = name;
//        this.attIntroduction = introduction;
//        this.attAddress = address;
//        this.attModified = modified;
//        this.attUrl = url;
//    }

    public List<String> getAttImg(){return attImg;}
    public String getAttName(){return attName;}
    public String getAttIntroduction(){return attIntroduction;}
    public String getAttAddress(){return attAddress;}
    public String getAttModified(){return attModified;}
    public String getAttUrl(){return attUrl;}
}
