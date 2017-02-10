package org.mcaprotect.broker.activities;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import org.mcaprotect.broker.R;
import org.mcaprotect.broker.utils.DialogUtils;
import org.mcaprotect.broker.utils.McaConstants;
import org.mcaprotect.broker.utils.NavigationUtils;

/**
 * Created by al1383 on 2/8/2017.
 */

public class AboutusTcPrivacyWebviewActivity extends BaseActivity implements View.OnClickListener {
    private WebView webView;
    private Dialog dialog;
    private NavigationUtils mNavigationUtility;
    private String screenName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus_tc_privacy);

        setUpLayout();
        setupNavBar();
    }

    /*setup layout view*/
    private void setUpLayout() {
        screenName = getIntent().getExtras().getString(McaConstants.SCREEN_NAME);
        dialog = DialogUtils.getLoadingProgressDialog(this);
        webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);

        if (screenName.equals(McaConstants.ABOUT_US)) {
            webView.loadUrl(McaConstants.ABOUT_US_HTML);
        } else if (screenName.equals(McaConstants.TERMS_CONDITION)) {
            webView.loadUrl(McaConstants.TERMS_CONDITION_HTML);
        } else {
            webView.loadUrl(McaConstants.PRIVACY_POLICY_HTML);
        }

        webView.setBackgroundColor(Color.TRANSPARENT);
        webView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                dialog.show();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                if (dialog.isShowing() && !isFinishing())
                    dialog.dismiss();
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }


    private void setupNavBar() {
        mNavigationUtility = new NavigationUtils(findViewById(R.id.base_layout));
        mNavigationUtility.displayLeftNavButton();
        mNavigationUtility.hideRightNavButton();

        mNavigationUtility.setLeftNavListener(AboutusTcPrivacyWebviewActivity.this);

        /*setup Screen title*/
        if (screenName.equals(McaConstants.ABOUT_US)) {
            mNavigationUtility.setTitle(getString(R.string.about_us_title));
        } else if (screenName.equals(McaConstants.TERMS_CONDITION)) {
            mNavigationUtility.setTitle(getString(R.string.terms_conditions));
        } else {
            mNavigationUtility.setTitle(getString(R.string.privacy_policy_title));
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_imageview:
                finish();
                break;
        }
    }
}
