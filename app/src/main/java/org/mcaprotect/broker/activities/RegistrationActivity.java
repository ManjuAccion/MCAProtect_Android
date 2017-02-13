package org.mcaprotect.broker.activities;

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

public class RegistrationActivity extends BaseActivity implements View.OnClickListener {
    private NavigationUtils mNavigationUtility;
    private TextView mErrorBanner;
    private EditText mBusinessNameEdittext, mEmailIdEdittext, mPhoneNumberEdittext, mPasswordEdittext, mConfirmPasswordEdittext;
    private Button mRegisterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        setupNavBar();
        setUpLayout();
    }

    private void setupNavBar() {
        mNavigationUtility = new NavigationUtils(findViewById(R.id.base_layout));
        mNavigationUtility.displayLeftNavButton();
        mNavigationUtility.hideRightNavButton();

        mNavigationUtility.setLeftNavListener(RegistrationActivity.this);
    }

    private void setUpLayout() {
        mErrorBanner = (TextView) findViewById(R.id.error_banner);
        mRegisterButton = (Button) findViewById(R.id.register_button);

        mBusinessNameEdittext = (EditText) findViewById(R.id.business_name_edittext);
        mEmailIdEdittext = (EditText) findViewById(R.id.email_id_edittext);
        mPhoneNumberEdittext = (EditText) findViewById(R.id.phone_number_edittext);
        mPasswordEdittext = (EditText) findViewById(R.id.password_edittext);
        mConfirmPasswordEdittext = (EditText) findViewById(R.id.confirm_password_edittext);

        mRegisterButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_imageview:
                finish();
                break;
            case R.id.register_button:
                if (validateInput()) {
                    DialogUtils.fullScreenErrorDialogWithOkListener(this, String.format(getString(R.string.popup_sucess_message)), "", getResources().getString(R.string.ok_button), new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            finish();
                        }
                    });
                }
                break;
        }
    }

    private boolean validateInput() {
        if (mBusinessNameEdittext.getText().length() == 0) {
            UiUtils.showErrorBanner(mErrorBanner, getString(R.string.error_business_name));
            return false;
        } else if (mEmailIdEdittext.getText().length() == 0 && !Utils.validateEmail(mEmailIdEdittext)) {
            UiUtils.showErrorBanner(mErrorBanner, getString(R.string.error_valid_mail));
            return false;
        } else if (mPhoneNumberEdittext.getText().length() == 0) {
            UiUtils.showErrorBanner(mErrorBanner, getString(R.string.error_mobile_number));
            return false;
        } else if (mPasswordEdittext.getText().length() == 0) {
            UiUtils.showErrorBanner(mErrorBanner, getString(R.string.error_password));
            return false;
        } else if (mConfirmPasswordEdittext.getText().length() == 0) {
            UiUtils.showErrorBanner(mErrorBanner, getString(R.string.error_confirm_password));
            return false;
        }
        return true;
    }
}
