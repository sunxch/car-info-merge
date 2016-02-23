package com.xiaoheiwu.service.loader.impl;

import com.xiaoheiwu.service.loader.Splitter;

public class ChebaoSplitter extends Splitter {
    private int idIndex = 0;
    private int brandNameIndex = 2;
    private int serialNameIndex = 3;

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
}