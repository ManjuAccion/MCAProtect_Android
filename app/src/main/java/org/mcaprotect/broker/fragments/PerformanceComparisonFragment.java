package org.mcaprotect.broker.fragments;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;


import org.mcaprotect.broker.R;
import org.mcaprotect.broker.adapters.DealPipelineAdapter;
import org.mcaprotect.broker.adapters.DealsFundedGraphAdapter;
import org.mcaprotect.broker.adapters.PerformanceComparisonGraphAdapter;
import org.mcaprotect.broker.model.DealsFundedGraph;
import org.mcaprotect.broker.model.PerformanceComparisonGraph;
import org.mcaprotect.broker.network.response.model.ApplicationState;
import org.mcaprotect.broker.utils.UiUtils;

import java.util.ArrayList;


public class PerformanceComparisonFragment extends Fragment {

    private View mLayout;
    private Spinner mStartTimeSpinner,mEndTimeSpinner;
    ListView mPerformanceComparisonGraphListView;
    public PerformanceComparisonFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_performance_comparison, container, false);


         /*
         We store the root view in mLayout to preserve the fragment's view state upon popping out of
         backstack (onBackPressed)
          */
        if (mLayout == null) {
            // this is the first time onCreateView has been called
            mLayout = inflater.inflate(R.layout.fragment_performance_comparison, container, false);
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
    public void onAttach(Context context) {
        super.onAttach(context);
 /*       if (context instanceof OnFragmentInteractionListener) {
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
    private void initialiseViews(View view){

        mPerformanceComparisonGraphListView = (ListView)view.findViewById(R.id.performance_comparison_graph_listview);


        ArrayList<PerformanceComparisonGraph> list = new ArrayList<PerformanceComparisonGraph>();
        for (int i = 0; i < 20; i++) {
            list.add(new PerformanceComparisonGraph("John Doe "+ i, 100 * Math.random(),100 * Math.random(),0,0));
        }

        double firstItemHighest = 0,secondItemHighest =0;
        if(list.size()>0){
            for (int i = 0;i<list.size();i++ ){
                if(firstItemHighest < list.get(i).getFirstItemValue()){
                    firstItemHighest = list.get(i).getFirstItemValue();
                }
                if(secondItemHighest < list.get(i).getSecondItemValue()){
                    secondItemHighest = list.get(i).getSecondItemValue();
                }
            }
        }
        for (int i = 0;i<list.size();i++ ){
            list.get(i).setFirstBarHeight((list.get(i).getFirstItemValue()/firstItemHighest)*100);
            list.get(i).setSecondBarHeight((list.get(i).getSecondItemValue()/secondItemHighest)*100);
        }
        PerformanceComparisonGraphAdapter cda = new PerformanceComparisonGraphAdapter(getActivity(), list);
        mPerformanceComparisonGraphListView.setAdapter(cda);




        UiUtils.regularTextView(new TextView[]{
                (TextView)view.findViewById(R.id.screen_title_textview),
                (TextView)view.findViewById(R.id.instruction_textview),
                (TextView)view.findViewById(R.id.start_time_range_label_textview),
                (TextView)view.findViewById(R.id.end_time_range_label_textview)});

       // UiUtils.lightTextView(new TextView[]{(TextView)view.findViewById(R.id.time_range_label_textview)});

    }





}
