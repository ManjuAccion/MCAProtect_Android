package org.mcaprotect.broker.adapters;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.mcaprotect.broker.R;
import org.mcaprotect.broker.network.response.model.ApplicationState;
import org.mcaprotect.broker.utils.UiUtils;
import org.mcaprotect.broker.utils.Utils;

import java.util.ArrayList;

/**
 * Created by Accionlabs on 2/6/2017.
 */

public class DealPipelineAdapter extends RecyclerView.Adapter<DealPipelineAdapter.MyViewHolder> {

    Context mContext;
    ArrayList<ApplicationState> mPipelineApplicationList;
    View.OnClickListener mOnClickListener;

    public DealPipelineAdapter(Context context,ArrayList<ApplicationState> pipelineApplications, View.OnClickListener clickListener) {
        mContext = context;
        mPipelineApplicationList = pipelineApplications;
        mOnClickListener = clickListener;

    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_pipeline_item, parent, false);
        return new DealPipelineAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.parentLinearLayout.setOnClickListener(mOnClickListener);
        holder.parentLinearLayout.setTag(mPipelineApplicationList.get(position));
        holder.categoryNameTextView.setText(""+mPipelineApplicationList.get(position).getApplication_state_name());
        holder.numberOfApplicationsTextView.setText(""+mPipelineApplicationList.get(position).getApplication_count());
        holder.dealValueTextView.setText("$"+String.valueOf(mPipelineApplicationList.get(position).getSum()));
        holder.averageValueTextView.setText("$"+mPipelineApplicationList.get(position).getAverage());


        switch (position % 7 ){
            case 0:
                holder.leftStripView.setBackground(ContextCompat.getDrawable(mContext,R.drawable.left_strip_blue_bright));
                break;
            case 1:
                holder.leftStripView.setBackground(ContextCompat.getDrawable(mContext,R.drawable.left_strip_blue_dark));
                break;
            case 2:
                holder.leftStripView.setBackground(ContextCompat.getDrawable(mContext,R.drawable.left_strip_blue_light));
                break;
            case 3:
                holder.leftStripView.setBackground(ContextCompat.getDrawable(mContext,R.drawable.left_strip_green_light));
                break;
            case 4:
                holder.leftStripView.setBackground(ContextCompat.getDrawable(mContext,R.drawable.left_strip_orange_light));
                break;
            case 5:
                holder.leftStripView.setBackground(ContextCompat.getDrawable(mContext,R.drawable.left_strip_purple));
                break;
            case 6:
                holder.leftStripView.setBackground(ContextCompat.getDrawable(mContext,R.drawable.left_strip_red_light));
                break;
        }


    }

    @Override
    public int getItemCount() {
        return mPipelineApplicationList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView categoryNameTextView, numberOfApplicationsTextView,dealValueTextView,dealValueLabelTextView,averageValueTextView,averageValueLabelTextView;
        public View leftStripView;
        public LinearLayout parentLinearLayout;


        public MyViewHolder(View view) {
            super(view);

            categoryNameTextView = (TextView) view.findViewById(R.id.category_textview);
            numberOfApplicationsTextView = (TextView) view.findViewById(R.id.number_of_applications_textview);

            dealValueLabelTextView = (TextView) view.findViewById(R.id.deal_value_label_textview);
            dealValueTextView = (TextView) view.findViewById(R.id.deal_value_textview);

            averageValueLabelTextView = (TextView) view.findViewById(R.id.average_value_label_textview);
            averageValueTextView = (TextView) view.findViewById(R.id.average_value_textview);
            leftStripView = view.findViewById(R.id.left_strip_view);
            parentLinearLayout = (LinearLayout)view.findViewById(R.id.parentLinearLayout);


            UiUtils.lightTextView(new TextView[]{categoryNameTextView,numberOfApplicationsTextView,dealValueLabelTextView,averageValueLabelTextView});
            UiUtils.mediumTextView(new TextView[]{dealValueTextView,averageValueTextView});
        }
    }



}
