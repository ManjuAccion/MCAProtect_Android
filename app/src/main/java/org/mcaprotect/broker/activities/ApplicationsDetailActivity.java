package org.mcaprotect.broker.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.mcaprotect.broker.R;
import org.mcaprotect.broker.fragments.DealPipelineFragment;
import org.mcaprotect.broker.network.response.model.ApplicationState;

public class ApplicationsDetailActivity extends AppCompatActivity {

    ApplicationState mApplicationState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applications_detail);

        mApplicationState = (ApplicationState)getIntent().getSerializableExtra(DealPipelineFragment.APPLICATION_STATE);
        TextView tv = new TextView(this);
        tv.setText(mApplicationState.getApplication_state_name());
        setContentView(tv);


    }
}
