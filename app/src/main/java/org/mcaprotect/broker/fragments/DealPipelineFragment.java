package org.mcaprotect.broker.fragments;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.mcaprotect.broker.R;
import org.mcaprotect.broker.adapters.DealPipelineAdapter;


public class DealPipelineFragment extends Fragment {
    private View mLayout;
    private RecyclerView mDealPipelineRecyclerView;
    private DealPipelineAdapter mDealPipelineAdapter;


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
        } else {
            // remove previous parent
            ViewParent parent = mLayout.getParent();
            if (parent != null)
                ((ViewGroup) parent).removeView(mLayout);
        }

        initialiseViews(mLayout);

        return mLayout;


    }

    private void initialiseViews(View view){

        mDealPipelineRecyclerView = (RecyclerView)view.findViewById(R.id.deal_pipeline_recyclerview);


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
