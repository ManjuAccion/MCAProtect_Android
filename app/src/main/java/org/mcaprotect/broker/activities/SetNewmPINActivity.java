package org.mcaprotect.broker.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mcaprotect.broker.R;
import org.mcaprotect.broker.utils.McaConstants;
import org.mcaprotect.broker.utils.NavigationUtils;
import org.mcaprotect.broker.utils.PinEntryView;
import org.mcaprotect.broker.utils.UiUtils;

/**
 * Created by al1383 on 2/7/2017.
 */

public class SetNewmPINActivity extends Activity implements View.OnClickListener{
    private Button mSetpinButton;
    private NavigationUtils mNavigationUtility;
    private TextView mMessageTextview, mMpinTextview, mSetpinTitleTextview;
    private PinEntryView mNewpinEdittext, mConfirmNewpinEdittext;
    private String mScreenName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setmpin);

        setUpLayout();
        setupNavBar();
    }

    private void setUpLayout() {
        //mScreenName = getIntent().getExtras().getString(McaConstants.SCREEN_NAME);
        mSetpinButton = (Button) findViewById(R.id.setpin_button);
        mMpinTextview = (TextView) findViewById(R.id.mpin_textview);
        mSetpinTitleTextview = (TextView) findViewById(R.id.setpin_title_textview);
        mMessageTextview = (TextView) findViewById(R.id.message_textview);
        mNewpinEdittext = (PinEntryView) findViewById(R.id.newpin_edittext);
        mConfirmNewpinEdittext = (PinEntryView) findViewById(R.id.confirm_newpin_edittext);

        UiUtils.regularTextView(new TextView[]{mSetpinButton, mSetpinTitleTextview, mMessageTextview});
        UiUtils.lightTextView(new TextView[]{ });
        UiUtils.lightItalicTextView(new TextView[]{mMpinTextview});

        mSetpinButton.setOnClickListener(this);
    }

    private void setupNavBar() {
        mNavigationUtility = new NavigationUtils(findViewById(R.id.base_layout));
        mNavigationUtility.hideLeftNavButton();
        mNavigationUtility.displayRightNavButton();

        mNavigationUtility.setRightNavListener(SetNewmPINActivity.this);
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
