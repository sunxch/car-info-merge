package com.xiaoheiwu.service.loader.impl;

import com.xiaoheiwu.service.loader.Splitter;

/**
 * LiyangSplitter
 *
 * @author xiaochen.sun
 * @since 2016-02-19 15:58
 */
public class LiyangSplitter extends Splitter {
    private int idIndex = 0;
    private int brandNameIndex = 1;
    private int serialNameIndex = 2;
    private int modelNameIndex = 3;
    private int productCountryIndex = 6;//不区分国产，进口；0国产；1进口
    private int additionsIndex = 7;
    private int outputIndex = 4;
    private int yearIndex = 5;

    @Override
    public int getIdIndex() {
        return idIndex;
    }

    @Override
    public int getBrandNameIndex() {
        return brandNameIndex;
    }

    @Override
    public int getSerialNameIndex() {
        return serialNameIndex;
    }

    @Override
    public int getProductCountryIndex() {
        return productCountryIndex;
    }

    @Override
    public int getAdditionsIndex() {
        return additionsIndex;
    }

    @Override
    public int getOutputIndex() {
        return outputIndex;
    }

    @Override
    public int getYearIndex() {
        return yearIndex;
    }

    @Override
    public int getModelNameIndex() {
        return modelNameIndex;
    }
}
