package org.mcaprotect.broker.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Point;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import org.mcaprotect.broker.BuildConfig;
import org.mcaprotect.broker.R;
import org.mcaprotect.broker.fragments.DealPipelineFragment;
import org.mcaprotect.broker.fragments.DealsFundedFragment;
import org.mcaprotect.broker.fragments.PerformanceComparisonFragment;
import org.mcaprotect.broker.utils.McaConstants;
import org.mcaprotect.broker.utils.UiUtils;

public class DashboardActivity extends BaseActivity implements View.OnClickListener {

    private DrawerLayout mDrawerLayout;
    private RelativeLayout mLeftSideMenu, mRightSideMenu;
    private ScrollView scrollviewHolder;
    private LinearLayout mDealPipelineLinearLayout, mPerformanceComparisonLinearLayout, mDealsFundedLinearLayout;
    private FrameLayout mContentDashboardFrameLayout;
    private ImageView mLeftMenuImageView, mRightMenuImageView, mUserProfileImageview;
    private Fragment mCurrentFragment, mDealPipelineFramgnet, mPerformanceComparisonFragment, mDealsFundedFragment;
    private TextView mBottomTabDealPipelineTextView, mBottomTabPerformanceComparisonTextView, mBottomTabDealsFundedTextView,
            mSidemenuDashboardTextview, mSidemenuMerchantAppTextview, mSidemenuSavedAppTextview, mSidemenuFundingProgramTextview,
            mSidemenuCommunicationTextview, mVersionTextview, mLogoutTextview, mProfileNameTextview;
    private TextView mSidemenuNotificationTextview, mSidemenuSettingsTextview, mSidemenuAboutusTextview, mSidemenuTermsofuseTextview,
            mSidemenuPrivacyTextview, mSidemenuShareFeedbackTextview, mSidemenuShareAppTextview, mSidemenuRateUsTextview;

    private ImageView mRightSidemenuOptionNav, mLeftSidemenuOptionNav;

    private final int SELECTED_TAB_DEAL_PIPELINE = 1,
            SELECTED_TAB_PERFORMANCE_COMPARISON = 2,
            SELECTED_TAB_DEALS_FUNDED = 3;

    private int mCurrentSelectedTab = SELECTED_TAB_DEAL_PIPELINE;


    public static float DEVICE_WIDTH_IN_PX;
    public static float DEVICE_HEIGHT_IN_PX;
    public static float DEVICE_WIDTH_IN_DP;
    public static float DEVICE_HEIGHT_IN_DP;
    public static float DEVICE_DENSITY;

