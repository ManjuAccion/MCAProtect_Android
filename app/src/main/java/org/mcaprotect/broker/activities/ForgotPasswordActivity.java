package org.mcaprotect.broker.activities;

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
 * Created by al1383 on 2/7/2017.
 */

public class ForgotPasswordActivity extends BaseActivity implements View.OnClickListener {
    private NavigationUtils mNavigationUtility;
    private Button mResetPasswordButton;
    private EditText mEmailidNumberEdittext;
    private TextView mEmailidMessage, mForgotPasswordTextview, mErrorBanner;
    private String mMobileNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        setupNavBar();
        setUpLayout();
    }

    private void setupNavBar() {
        mNavigationUtility = new NavigationUtils(findViewById(R.id.base_layout));
        mNavigationUtility.displayLeftNavButton();
        mNavigationUtility.hideRightNavButton();

        mNavigationUtility.setLeftNavListener(ForgotPasswordActivity.this);
    }

    private void setUpLayout() {
        mErrorBanner = (TextView) findViewById(R.id.error_banner);
        mResetPasswordButton = (Button) findViewById(R.id.reset_password_button);
        mEmailidNumberEdittext = (EditText) findViewById(R.id.mail_number_edittext);
        mEmailidMessage = (TextView) findViewById(R.id.emailid_message);
        mForgotPasswordTextview = (TextView) findViewById(R.id.forgot_password_textview);

        mResetPasswordButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_imageview:
                Intent newPasswordScreen = new Intent(this, EnterNewPasswordActivity.class);
                startActivity(newPasswordScreen);
                break;
            case R.id.reset_password_button:
                mMobileNumber = mEmailidNumberEdittext.getText().toString();
                if (validateInput()) {
                    DialogUtils.fullScreenErrorDialogWithOkListener(this, String.format(getString(R.string.popup_sucess_message)) ,"", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    });
                }
                break;
        }
    }

    private boolean validateInput() {
        if (mMobileNumber.length() == 0 || !Utils.validateEmail(mEmailidNumberEdittext)) {
            UiUtils.showErrorBanner(mErrorBanner, getString(R.string.error_valid_mail));
            return false;
        }
        return true;
    }
}
