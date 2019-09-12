package com.lisn.activity_chart;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.lisn.annotation.SRoute;
import com.lisn.common.RouterPathConst;

@SRoute(RouterPathConst.PATH_ACTIVITY_OTHER)
public class ChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
    }
}
