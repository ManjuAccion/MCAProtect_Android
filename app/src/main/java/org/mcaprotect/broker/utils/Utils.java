package org.mcaprotect.broker.utils;

import android.text.TextUtils;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Nagarjuna <nagarjuna.reddy@accionlabs.com>
 * @since 7/2/2017
 */
public class Utils {

    private Utils() {

    }

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
}
