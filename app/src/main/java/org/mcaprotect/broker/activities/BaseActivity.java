package org.mcaprotect.broker.activities;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.mcaprotect.broker.utils.QLog;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        QLog.v("Class:" + ((Object) this).getClass().getSimpleName());
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        QLog.v("Class:" + ((Object) this).getClass().getSimpleName());
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        QLog.v("Class:" + ((Object) this).getClass().getSimpleName());
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        QLog.v("Class:" + ((Object) this).getClass().getSimpleName());
        super.onPause();
    }

    @Override
    protected void onStop() {
        QLog.v("Class:" + ((Object) this).getClass().getSimpleName());
        super.onStop();

    }

    @Override
    protected void onResume() {
        QLog.v("Class:" + ((Object) this).getClass().getSimpleName());
        super.onResume();
    }

    @Override
    protected void onStart() {
        QLog.v("Class:" + ((Object) this).getClass().getSimpleName());
        super.onStart();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        QLog.v("Class:" + ((Object) this).getClass().getSimpleName());
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onRestart() {
        QLog.v("Class:" + ((Object) this).getClass().getSimpleName());
        super.onRestart();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        QLog.v("Class:" + ((Object) this).getClass().getSimpleName());
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        QLog.v("Class:" + ((Object) this).getClass().getSimpleName());
        super.onRestoreInstanceState(savedInstanceState);
    }
}
