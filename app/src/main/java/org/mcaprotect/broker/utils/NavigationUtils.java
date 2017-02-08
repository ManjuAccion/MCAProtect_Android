package org.mcaprotect.broker.utils;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.mcaprotect.broker.R;


/**
 * @author Nagarjuna <nagarjuna.reddy@accionlabs.com>
 * @since 7/2/2017
 */

public class NavigationUtils {

    public View mBaseView;
    public Context mContext;
    public ImageView backButton;
    public ImageView crossButton;
    public TextView headerTitle;


    public NavigationUtils(View view) {
        mBaseView = view;
        mContext = view.getContext();
        initHeader();
    }

    public void initHeader() {
        backButton = (ImageView) mBaseView.findViewById(R.id.back_imageview);
        crossButton = (ImageView) mBaseView.findViewById(R.id.cross_imageview);
        headerTitle = (TextView) mBaseView.findViewById(R.id.title_textview);
    }

    public void hideNavBar() {
        backButton.setVisibility(View.INVISIBLE);
        crossButton.setVisibility(View.INVISIBLE);
        headerTitle.setVisibility(View.INVISIBLE);
    }

    public void displayNavBar() {
        backButton.setVisibility(View.VISIBLE);
        crossButton.setVisibility(View.VISIBLE);
        headerTitle.setVisibility(View.VISIBLE);
    }

    public void hideLeftNavButton() {
        backButton.setVisibility(View.INVISIBLE);
    }

    public void displayLeftNavButton() {
        backButton.setVisibility(View.VISIBLE);
    }

    public void hideRightNavButton() {
        crossButton.setVisibility(View.INVISIBLE);
    }

    public void goneRightNavButton() {
        crossButton.setVisibility(View.GONE);
    }

    public void displayRightNavButton() {
        crossButton.setVisibility(View.VISIBLE);
    }

    public void setLeftNavButton(int drawableId) {
        backButton.setImageResource(drawableId);
    }

    public void setRightNavButton(int drawableId) {
        backButton.setImageResource(drawableId);
    }

    public void setLeftNavListener(View.OnClickListener listener) {
        backButton.setOnClickListener(listener);
    }

    public void setRightImage(int image) {
        crossButton.setImageResource(0);
        crossButton.setImageResource(image);
    }

    public void setRightNavListener(View.OnClickListener listener) {
        crossButton.setOnClickListener(listener);
    }

    public void setTitle(String title) {
        headerTitle.setText(title);
    }
}
