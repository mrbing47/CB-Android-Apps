package com.hhm.india.sosmybuddy;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import mehdi.sakout.aboutpage.AboutPage;

public class AboutDev extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_dev);
        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setDescription("RISHABH GUPTA \n\n This application is developed by Rishabh Gupta")
                .addGroup("For contribution or bug related issue contact.")
                .addEmail("rg081999@gmail.com","Email Us")
                .addFacebook("rishabhgupta.08","Connect via Facebook")
                .addGitHub("rishu08")
                .addInstagram("_rishabh_gupta")
                .create();

        setContentView(aboutPage);
    }

}
