package org.mcaprotect.broker.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.mcaprotect.broker.R;
import org.mcaprotect.broker.utils.NavigationUtils;
import org.mcaprotect.broker.utils.UiUtils;

/**
 * Created by al1383 on 2/13/2017.
 */

public class ResetmPINActivity extends Activity implements View.OnClickListener {
    private Button mLoginButton;
    private NavigationUtils mNavigationUtility;
    private EditText mEmailidEdittext;
    private TextView mMessageTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_mpin);

        setUpLayout();
        setupNavBar();
    }

    private void setUpLayout() {
        mLoginButton = (Button) findViewById(R.id.login_button);
        mEmailidEdittext = (EditText) findViewById(R.id.mailid_edittext);
        mMessageTextview = (TextView) findViewById(R.id.message_textview);

        UiUtils.regularTextView(new TextView[]{mLoginButton, mEmailidEdittext, mMessageTextview});
        UiUtils.lightTextView(new TextView[]{mEmailidEdittext});

        mLoginButton.setOnClickListener(this);
    }

    private void setupNavBar() {
        mNavigationUtility = new NavigationUtils(findViewById(R.id.base_layout));
        mNavigationUtility.displayLeftNavButton();
        mNavigationUtility.hideRightNavButton();

        mNavigationUtility.setLeftNavListener(ResetmPINActivity.this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_imageview:

                break;
            case R.id.login_button:

                break;
        }
    }
}
