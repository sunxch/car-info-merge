package com.xiaoheiwu.service.loader;


import com.xiaoheiwu.service.Car;

public abstract class SplitSignFileLoader extends BatchFileLoader {
    protected String splitSign = ",";
    protected Splitter splitter;

    public SplitSignFileLoader(String filePath, String splitSign, Splitter splitter) {
        super(filePath);
        this.filePath = filePath;
        this.splitSign = splitSign;
        this.splitter = splitter;
    }

    /**
     * @param line
     * @return
     */
    protected Car parserLine(String line) {
        String[] words = line.toUpperCase().split(splitSign);
        Car car = new Car();
        parserId(car, words);
        parserBrand(car, words);
        parserSerial(car, words);
        parserModel(car, words);
        parserProductCountry(car, words);
        parserAddition(car, words);
        parserOutput(car, words);
        parserYear(car, words);
        return car;
    }

    protected void parserId(Car car, String[] words) {
        if (splitter.getIdIndex() == -1) throw new RuntimeException("id没有解析成功");
        car.setId(splitter.getSplitValueInt(words, splitter.getIdIndex()));
    }

    protected void parserBrand(Car car, String[] words) {
        if (splitter.getBrandNameIndex() == -1) throw new RuntimeException("Brand没有解析成功");
        car.setBrandName(splitter.getSplitValue(words, splitter.getBrandNameIndex()));
    }

    protected void parserSerial(Car car, String[] words){
        if (splitter.getSerialNameIndex() == -1) throw new RuntimeException("Serial没有解析成功");
        car.setSerialName(splitter.getSplitValue(words, splitter.getSerialNameIndex()));
    }

    protected void parserModel(Car car, String[] words){
        if (splitter.getModelNameIndex() == -1) throw new RuntimeException("Model没有解析成功");
        car.setModelName(splitter.getSplitValue(words, splitter.getModelNameIndex()));
    }

    protected abstract void parserProductCountry(Car car, String[] words);

    protected void parserAddition(Car car, String[] words){
        if (splitter.getAdditionsIndex() == -1) throw new RuntimeException("Additions没有解析成功");
        car.setAdditions(splitter.getSplitValue(words, splitter.getAdditionsIndex()).split(" "));
    }

    protected void parserOutput(Car car, String[] words) {
        if (splitter.getOutputIndex() == -1 || splitter.getOutputUnitIndex() == -1) throw new RuntimeException("Output没有解析成功");
        car.setOutput(splitter.getSplitValue(words, splitter.getOutputIndex()));
        car.setOutputUnit(splitter.getSplitValue(words, splitter.getOutputUnitIndex()));
    }

    protected void parserYear(Car car, String[] words) {
        if (splitter.getYearIndex() == -1 || splitter.getNewYearIndex() == -1) throw new RuntimeException("Year没有解析成功");
        String yearString = splitter.getSplitValue(words, splitter.getYearIndex());

        try {
            int year = Integer.valueOf(yearString);
            car.setYear(year);
            String newYearString = splitter.getSplitValue(words, splitter.getNewYearIndex());
            int newYear = Integer.parseInt(newYearString);
            car.setNewYear(newYear);
        } catch (Exception e) {
            throw new RuntimeException("Year没有解析成功", e);
        }
    }
}
