package com.stepin.myfirstapp.model;

import android.content.ContentValues;

public class Family {

    private Integer id;
    private String fName;
    private String email;
    private String website;
    private Integer pNumber;
    private String address;
    private Double rating;

    public Family(String fName, String email, String website, Integer pNumber, String address, Double rating) {
        this.fName = fName;
        this.email = email;
        this.website = website;
        this.pNumber = pNumber;
        this.address = address;
        this.rating = rating;
    }

    public Family(Integer id, String fName, String email, String website, Integer pNumber, String address, Double rating) {
        this.id = id;
        this.fName = fName;
        this.email = email;
        this.website = website;
        this.pNumber = pNumber;
        this.address = address;
        this.rating = rating;
    }

    public Family() {
        this.id = id;
        this.fName = fName;
        this.email = email;
        this.website = website;
        this.pNumber = pNumber;
        this.address = address;
        this.rating = rating;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Integer getpNumber() {
        return pNumber;
    }

    public void setpNumber(Integer pNumber) {
        this.pNumber = pNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ContentValues getContent(){
        ContentValues cValues = new ContentValues();
        cValues.put("name",getfName());
        cValues.put("address",getAddress());
        cValues.put("website",getWebsite());
        cValues.put("email",getEmail());
        cValues.put("phone",getpNumber());
        cValues.put("rating",getRating());

        return cValues;
    }

    @Override
    public String toString() {
        return this.getfName()+" - "+this.getRating();
    }
}
