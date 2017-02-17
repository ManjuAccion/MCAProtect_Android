package org.mcaprotect.broker.model;

/**
 * Created by Avinash 1386 on 2/16/2017.
 */

public class PerformanceComparisonGraph {
    private String categoryName;
    private double firstItemValue, secondItemValue, itemHighestValue;
    private double firstBarHeightPercentage, secondBarHeightPercentage;

    public PerformanceComparisonGraph(String categoryName, double firstItemValue, double secondItemValue, double itemHighestValue, double firstBarHeightPercentage, double secondBarHeightPercentage) {
        this.categoryName = categoryName;
        this.firstItemValue = firstItemValue;
        this.secondItemValue = secondItemValue;
        this.itemHighestValue = itemHighestValue;
        this.firstBarHeightPercentage = firstBarHeightPercentage;
        this.secondBarHeightPercentage = secondBarHeightPercentage;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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

    public double getItemHighestValue() {
        return itemHighestValue;
    }

    public void setItemHighestValue(double itemHighestValue) {
        this.itemHighestValue = itemHighestValue;
    }

    public double getFirstBarHeightPercentage() {
        return firstBarHeightPercentage;
    }

    public void setFirstBarHeightPercentage(double firstBarHeightPercentage) {
        this.firstBarHeightPercentage = firstBarHeightPercentage;
    }

    public double getSecondBarHeightPercentage() {
        return secondBarHeightPercentage;
    }

    public void setSecondBarHeightPercentage(double secondBarHeightPercentage) {
        this.secondBarHeightPercentage = secondBarHeightPercentage;
    }
}
