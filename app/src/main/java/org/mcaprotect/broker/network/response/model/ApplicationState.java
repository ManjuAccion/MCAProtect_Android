package org.mcaprotect.broker.network.response.model;

/**
 * Created by Accionlabs on 2/8/2017.
 */

public class ApplicationState {
/*
    "application_state_id": 1,
            "application_state_name": "New",
            "application_count": 2,
            "sum": 38888,
            "average": 19444,
            "deals_funded": 0*/


    public int
            application_state_id,
            application_count,
            sum,
            average,
            deals_funded;
    public String application_state_name;

    public ApplicationState(int application_state_id,
                            int application_count,
                            int sum,
                            int average,
                            int deals_funded,
                            String application_state_name) {


        this.application_state_id = application_state_id;
        this.application_count = application_count;
        this.sum = sum;
        this.average = average;
        this.deals_funded = deals_funded;
        this.application_state_name = application_state_name;


    }


}
