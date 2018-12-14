package com.hhm.india.sosmybuddy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import mehdi.sakout.aboutpage.AboutPage;

public class AboutUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        View aboutPage = new AboutPage(AboutUs.this)
                .isRTL(false)
                //.setImage(R.drawable.hhmindia)
                .setDescription("HHM INDIA Software\n\n We deals in web designing & development, software development, mobile applications, search engine optimization, graphic designing, and all other IT solutions. We provide all type of designing/development/promotion services. ")
                .addGroup("For contribution or bug related issue contact.")
                .addEmail(" info@hhmindia.com","Email Us")
                .addTwitter("hhmindia","Follow Us")
                .addFacebook("hhmindia","Connect via Facebook")
                .addWebsite("www.hhmindia.com")
                .create();

        setContentView(aboutPage);


    }
}
