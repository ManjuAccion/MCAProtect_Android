package org.mcaprotect.broker.model;

/**
 * Created by Accionlabs on 2/16/2017.
 */

public class PerformanceComparisonGraph {
    private String itemName;
    private double  firstItemValue,secondItemValue;
    private double firstBarHeight,secondBarHeight;

    public PerformanceComparisonGraph(String itemName, double firstItemValue, double secondItemValue, double firstBarHeight, double secondBarHeight) {
        this.itemName = itemName;
        this.firstItemValue = firstItemValue;
        this.secondItemValue = secondItemValue;
        this.firstBarHeight = firstBarHeight;
        this.secondBarHeight = secondBarHeight;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getFirstItemValue() {
        return firstItemValue;
    }

    public void setFirstItemValue(double firstItemValue) {
        this.firstItemValue = firstItemValue;
    }

    public double getSecondItemValue() {
        return secondItemValue;
    }

    public void setSecondItemValue(double secondItemValue) {
        this.secondItemValue = secondItemValue;
    }

    public double getFirstBarHeight() {
        return firstBarHeight;
    }

    public void setFirstBarHeight(double firstBarHeight) {
        this.firstBarHeight = firstBarHeight;
    }

    public double getSecondBarHeight() {
        return secondBarHeight;
    }

    public void setSecondBarHeight(double secondBarHeight) {
        this.secondBarHeight = secondBarHeight;
    }
}
