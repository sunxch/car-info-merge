package com.xiaoheiwu.service.loader;

public abstract class Splitter {
    private int idIndex = -1;
    private int brandNameIndex = -1;
    private int serialNameIndex = -1;
    private int modelNameIndex = -1;
    private int productCountryIndex = -1;//不区分国产，进口；0国产；1进口
    private int additionsIndex = -1;//附加条件
    private int outputIndex = -1;
    private int outputUnitIndex = -1;
    private int yearIndex = -1;
    private int monthIndex = -1;
    private int newYearIndex = -1;//0:表示旧款，1表示新款；-1表示不区分新旧

    public String getSplitValue(String[] words, int index) {
        if (index == -1) return null;
        return words[index];
    }
    public int getSplitValueInt(String[] words, int index) {
        String splitValue = getSplitValue(words, index);
        if (splitValue == null || splitValue.isEmpty()) return 0;
        return Integer.parseInt(splitValue);
    }

    public int getIdIndex() {
        return idIndex;
    }

    public int getBrandNameIndex() {
        return brandNameIndex;
    }

    public int getSerialNameIndex() {
        return serialNameIndex;
    }

    public int getProductCountryIndex() {
        return productCountryIndex;
    }

    public int getAdditionsIndex() {
        return additionsIndex;
    }

    public int getOutputIndex() {
        return outputIndex;
    }

    public int getOutputUnitIndex() {
        return outputUnitIndex;
    }

    public int getYearIndex() {
        return yearIndex;
    }

    public int getMonthIndex() {
        return monthIndex;
    }

    public int getNewYearIndex() {
        return newYearIndex;
    }

    public int getModelNameIndex() {
        return modelNameIndex;
    }
}
