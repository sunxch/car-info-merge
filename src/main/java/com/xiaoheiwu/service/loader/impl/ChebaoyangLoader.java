package com.xiaoheiwu.service.loader.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.xiaoheiwu.service.Car;
import com.xiaoheiwu.service.loader.SplitSignFileLoader;

public class ChebaoyangLoader extends SplitSignFileLoader{

	List<Car> allCarList = null;

	public ChebaoyangLoader(String filePath) {
		super(filePath, "\t", new ChebaoSplitter());
	}

	@Override
	protected void parserProductCountry(Car car, String[] words) {
		String word = words[splitter.getSerialNameIndex()];
		if (word.contains("国产")) {
			car.setProductCountry(0);
		} else if (word.contains("进口")) {
			car.setProductCountry(1);
		} else {
			car.setProductCountry(-1);
		}
	}

	@Override
	protected void parserAddition(Car car, String[] words) {

	}

	@Override
	protected void parserModel(Car car, String[] words) {

	}

	@Override
	protected void parserOutput(Car car, String[] words) {
		String word = words[1];
		int lastBlank = word.lastIndexOf(" ");
		String outputString = word.substring(0, lastBlank);
		Matcher matcher = Pattern.compile("(\\d+(\\.\\d+)?) ?(.*)").matcher(outputString);
		if (matcher.matches()) {
			car.setOutput(matcher.group(1));
			car.setOutputUnit(matcher.group(3));
		} else {
			throw new RuntimeException("output解析失败: " + outputString);
		}
	}

	@Override
	protected void parserYear(Car car, String[] words) {
		String word = words[1];
		int lastBlank = word.lastIndexOf(" ");
		int year = Integer.parseInt(word.substring(lastBlank + 1));
		car.setYear(year);
		car.setMonth(0);
		car.setNewYear(-1);
	}

	public List<Car> getAllCars(){
		if (allCarList == null) {
			reset();
			allCarList = new ArrayList<Car>();
			while (hasNext()) {
				allCarList.add(next());
			}
		}
		return allCarList;
	}
}
