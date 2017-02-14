package org.mcaprotect.broker.utils;

import android.content.Context;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import org.mcaprotect.broker.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Nagarjuna <nagarjuna.reddy@accionlabs.com>
 * @since 7/2/2017
 */
public class Utils {

    private Utils() {

    }

    /*email validation*/
    public static boolean validateEmail(EditText editText) {

        if (TextUtils.isEmpty(editText.getText().toString())) {
            return false;
        }
        String EMAIL_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(editText.getText().toString());
        return matcher.matches();
    }

    /*mobile number validation*/
    public static final boolean isValidPhoneNumber(CharSequence target) {
        if (target.length() < 6 || target.length() > 13) {
            return false;
        } else {
            return android.util.Patterns.PHONE.matcher(target).matches();
        }
    }
}
