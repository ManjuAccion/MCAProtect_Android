package org.mcaprotect.broker.activities;

import android.os.Bundle;

import org.mcaprotect.broker.R;
import org.mcaprotect.broker.utils.PinEntryView;

/**
 * Created by al1383 on 2/8/2017.
 */

public class MPinActivity extends BaseActivity {
    private PinEntryView pinEntryView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin_screen);

        pinEntryView = (PinEntryView) findViewById(R.id.password_edittext);
        pinEntryView.setOnPinEnteredListener(new PinEntryView.OnPinEnteredListener() {
            @Override
            public void onPinEntered(String pin) {

            }
        });
    }
}