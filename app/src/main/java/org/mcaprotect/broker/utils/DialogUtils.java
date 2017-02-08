package org.mcaprotect.broker.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import org.mcaprotect.broker.R;
import org.mcaprotect.broker.activities.LoginActivity;

/**
 * Created by al1383 on 2/8/2017.
 */


public class DialogUtils {
    private DialogUtils() {

    }

    /**
     * @param context      context of the view
     * @param errorMessage error message
     * @return dialog object in return
     */
    public static void fullScreenErrorDialogWithOkListener(final Context context, String errorMessage, String errorCode, View.OnClickListener okClickListener) {
        if (context == null)
            return;
        final Dialog dialog = new Dialog(context, android.support.design.R.style.Base_Theme_AppCompat_Light_DialogWhenLarge);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.sucess_popup_dialog);
        ((TextView) dialog.findViewById(R.id.spread_text)).setText(errorMessage);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        Button okText = (Button) dialog.findViewById(R.id.ok_button);

        okText.setOnClickListener(okClickListener);
        dialog.show();
    }
}
