package org.mcaprotect.broker.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import org.mcaprotect.broker.R;

/**
 * Created by al1383 on 2/8/2017.
 */


public class DialogUtils {
    private DialogUtils() {

    }

    public static boolean isContextValid(final Context context) {
        if (context == null || ((context instanceof Activity) && ((Activity) context).isFinishing()))
            return false;
        else
            return true;
    }

    /**
     * @param context      context of the view
     * @param errorMessage error message
     * @return dialog object in return
     */
    public static void fullScreenErrorDialogWithOkListener(final Context context, String errorMessage, String errorCode, String buttonName, View.OnClickListener okClickListener) {
        if (context == null)
            return;
        final Dialog dialog = new Dialog(context, android.support.design.R.style.Base_Theme_AppCompat_Light_DialogWhenLarge);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.sucess_popup_dialog);
        ((TextView) dialog.findViewById(R.id.spread_text)).setText(errorMessage);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        Button okText = (Button) dialog.findViewById(R.id.ok_button);
        if(!buttonName.equals(context.getResources().getString(R.string.ok_button))){
            okText.setText(context.getResources().getString(R.string.continue_button));
        }

        okText.setOnClickListener(okClickListener);
        dialog.show();
    }

    /**
     * Progress dialog to be used for network calls
     * @param context context of the view
     * @return returns dialog object
     */
    public static Dialog getLoadingProgressDialog(Context context) {
        if (!isContextValid(context)) {
            return null;
        }
        Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.progressbar_layout);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setCancelable(false);
        return dialog;
    }
}
