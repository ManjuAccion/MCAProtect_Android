package org.mcaprotect.broker.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.mcaprotect.broker.R;
import org.mcaprotect.broker.utils.NavigationUtils;
import org.mcaprotect.broker.utils.UiUtils;
import org.mcaprotect.broker.utils.Utils;

/**
 * Created by al1383 on 2/16/2017.
 */
public class MyProfileActivity extends BaseActivity implements View.OnClickListener{
    private NavigationUtils mNavigationUtility;
    private ImageView userProfileimageview;
    private EditText mNameEdittext, mEmailIdEdittext, mPhoneNumberEdittext;
    private Button mSaveButton;
    private TextView mErrorBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        setUpLayout();
        setupNavBar();
    }

    private void setupNavBar() {
        mNavigationUtility = new NavigationUtils(findViewById(R.id.base_layout));
        mNavigationUtility.displayLeftNavButton();
        mNavigationUtility.hideRightNavButton();

        mNavigationUtility.setLeftNavListener(MyProfileActivity.this);
    }

    private void setUpLayout() {
        mErrorBanner = (TextView) findViewById(R.id.error_banner);
        userProfileimageview = (ImageView) findViewById(R.id.user_profile_imageview);
        mNameEdittext = (EditText) findViewById(R.id.name_edittext);
        mEmailIdEdittext = (EditText) findViewById(R.id.email_id_edittext);
        mPhoneNumberEdittext = (EditText) findViewById(R.id.phone_number_edittext);
        mSaveButton = (Button) findViewById(R.id.save_button);

        mNameEdittext.setOnClickListener(this);
        mEmailIdEdittext.setOnClickListener(this);
        mPhoneNumberEdittext.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.back_imageview:

                break;
            case R.id.user_profile_imageview:

                break;
            case R.id.name_edittext:

                break;
            case R.id.email_id_edittext:

                break;
            case R.id.phone_number_edittext:

                break;

            case R.id.save_button:
                if(validateInput()){

                }
                break;
        }
    }

    private boolean validateInput() {
        if (mNameEdittext.getText().length() == 0) {
            UiUtils.showErrorBanner(mErrorBanner, getString(R.string.error_business_name));
            return false;
        } else if (mEmailIdEdittext.getText().length() == 0 || !Utils.validateEmail(mEmailIdEdittext)) {
            UiUtils.showErrorBanner(mErrorBanner, getString(R.string.error_valid_mail));
            return false;
        } else if (mPhoneNumberEdittext.getText().length() == 0) {
            UiUtils.showErrorBanner(mErrorBanner, getString(R.string.error_mobile_number));
            return false;
        }
        return true;
    }
}
