package com.xiaoheiwu.service;

import java.util.Arrays;

public class Car {
    private Integer id;
    private String brandName;
    private String serialName;
    private String modelName; // liyang字段. 跟serialName做参考
    private int productCountry = -1; //不区分国产，进口；0国产；1进口
    private String[] additions; //附加条件
    private String output;
    private String outputUnit;
    private int year;
    private int month = 0;
    private int newYear = -1; //0:表示旧款，1表示新款；-1表示不区分新旧

    public Integer getId() {
        return id;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getSerialName() {
        return serialName;
    }

    public int getProductCountry() {
        return productCountry;
    }

    public String[] getAdditions() {
        return additions;
    }

    public String getOutput() {
        return output;
    }

    public String getOutputUnit() {
        return outputUnit;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getNewYear() {
        return newYear;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setSerialName(String serialName) {
        this.serialName = serialName;
    }

    public void setProductCountry(int productCountry) {
        this.productCountry = productCountry;
    }

    public void setAdditions(String[] additions) {
        this.additions = additions;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public void setOutputUnit(String outputUnit) {
        this.outputUnit = outputUnit;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setNewYear(int newYear) {
        this.newYear = newYear;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    @Override
    public String toString(){
        return simpleInfo();
    }

    public String info() {
        final StringBuffer sb = new StringBuffer("Car{");
        sb.append("id=").append(id);
        sb.append(", brandName='").append(brandName).append('\'');
        sb.append(", serialName='").append(serialName).append('\'');
        sb.append(", productCountry=").append(productCountry);
        sb.append(", additions=").append(additions == null ? "null" : Arrays.asList(additions).toString());
        sb.append(", output='").append(output).append('\'');
        sb.append(", outputUnit='").append(outputUnit).append('\'');
        sb.append(", year=").append(year);
        sb.append(", month=").append(month);
        sb.append(", newYear=").append(newYear);
        sb.append('}');
        return sb.toString();
    }

    public String simpleInfo() {
        final StringBuffer sb = new StringBuffer("Car{");
        sb.append("id=").append(id);
        sb.append(", ").append(brandName);
        sb.append(", ").append(serialName).append("/").append(modelName);
        sb.append(", ").append(output).append(' ').append(outputUnit);
        sb.append(", ").append(year);
        sb.append('}');
        return sb.toString();
    }
}
