package br.edu.unitri.googleanalyticsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public class ActivityB extends AppCompatActivity {

    Tracker mTracker;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        AnalyticsApplication application = (AnalyticsApplication) getApplication();
        mTracker = application.getDefaultTracker();
    }

    @Override
    protected void onResume(){
        super.onResume();

        mTracker.setScreenName("ActivityB");
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
    }
}
