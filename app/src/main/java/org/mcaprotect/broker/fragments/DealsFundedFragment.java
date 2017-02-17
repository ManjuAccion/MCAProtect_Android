package org.mcaprotect.broker.fragments;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ListView;
import android.widget.TextView;


import org.mcaprotect.broker.R;
import org.mcaprotect.broker.model.DealsFundedGraph;
import org.mcaprotect.broker.adapters.DealsFundedGraphAdapter;
import org.mcaprotect.broker.utils.UiUtils;

import java.util.ArrayList;

public class DealsFundedFragment extends Fragment   {

    private View mLayout;
    ListView mDealsFundedGraphListView;



    public DealsFundedFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
           /*
         We store the root view in mLayout to preserve the fragment's view state upon popping out of
         backstack (onBackPressed)
          */
        if (mLayout == null) {
            // this is the first time onCreateView has been called
            mLayout = inflater.inflate(R.layout.fragment_deals_funded, container, false);
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
        //mListener = null;
    }

    private void initialiseViews(View view){

        mDealsFundedGraphListView = (ListView)view.findViewById(R.id.deals_funded_graph_listview);


        ArrayList<DealsFundedGraph> list = new ArrayList<DealsFundedGraph>();
        for (int i = 0; i < 20; i++) {
            list.add(new DealsFundedGraph("John Doe Avinash Jadaun Ashish "+ i, 1000000 * Math.random(),0));
        }

        double highest = 0;
        if(list.size()>0){
            for (int i = 0;i<list.size();i++ ){
                if(highest < list.get(i).getFundValue()){
                    highest = list.get(i).getFundValue();
                }
            }
        }
        for (int i = 0;i<list.size();i++ ){
            list.get(i).setBarHeight((list.get(i).getFundValue()/highest)*100);     }
        DealsFundedGraphAdapter cda = new DealsFundedGraphAdapter(getActivity(), list);
        mDealsFundedGraphListView.setAdapter(cda);





        UiUtils.regularTextView(new TextView[]{
                (TextView)view.findViewById(R.id.screen_title_textview),
                (TextView)view.findViewById(R.id.instruction_textview)});

        // UiUtils.lightTextView(new TextView[]{(TextView)view.findViewById(R.id.time_range_label_textview)});

    }



}
