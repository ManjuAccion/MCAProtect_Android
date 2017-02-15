package org.mcaprotect.broker.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import org.mcaprotect.broker.BuildConfig;
import org.mcaprotect.broker.R;
import org.mcaprotect.broker.fragments.DealPipelineFragment;
import org.mcaprotect.broker.fragments.DealsFundedFragment;
import org.mcaprotect.broker.fragments.PerformanceComparisonFragment;
import org.mcaprotect.broker.utils.UiUtils;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener {

    private DrawerLayout mDrawerLayout;
    private RelativeLayout sideMenu;
    private ScrollView scrollviewHolder;
    private LinearLayout mDealPipelineLinearLayout, mPerformanceComparisonLinearLayout, mDealsFundedLinearLayout;
    private FrameLayout mContentDashboardFrameLayout;
    private ImageView mLeftMenuImageView, mRightMenuImageView;
    private Fragment mCurrentFragment, mDealPipelineFramgnet, mPerformanceComparisonFragment, mDealsFundedFragment;
    private TextView mBottomTabDealPipelineTextView, mBottomTabPerformanceComparisonTextView, mBottomTabDealsFundedTextView,
            mSidemenuDashboardTextview, mSidemenuMerchantAppTextview, mSidemenuSavedAppTextview, mSidemenuFundingProgramTextview,
            mSidemenuCommunicationTextview, mVersionTextview, mLogoutTextview;


    private final int SELECTED_TAB_DEAL_PIPELINE = 1,
            SELECTED_TAB_PERFORMANCE_COMPARISON = 2,
            SELECTED_TAB_DEALS_FUNDED = 3;

    private int mCurrentSelectedTab = SELECTED_TAB_DEAL_PIPELINE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

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

        // sidemenu
        sideMenu = (RelativeLayout) findViewById(R.id.side_menu);
        scrollviewHolder = (ScrollView) findViewById(R.id.scrollview_holder);
        mSidemenuDashboardTextview = (TextView) findViewById(R.id.sidemenu_dashboard_textview);
        mSidemenuMerchantAppTextview = (TextView) findViewById(R.id.sidemenu_merchant_app_textview);
        mSidemenuSavedAppTextview = (TextView) findViewById(R.id.sidemenu_saved_app_textview);
        mSidemenuFundingProgramTextview = (TextView) findViewById(R.id.sidemenu_funding_program_textview);
        mSidemenuCommunicationTextview = (TextView) findViewById(R.id.sidemenu_communication_textview);
        mVersionTextview = (TextView) findViewById(R.id.version_textview);
        mLogoutTextview = (TextView) findViewById(R.id.logout_textview);
        mVersionTextview.setText(getResources().getString(R.string.sidemenu_version) + " " + BuildConfig.VERSION_NAME);

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
                break;

            case R.id.sidemenu_dashboard_textview:
                break;

            case R.id.sidemenu_merchant_app_textview:
                break;

            case R.id.sidemenu_saved_app_textview:
                break;

            case R.id.sidemenu_funding_program_textview:
                break;

            case R.id.sidemenu_communication_textview:
                break;

            case R.id.right_menu_imageview:
/*
                BaseInputConnection mInputConnection = new BaseInputConnection(v, true);
                KeyEvent kd = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MENU);
                KeyEvent ku = new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_MENU);
                mInputConnection.sendKeyEvent(kd);
                mInputConnection.sendKeyEvent(ku);*/
                //openOptionsMenu();
                //getSupportActionBar().openOptionsMenu();
                //DashboardActivity.this.openOptionsMenu();
                //openContextMenu(v);


             /*   PopupMenu popup = new PopupMenu(this, v);
                MenuInflater inflater = popup.getMenuInflater();
                inflater.inflate(R.menu.dashboard, popup.getMenu());
                popup.show();*/

               /* Intent intent = new Intent(this,RightMenuActivity.class);
                startActivity(intent);*/
                break;

            default:
                break;
        }
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
