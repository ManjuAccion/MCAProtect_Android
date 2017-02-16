package org.mcaprotect.broker.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import org.mcaprotect.broker.R;

/**
 * Created by al1383 on 2/9/2017.
 */

public class SplashScreenActivity extends BaseActivity {
    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        navigteToNextScreen();
    }

    Handler mHandler = new Handler();

    private void navigteToNextScreen() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent openstartingpoint = new Intent(SplashScreenActivity.this, LoginActivity.class);
                startActivity(openstartingpoint);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
