package org.mcaprotect.broker.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mcaprotect.broker.R;
import org.mcaprotect.broker.utils.DialogUtils;
import org.mcaprotect.broker.utils.NavigationUtils;
import org.mcaprotect.broker.utils.PinEntryView;
import org.mcaprotect.broker.utils.UiUtils;

/**
 * Created by al1383 on 2/7/2017.
 */

public class SetNewmPINActivity extends Activity implements View.OnClickListener {
    private Button mSetpinButton;
    private NavigationUtils mNavigationUtility;
    private TextView mMessageTextview, mMpinTextview, mSetpinTitleTextview, mErrorBanner;
    private PinEntryView mNewpinEdittext, mConfirmNewpinEdittext;
    private String mScreenName, mPin = "", mConfirmPin = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setmpin);

        setUpLayout();

    }

    private void setUpLayout() {
        //mScreenName = getIntent().getExtras().getString(McaConstants.SCREEN_NAME);
        mErrorBanner = (TextView) findViewById(R.id.error_banner);
        mSetpinButton = (Button) findViewById(R.id.setpin_button);
        mMpinTextview = (TextView) findViewById(R.id.mpin_textview);
        mSetpinTitleTextview = (TextView) findViewById(R.id.setpin_title_textview);
        mMessageTextview = (TextView) findViewById(R.id.message_textview);
        mNewpinEdittext = (PinEntryView) findViewById(R.id.newpin_edittext);
        mConfirmNewpinEdittext = (PinEntryView) findViewById(R.id.confirm_newpin_edittext);

        UiUtils.regularTextView(new TextView[]{mSetpinButton, mSetpinTitleTextview, mMessageTextview});
        UiUtils.lightTextView(new TextView[]{});
        UiUtils.lightItalicTextView(new TextView[]{mMpinTextview});

        mSetpinButton.setOnClickListener(this);
        mNewpinEdittext.requestFocus();

        mNewpinEdittext.setOnPinEnteredListener(new PinEntryView.OnPinEnteredListener() {
            @Override
            public void onPinEntered(String pin) {
                mPin = pin;

            }
        });

        mConfirmNewpinEdittext.setOnPinEnteredListener(new PinEntryView.OnPinEnteredListener() {
            @Override
            public void onPinEntered(String pin) {
                mConfirmPin = pin;
                mNewpinEdittext.requestFocus();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_imageview:

                break;
            case R.id.setpin_button:
                if (validateInput()) {
                    Intent dashBoardActivity = new Intent(SetNewmPINActivity.this, DashboardActivity.class);
                    dashBoardActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(dashBoardActivity);
                }
                break;
        }
    }

    private boolean validateInput() {
        if (mPin.length() <= 3) {
            UiUtils.showErrorBanner(mErrorBanner, getString(R.string.error_new_pin));
            return false;
        } else if (mConfirmPin.length() <= 3) {
            UiUtils.showErrorBanner(mErrorBanner, getString(R.string.error_confirm_pin));
            return false;
        } else if (!mPin.toString().equals(mConfirmPin.toString())) {
            UiUtils.showErrorBanner(mErrorBanner, getString(R.string.error_pin_confirm_pin));
            return false;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        DialogUtils.showAppCloseDialog(this);
    }
}
