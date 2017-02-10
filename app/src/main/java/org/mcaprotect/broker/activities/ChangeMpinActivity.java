package org.mcaprotect.broker.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mcaprotect.broker.R;
import org.mcaprotect.broker.utils.DialogUtils;
import org.mcaprotect.broker.utils.PinEntryView;
import org.mcaprotect.broker.utils.UiUtils;

/**
 * Created by al1383 on 2/10/2017.
 */
public class ChangeMpinActivity extends BaseActivity implements View.OnClickListener{

    private PinEntryView mOldpinEdittext, mConfirmNewpinEdittext,mNewpinEdittext ;
    private TextView mErrorBanner;
    private Button mSetpinButton;
    private String mOldPin = "", mNewPin = "", mConfirmNewPin = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_mpin);

        setUiLayout();
    }

    private void setUiLayout(){
        mErrorBanner = (TextView) findViewById(R.id.error_banner);
        mOldpinEdittext = (PinEntryView) findViewById(R.id.oldpin_edittext);
        mNewpinEdittext = (PinEntryView) findViewById(R.id.newpin_edittext);
        mConfirmNewpinEdittext = (PinEntryView) findViewById(R.id.confirm_newpin_edittext);
        mSetpinButton = (Button) findViewById(R.id.setpin_button);

        mSetpinButton.setOnClickListener(this);

        mOldpinEdittext.setOnPinEnteredListener(new PinEntryView.OnPinEnteredListener() {
            @Override
            public void onPinEntered(String pin) {
                mOldPin = pin;
                if (mOldPin.length() == 4){
                    mNewpinEdittext.requestFocus();
                }
            }
        });

        mNewpinEdittext.setOnPinEnteredListener(new PinEntryView.OnPinEnteredListener() {
            @Override
            public void onPinEntered(String pin) {
                mNewPin = pin;
                mOldpinEdittext.requestFocus();
                mConfirmNewpinEdittext.requestFocus();
            }
        });

        mConfirmNewpinEdittext.setOnPinEnteredListener(new PinEntryView.OnPinEnteredListener() {
            @Override
            public void onPinEntered(String pin) {
                mConfirmNewPin = pin;
                mOldpinEdittext.requestFocus();
                mNewpinEdittext.requestFocus();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.setpin_button:
                if(validateInput()){
                    DialogUtils.fullScreenErrorDialogWithOkListener(this, String.format(getString(R.string.set_mpin_sucess_message)) ,"", getResources().getString(R.string.continue_button), new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent newPasswordScreen = new Intent(ChangeMpinActivity.this, MPinLoginActivity.class);
                            startActivity(newPasswordScreen);
                        }
                    });
                }
                break;
        }
    }

    private boolean validateInput() {
        if (mOldPin.toString().isEmpty() && mOldPin.length() <= 3) {
            UiUtils.showErrorBanner(mErrorBanner, getString(R.string.error_old_pin));
            return false;
        } else if(mNewPin.toString().isEmpty() && mNewPin.length() <= 3){
            UiUtils.showErrorBanner(mErrorBanner, getString(R.string.error_new_pin));
            return false;
        } else if(mConfirmNewPin.toString().isEmpty() && mConfirmNewPin.length() <= 3){
            UiUtils.showErrorBanner(mErrorBanner, getString(R.string.error_confirm_pin));
            return false;
        }
        return true;
    }
}
