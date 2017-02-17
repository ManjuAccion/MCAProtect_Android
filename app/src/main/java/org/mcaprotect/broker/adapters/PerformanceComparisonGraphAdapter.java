package org.mcaprotect.broker.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.mcaprotect.broker.R;
import org.mcaprotect.broker.activities.DashboardActivity;
import org.mcaprotect.broker.model.DealsFundedGraph;
import org.mcaprotect.broker.model.PerformanceComparisonGraph;

import java.util.ArrayList;

/**
 * Created by Accionlabs on 2/16/2017.
 */

public class PerformanceComparisonGraphAdapter extends ArrayAdapter<PerformanceComparisonGraph> {
    private Context mContext;
    private ArrayList<PerformanceComparisonGraph> mValues;

    public PerformanceComparisonGraphAdapter(Context context, ArrayList<PerformanceComparisonGraph> values) {
        super(context, -1, values);
        this.mContext = context;
        this.mValues = values;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {


        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.adapter_performance_comparison_graph_item, parent, false);

        TextView itemName = (TextView) rowView.findViewById(R.id.item_name_textview);
        TextView firstItemValueTextView = (TextView) rowView.findViewById(R.id.first_item_value_textview);
        TextView secondItemValueTextView = (TextView) rowView.findViewById(R.id.second_item_value_textview);

        LinearLayout firstBarLinearLayout = (LinearLayout)rowView.findViewById(R.id.first_bar_linearlayout);
        LinearLayout secondBarLinearLayout = (LinearLayout)rowView.findViewById(R.id.second_bar_linearlayout);

        itemName.setText(mValues.get(position).getItemName());
        firstItemValueTextView.setText("" + (int)mValues.get(position).getFirstItemValue());
        secondItemValueTextView.setText("" + (int)mValues.get(position).getSecondItemValue());

      /*  ViewTreeObserver viewTreeObserver = barParentLinearLayout.getViewTreeObserver();
        if(viewTreeObserver.isAlive()){
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    barParentLinearLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    ViewGroup.LayoutParams params =  barLinearLayout.getLayoutParams();
                    params.width = (int)(barParentLinearLayout.getMeasuredWidth()* mValues.get(position).getBarHeight()/100);
                    barLinearLayout.setLayoutParams(params);

                }
            });
        }*/
        ViewGroup.LayoutParams params =  firstBarLinearLayout.getLayoutParams();
        params.width = (int)(DashboardActivity.BAR_MAX_HEIGHT_PERFORMANCE_COMPARISON * mValues.get(position).getFirstBarHeight()/100);
        firstBarLinearLayout.setLayoutParams(params);

        ViewGroup.LayoutParams params2 =  secondBarLinearLayout.getLayoutParams();
        params2.width = (int)(DashboardActivity.BAR_MAX_HEIGHT_PERFORMANCE_COMPARISON * mValues.get(position).getSecondBarHeight()/100);
        secondBarLinearLayout.setLayoutParams(params2);

        return rowView;
    }



}