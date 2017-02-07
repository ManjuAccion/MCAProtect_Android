package org.mcaprotect.broker.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import org.mcaprotect.broker.R;
import org.mcaprotect.broker.fragments.DealPipelineFragment;
import org.mcaprotect.broker.fragments.DealsFundedFragment;
import org.mcaprotect.broker.fragments.PerformanceComparisonFragment;

public class DashboardActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener ,View.OnClickListener{

    private LinearLayout mDealPipelineLinearLayout,mPerformanceComparisonLinearLayout,mDealsFundedLinearLayout;
    private FrameLayout mContentDashboardFrameLayout;

    Fragment mCurrentFragment,mDealPipelineFramgnet,mPerformanceComparisonFragment,mDealsFundedFragment;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

     /*   FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
*/
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        initialiseViews();
    }


    private void initialiseViews(){

        mContentDashboardFrameLayout = (FrameLayout)findViewById(R.id.fragment_container);
        mDealPipelineLinearLayout = (LinearLayout)findViewById(R.id.deal_pipeline_linearlayout);
        mPerformanceComparisonLinearLayout = (LinearLayout)findViewById(R.id.performance_comparison_linearlayout);
        mDealsFundedLinearLayout = (LinearLayout)findViewById(R.id.deals_funded_linearlayout);


        mDealPipelineLinearLayout.setOnClickListener(this);
        mPerformanceComparisonLinearLayout.setOnClickListener(this);
        mDealsFundedLinearLayout.setOnClickListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.deal_pipeline_linearlayout:

                if(mDealPipelineFramgnet == null){
                    mDealPipelineFramgnet = new DealPipelineFragment();
                    mCurrentFragment = mDealPipelineFramgnet;
                    addFragment(mCurrentFragment);
                }else if(!(mCurrentFragment instanceof DealPipelineFragment)) {
                    mCurrentFragment = mDealPipelineFramgnet;
                    addFragment(mCurrentFragment);
                }



                break;
            case R.id.performance_comparison_linearlayout:
                if(mPerformanceComparisonFragment == null){
                    mPerformanceComparisonFragment = new PerformanceComparisonFragment();
                    mCurrentFragment = mPerformanceComparisonFragment;
                    addFragment(mCurrentFragment);
                }else if(!(mCurrentFragment instanceof PerformanceComparisonFragment)) {
                    mCurrentFragment = mPerformanceComparisonFragment;
                    addFragment(mCurrentFragment);
                }

                break;
            case R.id.deals_funded_linearlayout:
                if(mDealsFundedFragment == null){
                    mDealsFundedFragment = new DealsFundedFragment();
                    mCurrentFragment = mDealsFundedFragment;
                    addFragment(mCurrentFragment);
                }else if(!(mCurrentFragment instanceof DealsFundedFragment)) {
                    mCurrentFragment = mDealsFundedFragment;
                    addFragment(mCurrentFragment);
                }

                break;

        }



    }



    public void addFragment(Fragment fragment) {

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
}
