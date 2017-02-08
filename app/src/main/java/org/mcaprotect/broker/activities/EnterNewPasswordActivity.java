package org.mcaprotect.broker.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.mcaprotect.broker.R;
import org.mcaprotect.broker.utils.NavigationUtils;
import org.mcaprotect.broker.utils.UiUtils;

/**
 * Created by al1383 on 2/8/2017.
 */

public class EnterNewPasswordActivity extends BaseActivity implements View.OnClickListener {
    private NavigationUtils mNavigationUtility;
    private EditText mPasswordEdittext, mConfirmPasswordEdittext;
    private TextView mErrorBanner;
    private Button mChangePasswordButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_password);

        setupLayout();
    }

    private void setupLayout() {
        mErrorBanner = (TextView) findViewById(R.id.error_banner);
        mPasswordEdittext = (EditText) findViewById(R.id.password_edittext);
        mConfirmPasswordEdittext = (EditText) findViewById(R.id.confirm_password_edittext);
        mChangePasswordButton = (Button) findViewById(R.id.change_password_button);

        mChangePasswordButton.setOnClickListener(this);
    }

    private boolean validateInput() {
        if (mPasswordEdittext.getText().length() == 0) {
            UiUtils.showErrorBanner(mErrorBanner, getString(R.string.error_password));
            return false;
        } else if (mConfirmPasswordEdittext.getText().length() == 0) {
            UiUtils.showErrorBanner(mErrorBanner, getString(R.string.error_confirm_password));
            return false;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.change_password_button:
                if (validateInput()) {
                    finish();
                }
                break;
        }
    }
}
