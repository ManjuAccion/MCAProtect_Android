package org.mcaprotect.broker.network.response.model;

import java.io.Serializable;

/**
 * Created by Accionlabs on 2/8/2017.
 */

public class ApplicationState implements Serializable{
/*
    "application_state_id": 1,
            "application_state_name": "New",
            "application_count": 2,
            "sum": 38888,
            "average": 19444,
            "deals_funded": 0*/


    private int application_state_id, application_count, sum, average,deals_funded;
    private String application_state_name;


    public ApplicationState(int application_state_id, int application_count, int sum, int average, int deals_funded, String application_state_name) {
        this.application_state_id = application_state_id;
        this.application_count = application_count;
        this.sum = sum;
        this.average = average;
        this.deals_funded = deals_funded;
        this.application_state_name = application_state_name;
    }

    public int getApplication_state_id() {
        return application_state_id;
    }

    public void setApplication_state_id(int application_state_id) {
        this.application_state_id = application_state_id;
    }

    public int getApplication_count() {
        return application_count;
    }

    public void setApplication_count(int application_count) {
        this.application_count = application_count;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getAverage() {
        return average;
    }

    public void setAverage(int average) {
        this.average = average;
    }

    public int getDeals_funded() {
        return deals_funded;
    }

    public void setDeals_funded(int deals_funded) {
        this.deals_funded = deals_funded;
    }

    public String getApplication_state_name() {
        return application_state_name;
    }

    public void setApplication_state_name(String application_state_name) {
        this.application_state_name = application_state_name;
    }
}
