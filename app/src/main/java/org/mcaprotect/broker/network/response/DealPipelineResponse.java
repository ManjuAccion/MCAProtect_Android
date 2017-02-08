package org.mcaprotect.broker.network.response;

import org.mcaprotect.broker.network.response.model.ApplicationState;

import java.util.ArrayList;

/**
 * Created by Accionlabs on 2/8/2017.
 */

public class DealPipelineResponse extends BaseResponse {


    public ArrayList<ApplicationState> data = new ArrayList<>();

}
