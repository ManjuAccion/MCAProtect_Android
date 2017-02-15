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
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;


import org.mcaprotect.broker.R;
import org.mcaprotect.broker.adapters.DealPipelineAdapter;
import org.mcaprotect.broker.network.response.model.ApplicationState;
import org.mcaprotect.broker.utils.UiUtils;

import java.util.ArrayList;


public class PerformanceComparisonFragment extends Fragment implements AdapterView.OnItemSelectedListener{

    private View mLayout;
    private Spinner mStartTimeSpinner,mEndTimeSpinner;

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
        mStartTimeSpinner = (Spinner)view.findViewById(R.id.start_time_spinner);
        mEndTimeSpinner = (Spinner)view.findViewById(R.id.end_time_spinner);

/*
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),R.array.time_range_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mStartTimeSpinner.setAdapter(adapter);
        mStartTimeSpinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity(),R.array.time_range_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mEndTimeSpinner.setAdapter(adapter2);
        mEndTimeSpinner.setOnItemSelectedListener(this);*/



        UiUtils.regularTextView(new TextView[]{
                (TextView)view.findViewById(R.id.screen_title_textview),
                (TextView)view.findViewById(R.id.instruction_textview),
                (TextView)view.findViewById(R.id.start_time_range_label_textview),
                (TextView)view.findViewById(R.id.end_time_range_label_textview)});

       // UiUtils.lightTextView(new TextView[]{(TextView)view.findViewById(R.id.time_range_label_textview)});

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
    protected float getRandom(float range, float startsfrom) {
        return (float) (Math.random() * range) + startsfrom;
    }



}
