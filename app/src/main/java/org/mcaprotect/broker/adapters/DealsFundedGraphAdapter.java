package org.mcaprotect.broker.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.mcaprotect.broker.R;
import org.mcaprotect.broker.model.DealsFundedGraph;

import java.util.ArrayList;

/**
 * Created by Accionlabs on 2/15/2017.
 */

public class DealsFundedGraphAdapter extends ArrayAdapter<DealsFundedGraph> {
    private Context mContext;
    private ArrayList<DealsFundedGraph> mValues;

    public DealsFundedGraphAdapter(Context context, ArrayList<DealsFundedGraph> values) {
        super(context, -1, values);
        this.mContext = context;
        this.mValues = values;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {


        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.adapter_deals_funded_graph, parent, false);

        TextView itemName = (TextView) rowView.findViewById(R.id.item_name_textview);
        final LinearLayout barLinearLayout = (LinearLayout)rowView.findViewById(R.id.bar_linearlayout);
        final LinearLayout barParentLinearLayout = (LinearLayout)rowView.findViewById(R.id.bar_parent_linearlayout);

        itemName.setText(mValues.get(position).getItemName());

        ViewTreeObserver viewTreeObserver = barParentLinearLayout.getViewTreeObserver();
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
        }

        return rowView;
    }



}