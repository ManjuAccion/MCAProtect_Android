package org.mcaprotect.broker.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.mcaprotect.broker.R;
import org.mcaprotect.broker.utils.PinEntryView;
import org.mcaprotect.broker.utils.UiUtils;
import org.mcaprotect.broker.utils.Utils;

/**
 * Created by al1383 on 2/8/2017.
 */

public class MPinLoginActivity extends BaseActivity implements View.OnClickListener {
    private PinEntryView pinEntryView;
    private TextView mErrorBanner, mForgotMpinTextview, mChangeMpinTextview;
    private Button mLoginButton;
    private String mPinValue = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin_screen);

        setUpLayout();
    }

    private void setUpLayout() {

        mErrorBanner = (TextView) findViewById(R.id.error_banner);
        pinEntryView = (PinEntryView) findViewById(R.id.pin_edittext);
        mChangeMpinTextview = (TextView) findViewById(R.id.change_mpin_textview);
        mForgotMpinTextview = (TextView) findViewById(R.id.forgot_mpin_textview);
        mLoginButton = (Button) findViewById(R.id.login_button);

        mForgotMpinTextview.setOnClickListener(this);
        mChangeMpinTextview.setOnClickListener(this);
        mLoginButton.setOnClickListener(this);


        pinEntryView.setOnPinEnteredListener(new PinEntryView.OnPinEnteredListener() {
            @Override
            public void onPinEntered(String pin) {
                mPinValue = pin;
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_button:

                if (mPinValue.length() <= 3) {
                    validateInput(mPinValue);
                } else {
                    Toast.makeText(MPinLoginActivity.this, "Your logic here", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.forgot_mpin_textview:

                break;
            case R.id.change_mpin_textview:
                Intent changemPin = new Intent(this, ChangeMpinActivity.class);
                startActivity(changemPin);

                break;

        }
    }

    private boolean validateInput(String pin) {
        if (pin.length() <= 3) {
            UiUtils.showErrorBanner(mErrorBanner, getString(R.string.error_pin));
            return false;
        }
        return true;
    }
}