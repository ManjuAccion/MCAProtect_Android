package org.mcaprotect.broker.utils;

import android.graphics.Typeface;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.nineoldandroids.animation.Animator;

import org.mcaprotect.broker.R;


/**
 * @author Nagarjuna <nagarjuna.reddy@accionlabs.com>
 * @since 7/2/2017
 */
public class UiUtils {
    private static boolean isBannerShowing; // A check to avoid multiple error banner

    private UiUtils() {

    }

    public static void mediumButton(Button[] viewFields) {
        for (Button fields : viewFields) {
            Typeface typeface = Typeface.createFromAsset(fields.getContext().getAssets(), "fonts/roboto.medium.ttf");
            fields.setTypeface(typeface);
        }
    }

    public static void mediumTextView(TextView[] viewFields) {
        for (TextView fields : viewFields) {
            Typeface typeface = Typeface.createFromAsset(fields.getContext().getAssets(), "fonts/roboto.medium.ttf");
            fields.setTypeface(typeface);
        }
    }

    public static void mediumEditView(EditText[] viewFields) {
        for (EditText fields : viewFields) {
            Typeface typeface = Typeface.createFromAsset(fields.getContext().getAssets(), "fonts/roboto.medium.ttf");
            fields.setTypeface(typeface);
        }
    }

    public static void regularButton(Button[] viewFields) {
        for (Button fields : viewFields) {
            Typeface typeface = Typeface.createFromAsset(fields.getContext().getAssets(), "fonts/roboto.regular.ttf");
            fields.setTypeface(typeface);
        }
    }

    public static void regularTextView(TextView[] viewFields) {
        for (TextView fields : viewFields) {
            Typeface typeface = Typeface.createFromAsset(fields.getContext().getAssets(), "fonts/roboto.regular.ttf");
            fields.setTypeface(typeface);
        }
    }

    public static void regularEditView(EditText[] viewFields) {
        for (EditText fields : viewFields) {
            Typeface typeface = Typeface.createFromAsset(fields.getContext().getAssets(), "fonts/roboto.regular.ttf");
            fields.setTypeface(typeface);
        }
    }

    public static void lightButton(Button[] viewFields) {
        for (Button fields : viewFields) {
            Typeface typeface = Typeface.createFromAsset(fields.getContext().getAssets(), "fonts/roboto.light.ttf");
            fields.setTypeface(typeface);
        }
    }

    public static void lightTextView(TextView[] viewFields) {
        for (TextView fields : viewFields) {
            Typeface typeface = Typeface.createFromAsset(fields.getContext().getAssets(), "fonts/roboto.light.ttf");
            fields.setTypeface(typeface);
        }
    }

    public static void lightEditView(EditText[] viewFields) {
        for (EditText fields : viewFields) {
            Typeface typeface = Typeface.createFromAsset(fields.getContext().getAssets(), "fonts/roboto.light.ttf");
            fields.setTypeface(typeface);
        }
    }

    public static void showErrorBanner (TextView textView, String message) {
        showErrorBanner(textView, message, false);
    }

    public static void showErrorBanner(final TextView textView, final String message, boolean success) {
        if(isBannerShowing)
            return;
        isBannerShowing = true;

        if (!textView.isShown()) {
            textView.setText(message);
            textView.setVisibility(View.VISIBLE);

            if (success)
                textView.setBackgroundColor(textView.getContext().getResources().getColor(R.color.green));
            else
                textView.setBackgroundColor(textView.getContext().getResources().getColor(R.color.error_banner_color));
        }
        YoYo.with(Techniques.SlideInDown).duration(McaConstants.ERROR_BANNER_DELAY).withListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                if (!textView.isShown()) {
                    textView.setText(message);
                    textView.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                YoYo.with(Techniques.SlideOutUp).duration(McaConstants.ERROR_BANNER_DELAY).delay(2 * McaConstants.ERROR_BANNER_DELAY).withListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        textView.setVisibility(View.INVISIBLE);
                        isBannerShowing = false;
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {
                    }
                }).playOn(textView);
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        }).playOn(textView);

    }
}
