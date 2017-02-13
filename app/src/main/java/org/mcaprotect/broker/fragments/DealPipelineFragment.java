package org.mcaprotect.broker.fragments;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.mcaprotect.broker.R;
import org.mcaprotect.broker.activities.ApplicationsDetailActivity;
import org.mcaprotect.broker.adapters.DealPipelineAdapter;
import org.mcaprotect.broker.network.response.model.ApplicationState;
import org.mcaprotect.broker.utils.UiUtils;

import java.util.ArrayList;


public class DealPipelineFragment extends Fragment implements View.OnClickListener {
    private View mLayout;
    private RecyclerView mDealPipelineRecyclerView;
    private DealPipelineAdapter mDealPipelineAdapter;
    private RelativeLayout mSpinnerRelativeLayout;
    private ArrayList<ApplicationState> mPipelineApplicationList = new ArrayList<>();

    public static final String APPLICATION_STATE = "application_state";


    public DealPipelineFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {


         /*
         We store the root view in mLayout to preserve the fragment's view state upon popping out of
         backstack (onBackPressed)
          */
        if (mLayout == null) {
            // this is the first time onCreateView has been called
            mLayout = inflater.inflate(R.layout.fragment_deal_pipeline, container, false);
            initialiseViews(mLayout);
        } else {
            // remove previous parent
            ViewParent parent = mLayout.getParent();
            if (parent != null)
                ((ViewGroup) parent).removeView(mLayout);
        }



        return mLayout;


    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);




    }

    private void initialiseViews(View view){

        mDealPipelineRecyclerView = (RecyclerView)view.findViewById(R.id.deal_pipeline_recyclerview);
        mSpinnerRelativeLayout = (RelativeLayout)view.findViewById(R.id.spinnerRelativeLayout);

        mPipelineApplicationList.add(new ApplicationState(1,15,133000,200000,300000,"New"));
        mPipelineApplicationList.add(new ApplicationState(1,12,104400,204500,300000,"Underwriting"));
        mPipelineApplicationList.add(new ApplicationState(1,14,444444,200000,300000,"Need more stips"));
        mPipelineApplicationList.add(new ApplicationState(1,55,155000,333333,300000,"Funded"));
        mPipelineApplicationList.add(new ApplicationState(1,15,102134,200000,444444,"DNQ"));
        mPipelineApplicationList.add(new ApplicationState(1,55,156000,444444,300000,"Lost"));
        mPipelineApplicationList.add(new ApplicationState(1,35,106400,200000,222222,"Renewal"));
        mPipelineApplicationList.add(new ApplicationState(1,25,100210,200000,111111,"Demo"));
        mPipelineApplicationList.add(new ApplicationState(1,35,100340,200000,333333,"Test"));

        mDealPipelineAdapter = new DealPipelineAdapter(getActivity(),mPipelineApplicationList,this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mDealPipelineRecyclerView.setLayoutManager(mLayoutManager);
        mDealPipelineRecyclerView.setAdapter(mDealPipelineAdapter);


        UiUtils.regularTextView(new TextView[]{(TextView)view.findViewById(R.id.screen_title_textview),(TextView)view.findViewById(R.id.instruction_textview)});
        UiUtils.lightTextView(new TextView[]{(TextView)view.findViewById(R.id.time_selector_textview)});

    }

    private void updatePipelineList(){





    }
    @Override
    public void onClick(View v) {


        switch (v.getId()){
            case R.id.parentLinearLayout:
                ApplicationState objApplicationState = (ApplicationState) v.getTag();
                Intent intent = new Intent(getActivity(), ApplicationsDetailActivity.class);
                intent.putExtra(APPLICATION_STATE,objApplicationState);
                startActivity(intent);

                break;




        }

    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
  /*      if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
       // mListener = null;
    }



}
