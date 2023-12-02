package com.example.contactslist;

import android.widget.ImageView;

public class Contact {
    private String fullName ;

    private String phoneNumber ;
    private ImageView imgViewCall ;
    private ImageView imgViewSms ;

    public Contact(String fullName,  String phoneNumber) {

        this.fullName = fullName;
        this.phoneNumber = phoneNumber;

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ImageView getImgViewCall() {
        return imgViewCall;
    }

    public void setImgViewCall(ImageView imgViewCall) {
        this.imgViewCall = imgViewCall;
    }

    public ImageView getImgViewSms() {
        return imgViewSms;
    }

    public void setImgViewSms(ImageView imgViewSms) {
        this.imgViewSms = imgViewSms;
    }
}
