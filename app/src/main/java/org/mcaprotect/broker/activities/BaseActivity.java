package org.mcaprotect.broker.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.mcaprotect.broker.R;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }
}
