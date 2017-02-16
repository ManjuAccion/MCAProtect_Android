package org.mcaprotect.broker.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.mcaprotect.broker.R;
import org.mcaprotect.broker.utils.DialogUtils;
import org.mcaprotect.broker.utils.NavigationUtils;
import org.mcaprotect.broker.utils.UiUtils;
import org.mcaprotect.broker.utils.Utils;

/**
 * Created by al1383 on 2/13/2017.
 */

public class ReSetmPINActivity extends BaseActivity implements View.OnClickListener {
    private Button mOkButton;
    private NavigationUtils mNavigationUtility;
    private EditText mEmailidEdittext;
    private TextView mMessageTextview, mErrorBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_mpin);

        setUpLayout();
        setupNavBar();
    }

    private void setUpLayout() {
        mErrorBanner = (TextView) findViewById(R.id.error_banner);
        mOkButton = (Button) findViewById(R.id.ok_button);
        mEmailidEdittext = (EditText) findViewById(R.id.mailid_edittext);
        mMessageTextview = (TextView) findViewById(R.id.message_textview);

        UiUtils.regularTextView(new TextView[]{mOkButton, mMessageTextview});
        UiUtils.lightTextView(new TextView[]{mEmailidEdittext});

        mOkButton.setOnClickListener(this);
    }

    private void setupNavBar() {
        mNavigationUtility = new NavigationUtils(findViewById(R.id.base_layout));
        mNavigationUtility.displayLeftNavButton();
        mNavigationUtility.hideRightNavButton();

        mNavigationUtility.setLeftNavListener(ReSetmPINActivity.this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_imageview:
                finish();
                break;

            case R.id.ok_button:
                if(validateInput()){
                    DialogUtils.fullScreenErrorDialogWithOkListener(this, String.format(getString(R.string.popup_sucess_message)) ,"", getResources().getString(R.string.ok_button), new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent setNewmPIN = new Intent(ReSetmPINActivity.this, SetNewmPINActivity.class);
                            setNewmPIN.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(setNewmPIN);
                            finish();
                        }
                    });

                }
                break;
        }
    }

    private boolean validateInput() {
        if (mEmailidEdittext.length() == 0 || !Utils.validateEmail(mEmailidEdittext)) {
            UiUtils.showErrorBanner(mErrorBanner, getString(R.string.error_valid_mail_phone_number));
            return false;
        }
        return true;
    }
}
