package com.lisn.example.application;

import android.app.Application;

import com.lisn.api.SRouter;


public class FTApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SRouter.getInstance().initRegister(this);
    }

}
