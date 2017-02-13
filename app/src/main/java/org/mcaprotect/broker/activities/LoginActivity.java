package org.mcaprotect.broker.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import org.mcaprotect.broker.R;
import org.mcaprotect.broker.utils.McaConstants;
import org.mcaprotect.broker.utils.UiUtils;
import org.mcaprotect.broker.utils.Utils;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mErrorBanner, mAboutUsTextview, mTermsConditionsTextview, mPrivacyTextview, mNewUserTextview,
            mForgotPasswordTextview, mLoginTextview;
    private EditText mEmailEdittext, mPasswordEdittext;
    private Button mLoginButton;
    private CheckBox mRememberPasswordCheckbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setUpLayout();
    }

    private void setUpLayout() {
        mErrorBanner = (TextView) findViewById(R.id.error_banner);
        mEmailEdittext = (EditText) findViewById(R.id.email_edittext);
        mPasswordEdittext = (EditText) findViewById(R.id.password_edittext);
        mLoginButton = (Button) findViewById(R.id.login_button);

        mLoginTextview = (TextView) findViewById(R.id.login_textview);
        mForgotPasswordTextview = (TextView) findViewById(R.id.forgot_password_textview);
        mNewUserTextview = (TextView) findViewById(R.id.new_user_textview);
        mAboutUsTextview = (TextView) findViewById(R.id.about_us_textview);
        mTermsConditionsTextview = (TextView) findViewById(R.id.terms_conditions_textview);
        mPrivacyTextview = (TextView) findViewById(R.id.privacy_textview);
        mRememberPasswordCheckbox = (CheckBox) findViewById(R.id.remember_password_checkbox);

        UiUtils.regularTextView(new TextView[]{mLoginButton, mRememberPasswordCheckbox, mLoginTextview});
        UiUtils.lightTextView(new TextView[]{mAboutUsTextview, mTermsConditionsTextview, mPrivacyTextview, mForgotPasswordTextview, mNewUserTextview});

        mLoginButton.setOnClickListener(this);
        mForgotPasswordTextview.setOnClickListener(this);
        mNewUserTextview.setOnClickListener(this);
        mAboutUsTextview.setOnClickListener(this);
        mTermsConditionsTextview.setOnClickListener(this);
        mPrivacyTextview.setOnClickListener(this);
        mRememberPasswordCheckbox.setOnClickListener(this);
    }

    private boolean validateInput() {
        if (mEmailEdittext.getText().length() == 0 && !Utils.validateEmail(mEmailEdittext)) {
            UiUtils.showErrorBanner(mErrorBanner, getString(R.string.error_valid_mail));
            return false;
        } else if (mPasswordEdittext.getText().length() == 0) {
            UiUtils.showErrorBanner(mErrorBanner, getString(R.string.error_password));
            return false;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_button:
                if (validateInput()) {
                    Intent dashBoardActivity = new Intent(LoginActivity.this, DashboardActivity.class);
                    startActivity(dashBoardActivity);
                }
                break;

            case R.id.forgot_password_textview:
                Intent forgotPassword = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(forgotPassword);
                break;

            case R.id.new_user_textview:
                Intent registration = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(registration);
                break;

            case R.id.about_us_textview:
                Intent aboutUs = new Intent(LoginActivity.this, AboutusTcPrivacyWebviewActivity.class);
                aboutUs.putExtra(McaConstants.SCREEN_NAME, McaConstants.ABOUT_US);
                startActivity(aboutUs);
                break;

            case R.id.terms_conditions_textview:
                Intent termsScreen = new Intent(LoginActivity.this, AboutusTcPrivacyWebviewActivity.class);
                termsScreen.putExtra(McaConstants.SCREEN_NAME, McaConstants.TERMS_CONDITION);
                startActivity(termsScreen);
                break;

            case R.id.privacy_textview:
                Intent privacyScreen = new Intent(LoginActivity.this, AboutusTcPrivacyWebviewActivity.class);
                privacyScreen.putExtra(McaConstants.SCREEN_NAME, McaConstants.PRIVACY_POLICY);
                startActivity(privacyScreen);
                break;
        }
    }
}