    public static float BAR_MAX_HEIGHT_DEALS_FUNDED;
    public static float BAR_MAX_HEIGHT_PERFORMANCE_COMPARISON;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);


        DEVICE_DENSITY = getResources().getDisplayMetrics().density;
        DEVICE_WIDTH_IN_PX = outMetrics.widthPixels;
        DEVICE_HEIGHT_IN_PX = outMetrics.widthPixels;
        DEVICE_WIDTH_IN_DP = outMetrics.widthPixels / DEVICE_DENSITY;
        DEVICE_HEIGHT_IN_DP = outMetrics.heightPixels / DEVICE_DENSITY;

        float margin = getResources().getDimension(R.dimen.screen_margin_left) + getResources().getDimension(R.dimen.screen_margin_right);
        BAR_MAX_HEIGHT_DEALS_FUNDED = ((DEVICE_WIDTH_IN_DP - margin) * 3 / 4) * DEVICE_DENSITY;
        BAR_MAX_HEIGHT_PERFORMANCE_COMPARISON = ((DEVICE_WIDTH_IN_DP - margin - 70)) * DEVICE_DENSITY;


        initialiseViews();
        selectDealPipeline();
    }


    private void initialiseViews() {

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mContentDashboardFrameLayout = (FrameLayout) findViewById(R.id.fragment_container);
        mDealPipelineLinearLayout = (LinearLayout) findViewById(R.id.deal_pipeline_linearlayout);
        mPerformanceComparisonLinearLayout = (LinearLayout) findViewById(R.id.performance_comparison_linearlayout);
        mDealsFundedLinearLayout = (LinearLayout) findViewById(R.id.deals_funded_linearlayout);
        mLeftMenuImageView = (ImageView) findViewById(R.id.left_menu_imageview);
        mRightMenuImageView = (ImageView) findViewById(R.id.right_menu_imageview);
        mBottomTabDealPipelineTextView = (TextView) findViewById(R.id.bottom_tab_deal_pipeline_textview);
        mBottomTabPerformanceComparisonTextView = (TextView) findViewById(R.id.bottom_tab_performance_comparison_textview);
        mBottomTabDealsFundedTextView = (TextView) findViewById(R.id.bottom_tab_deals_funded_textview);

        // sidemenu left
        mRightSideMenu = (RelativeLayout) findViewById(R.id.right_side_menu);
        mLeftSideMenu = (RelativeLayout) findViewById(R.id.left_side_menu);
        scrollviewHolder = (ScrollView) findViewById(R.id.scrollview_holder);
        mSidemenuDashboardTextview = (TextView) findViewById(R.id.sidemenu_dashboard_textview);
        mSidemenuMerchantAppTextview = (TextView) findViewById(R.id.sidemenu_merchant_app_textview);
        mSidemenuSavedAppTextview = (TextView) findViewById(R.id.sidemenu_saved_app_textview);
        mSidemenuFundingProgramTextview = (TextView) findViewById(R.id.sidemenu_funding_program_textview);
        mSidemenuCommunicationTextview = (TextView) findViewById(R.id.sidemenu_communication_textview);
        mUserProfileImageview = (ImageView) findViewById(R.id.user_profile_imageview);
        mProfileNameTextview = (TextView) findViewById(R.id.profile_name_textview);
        mVersionTextview = (TextView) findViewById(R.id.version_textview);
        mLogoutTextview = (TextView) findViewById(R.id.logout_textview);
        mVersionTextview.setText(getResources().getString(R.string.sidemenu_version) + " " + BuildConfig.VERSION_NAME);
        mLeftSidemenuOptionNav = (ImageView) findViewById(R.id.left_sidemenu_option_nav);

        // sidemenu rigth
        mSidemenuNotificationTextview = (TextView) findViewById(R.id.sidemenu_notification_textview);
        mSidemenuSettingsTextview = (TextView) findViewById(R.id.sidemenu_settings_textview);
        mSidemenuAboutusTextview = (TextView) findViewById(R.id.sidemenu_aboutus_textview);
        mSidemenuTermsofuseTextview = (TextView) findViewById(R.id.sidemenu_termsofuse_textview);
        mSidemenuPrivacyTextview = (TextView) findViewById(R.id.sidemenu_privacy_textview);
        mSidemenuShareFeedbackTextview = (TextView) findViewById(R.id.sidemenu_share_feedback_textview);
        mSidemenuShareAppTextview = (TextView) findViewById(R.id.sidemenu_shareapp_textview);
        mSidemenuRateUsTextview = (TextView) findViewById(R.id.sidemenu_rateus_textview);
        mRightSidemenuOptionNav = (ImageView) findViewById(R.id.right_sidemenu_option_nav);


        mSidemenuNotificationTextview.setOnClickListener(this);
        mSidemenuSettingsTextview.setOnClickListener(this);
        mSidemenuAboutusTextview.setOnClickListener(this);
        mSidemenuTermsofuseTextview.setOnClickListener(this);
        mSidemenuPrivacyTextview.setOnClickListener(this);
        mSidemenuShareFeedbackTextview.setOnClickListener(this);
        mSidemenuShareAppTextview.setOnClickListener(this);
        mSidemenuRateUsTextview.setOnClickListener(this);
        mLeftSidemenuOptionNav.setOnClickListener(this);

        mDealPipelineLinearLayout.setOnClickListener(this);
        mPerformanceComparisonLinearLayout.setOnClickListener(this);
        mDealsFundedLinearLayout.setOnClickListener(this);
        mLeftMenuImageView.setOnClickListener(this);
        mRightMenuImageView.setOnClickListener(this);

        mDrawerLayout.addDrawerListener(drawerListener);
        mSidemenuDashboardTextview.setOnClickListener(this);
        mSidemenuMerchantAppTextview.setOnClickListener(this);
        mSidemenuSavedAppTextview.setOnClickListener(this);
        mSidemenuFundingProgramTextview.setOnClickListener(this);
        mSidemenuCommunicationTextview.setOnClickListener(this);
        mUserProfileImageview.setOnClickListener(this);
        mProfileNameTextview.setOnClickListener(this);
        mRightSidemenuOptionNav.setOnClickListener(this);

        UiUtils.regularTextView(new TextView[]{mBottomTabDealPipelineTextView, mBottomTabPerformanceComparisonTextView, mBottomTabDealsFundedTextView});
        UiUtils.mediumTextView(new TextView[]{(TextView) findViewById(R.id.title_textview)});

    }


    @Override
    public void onBackPressed() {

        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.deal_pipeline_linearlayout:
                selectDealPipeline();
                break;

            case R.id.performance_comparison_linearlayout:
                selectPerformanceComparison();
                break;

            case R.id.deals_funded_linearlayout:
                selectDealsFunded();
                break;

            case R.id.left_menu_imageview:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return;

            case R.id.sidemenu_dashboard_textview:
                Toast.makeText(DashboardActivity.this, "Dashboard", Toast.LENGTH_SHORT).show();
                break;

            case R.id.sidemenu_merchant_app_textview:
                Toast.makeText(DashboardActivity.this, "merchant_app", Toast.LENGTH_SHORT).show();
                break;

            case R.id.sidemenu_saved_app_textview:
                Toast.makeText(DashboardActivity.this, "saved_app", Toast.LENGTH_SHORT).show();
                break;

            case R.id.sidemenu_funding_program_textview:
                Toast.makeText(DashboardActivity.this, "funding_program", Toast.LENGTH_SHORT).show();
                break;

            case R.id.sidemenu_communication_textview:
                Toast.makeText(DashboardActivity.this, "communication", Toast.LENGTH_SHORT).show();
                break;

            case R.id.user_profile_imageview:
            case R.id.profile_name_textview:
                Intent profileActivity = new Intent(DashboardActivity.this, MyProfileActivity.class);
                startActivity(profileActivity);
                break;

            case R.id.right_menu_imageview:
                mDrawerLayout.openDrawer(Gravity.RIGHT);
                return;

            case R.id.sidemenu_notification_textview:
                Toast.makeText(DashboardActivity.this, "notification", Toast.LENGTH_SHORT).show();
                break;

            case R.id.sidemenu_settings_textview:
                Toast.makeText(DashboardActivity.this, "settings", Toast.LENGTH_SHORT).show();
                break;

            case R.id.sidemenu_aboutus_textview:
                Intent aboutUs = new Intent(DashboardActivity.this, AboutusTcPrivacyWebviewActivity.class);
                aboutUs.putExtra(McaConstants.SCREEN_NAME, McaConstants.ABOUT_US);
                startActivity(aboutUs);
                break;

            case R.id.sidemenu_termsofuse_textview:
                Intent termsScreen = new Intent(DashboardActivity.this, AboutusTcPrivacyWebviewActivity.class);
                termsScreen.putExtra(McaConstants.SCREEN_NAME, McaConstants.TERMS_CONDITION);
                startActivity(termsScreen);
                break;

            case R.id.sidemenu_privacy_textview:
                Intent privacyScreen = new Intent(DashboardActivity.this, AboutusTcPrivacyWebviewActivity.class);
                privacyScreen.putExtra(McaConstants.SCREEN_NAME, McaConstants.PRIVACY_POLICY);
                startActivity(privacyScreen);
                break;

            case R.id.sidemenu_share_feedback_textview:
                Toast.makeText(DashboardActivity.this, "share_feedback", Toast.LENGTH_SHORT).show();
                break;

            case R.id.sidemenu_shareapp_textview:
                Toast.makeText(DashboardActivity.this, "shareapp", Toast.LENGTH_SHORT).show();
                break;

            case R.id.sidemenu_rateus_textview:
                Toast.makeText(DashboardActivity.this, "rateus", Toast.LENGTH_SHORT).show();
                break;

            case R.id.right_sidemenu_option_nav:
                mDrawerLayout.closeDrawer(Gravity.RIGHT);
                return;

            case R.id.left_sidemenu_option_nav:
                mDrawerLayout.closeDrawer(GravityCompat.START);
                return;

            default:
                break;
        }
        mDrawerLayout.closeDrawer(Gravity.RIGHT);
        mDrawerLayout.closeDrawer(GravityCompat.START);
    }

    DrawerLayout.DrawerListener drawerListener = new DrawerLayout.DrawerListener() {
        @Override
        public void onDrawerSlide(View drawerView, float slideOffset) {

        }

        @Override
        public void onDrawerOpened(View drawerView) {

        }

        @Override
        public void onDrawerClosed(View drawerView) {

        }

        @Override
        public void onDrawerStateChanged(int newState) {

        }
    };


    private void addFragment(Fragment fragment) {

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //fragmentTransaction.setTransition(R.animator.slide_in_from_bottom);
        //fragmentTransaction.setCustomAnimations(R.animator.slide_in_from_bottom, R.animator.nothing);
        //fragmentTransaction.setCustomAnimations(R.anim.push_top_in, R.anim.push_top_out);
        // fragmentTransaction.setCustomAnimations(R.animator.slide_in_from_bottom, R.animator.nothing).

        //Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);

        fragmentTransaction.replace(R.id.fragment_container, fragment);
        // fragmentTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransaction.commit();
    }

    private void selectDealPipeline() {
        if (mDealPipelineFramgnet == null) {
            mDealPipelineFramgnet = new DealPipelineFragment();
            mCurrentFragment = mDealPipelineFramgnet;
            addFragment(mCurrentFragment);
        } else if (!(mCurrentFragment instanceof DealPipelineFragment)) {
            mCurrentFragment = mDealPipelineFramgnet;
            addFragment(mCurrentFragment);
        }
        setTabBackground(SELECTED_TAB_DEAL_PIPELINE);
    }

    private void selectPerformanceComparison() {
        if (mPerformanceComparisonFragment == null) {
            mPerformanceComparisonFragment = new PerformanceComparisonFragment();
            mCurrentFragment = mPerformanceComparisonFragment;
            addFragment(mCurrentFragment);
        } else if (!(mCurrentFragment instanceof PerformanceComparisonFragment)) {
            mCurrentFragment = mPerformanceComparisonFragment;
            addFragment(mCurrentFragment);
        }
        setTabBackground(SELECTED_TAB_PERFORMANCE_COMPARISON);
    }

    private void selectDealsFunded() {
        if (mDealsFundedFragment == null) {
            mDealsFundedFragment = new DealsFundedFragment();
            mCurrentFragment = mDealsFundedFragment;
            addFragment(mCurrentFragment);
        } else if (!(mCurrentFragment instanceof DealsFundedFragment)) {
            mCurrentFragment = mDealsFundedFragment;
            addFragment(mCurrentFragment);
        }
        setTabBackground(SELECTED_TAB_DEALS_FUNDED);
    }

    private void setTabBackground(int selectedTab) {

        switch (selectedTab) {
            case SELECTED_TAB_DEAL_PIPELINE:
                mDealPipelineLinearLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.bottom_bar_on_select_bg_color));
                mPerformanceComparisonLinearLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.bottom_bar_bg_color));
                mDealsFundedLinearLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.bottom_bar_bg_color));

                mBottomTabDealPipelineTextView.setTextColor(ContextCompat.getColor(this, R.color.bottom_bar_on_select_text_color));
                mBottomTabPerformanceComparisonTextView.setTextColor(ContextCompat.getColor(this, R.color.bottom_bar_text_color));
                mBottomTabDealsFundedTextView.setTextColor(ContextCompat.getColor(this, R.color.bottom_bar_text_color));

                break;

            case SELECTED_TAB_PERFORMANCE_COMPARISON:
                mDealPipelineLinearLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.bottom_bar_bg_color));
                mPerformanceComparisonLinearLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.bottom_bar_on_select_bg_color));
                mDealsFundedLinearLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.bottom_bar_bg_color));

                mBottomTabDealPipelineTextView.setTextColor(ContextCompat.getColor(this, R.color.bottom_bar_text_color));
                mBottomTabPerformanceComparisonTextView.setTextColor(ContextCompat.getColor(this, R.color.bottom_bar_on_select_text_color));
                mBottomTabDealsFundedTextView.setTextColor(ContextCompat.getColor(this, R.color.bottom_bar_text_color));
                break;

            case SELECTED_TAB_DEALS_FUNDED:
                mDealPipelineLinearLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.bottom_bar_bg_color));
                mPerformanceComparisonLinearLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.bottom_bar_bg_color));
                mDealsFundedLinearLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.bottom_bar_on_select_bg_color));

                mBottomTabDealPipelineTextView.setTextColor(ContextCompat.getColor(this, R.color.bottom_bar_text_color));
                mBottomTabPerformanceComparisonTextView.setTextColor(ContextCompat.getColor(this, R.color.bottom_bar_text_color));
                mBottomTabDealsFundedTextView.setTextColor(ContextCompat.getColor(this, R.color.bottom_bar_on_select_text_color));
                break;
        }
    }
}
