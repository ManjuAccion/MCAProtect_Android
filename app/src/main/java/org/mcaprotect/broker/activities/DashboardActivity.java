package org.mcaprotect.broker.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.PopupMenu;
import android.view.MenuInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.mcaprotect.broker.R;
import org.mcaprotect.broker.custom_views.CustomTextView;
import org.mcaprotect.broker.fragments.DealPipelineFragment;
import org.mcaprotect.broker.fragments.DealsFundedFragment;
import org.mcaprotect.broker.fragments.PerformanceComparisonFragment;
import org.mcaprotect.broker.utils.UiUtils;

public class DashboardActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    DrawerLayout mDrawerLayout;
    private LinearLayout mDealPipelineLinearLayout, mPerformanceComparisonLinearLayout, mDealsFundedLinearLayout;
    private FrameLayout mContentDashboardFrameLayout;
    private ImageView mLeftMenuImageView, mRightMenuImageView;
    private Fragment mCurrentFragment, mDealPipelineFramgnet, mPerformanceComparisonFragment, mDealsFundedFragment;
    private TextView mBottomTabDealPipelineTextView,mBottomTabPerformanceComparisonTextView,mBottomTabDealsFundedTextView;


    private final int SELECTED_TAB_DEAL_PIPELINE = 1,
            SELECTED_TAB_PERFORMANCE_COMPARISON = 2,
            SELECTED_TAB_DEALS_FUNDED = 3;

    private int mCurrentSelectedTab = SELECTED_TAB_DEAL_PIPELINE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

     /*   FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
*/
        //   DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
/*        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();*/

       /* NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);*/

        initialiseViews();
        selectDealPipeline();

        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
    }


    private void initialiseViews() {

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mContentDashboardFrameLayout = (FrameLayout) findViewById(R.id.fragment_container);
        mDealPipelineLinearLayout = (LinearLayout) findViewById(R.id.deal_pipeline_linearlayout);
        mPerformanceComparisonLinearLayout = (LinearLayout) findViewById(R.id.performance_comparison_linearlayout);
        mDealsFundedLinearLayout = (LinearLayout) findViewById(R.id.deals_funded_linearlayout);
        mLeftMenuImageView = (ImageView) findViewById(R.id.left_menu_imageview);
        mRightMenuImageView = (ImageView) findViewById(R.id.right_menu_imageview);
        mBottomTabDealPipelineTextView = (TextView) findViewById(R.id.bottom_tab_deal_pipeline_textview) ;
        mBottomTabPerformanceComparisonTextView = (TextView) findViewById(R.id.bottom_tab_performance_comparison_textview) ;
        mBottomTabDealsFundedTextView = (TextView) findViewById(R.id.bottom_tab_deals_funded_textview) ;


        mDealPipelineLinearLayout.setOnClickListener(this);
        mPerformanceComparisonLinearLayout.setOnClickListener(this);
        mDealsFundedLinearLayout.setOnClickListener(this);
        mLeftMenuImageView.setOnClickListener(this);
        mRightMenuImageView.setOnClickListener(this);

        UiUtils.regularTextView(new TextView[]{mBottomTabDealPipelineTextView,mBottomTabPerformanceComparisonTextView,mBottomTabDealsFundedTextView});
        UiUtils.mediumTextView(new TextView[]{(TextView)findViewById(R.id.title_textview)});

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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
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
               // mDrawerLayout.openDrawer(GravityCompat.START);
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
        }


    }


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

                mBottomTabDealPipelineTextView.setTextColor(ContextCompat.getColor(this,R.color.bottom_bar_on_select_text_color));
                mBottomTabPerformanceComparisonTextView.setTextColor(ContextCompat.getColor(this,R.color.bottom_bar_text_color));
                mBottomTabDealsFundedTextView.setTextColor(ContextCompat.getColor(this,R.color.bottom_bar_text_color));

                break;

            case SELECTED_TAB_PERFORMANCE_COMPARISON:
                mDealPipelineLinearLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.bottom_bar_bg_color));
                mPerformanceComparisonLinearLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.bottom_bar_on_select_bg_color));
                mDealsFundedLinearLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.bottom_bar_bg_color));

                mBottomTabDealPipelineTextView.setTextColor(ContextCompat.getColor(this,R.color.bottom_bar_text_color));
                mBottomTabPerformanceComparisonTextView.setTextColor(ContextCompat.getColor(this,R.color.bottom_bar_on_select_text_color));
                mBottomTabDealsFundedTextView.setTextColor(ContextCompat.getColor(this,R.color.bottom_bar_text_color));
                break;

            case SELECTED_TAB_DEALS_FUNDED:
                mDealPipelineLinearLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.bottom_bar_bg_color));
                mPerformanceComparisonLinearLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.bottom_bar_bg_color));
                mDealsFundedLinearLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.bottom_bar_on_select_bg_color));

                mBottomTabDealPipelineTextView.setTextColor(ContextCompat.getColor(this,R.color.bottom_bar_text_color));
                mBottomTabPerformanceComparisonTextView.setTextColor(ContextCompat.getColor(this,R.color.bottom_bar_text_color));
                mBottomTabDealsFundedTextView.setTextColor(ContextCompat.getColor(this,R.color.bottom_bar_on_select_text_color));
                break;

        }


    }

}
