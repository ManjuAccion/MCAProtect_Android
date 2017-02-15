package org.mcaprotect.broker.model;

/**
 * Created by Accionlabs on 2/15/2017.
 */

public class DealsFundedGraph {

    private String itemName;
    private double  fundValue;
    private double barHeight;

    public DealsFundedGraph(String itemName, double fundValue, double barHeight) {
        this.itemName = itemName;
        this.fundValue = fundValue;
        this.barHeight = barHeight;
    }



    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getFundValue() {
        return fundValue;
    }

    public void setFundValue(double fundValue) {
        this.fundValue = fundValue;
    }

    public double getBarHeight() {
        return barHeight;
    }

    public void setBarHeight(double barHeight) {
        this.barHeight = barHeight;
    }
}
