package br.edu.unitri.googleanalyticsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public class ActivityA extends AppCompatActivity {

    Tracker mTracker;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        AnalyticsApplication application = (AnalyticsApplication) getApplication();
        mTracker = application.getDefaultTracker();
    }

    @Override
    protected void onResume(){
        super.onResume();

        mTracker.setScreenName("ActivityA");
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());

    }

    public void openActivity (View view) {

        mTracker.send(new HitBuilders.EventBuilder()
                .setCategory("Action")
                .setAction("openActivity")
                .build());

        intent = new Intent(this, ActivityB.class);
        startActivity(intent);
    }


}
