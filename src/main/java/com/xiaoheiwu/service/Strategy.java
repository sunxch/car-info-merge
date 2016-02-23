package com.xiaoheiwu.service;

public interface  Strategy {

    public boolean isDebug();

	public boolean match(Car orig, Car dest);
	public boolean matchBrand(Car orig, Car dest);
	public boolean matchSerial(Car orig, Car dest);
	public boolean matchProductCountry(Car orig, Car dest);
	public boolean matchAddition(Car orig, Car dest);
	public boolean matchOutput(Car orig, Car dest);
	public boolean matchYear(Car orig, Car dest);

	public boolean isSimilar(Car orig, Car dest);
	public boolean isSimilarBrand(Car orig, Car dest);
	public boolean isSimilarSerial(Car orig, Car dest);
	public boolean isSimilarProductCountry(Car orig, Car dest);
	public boolean isSimilarAddition(Car orig, Car dest);
	public boolean isSimilarOutput(Car orig, Car dest);
	public boolean isSimilarYear(Car orig, Car dest);

}
