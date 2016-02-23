package com.xiaoheiwu.service.loader.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.xiaoheiwu.service.Car;
import com.xiaoheiwu.service.loader.SplitSignFileLoader;

public class LiyangLoader extends SplitSignFileLoader{

	public LiyangLoader(String filePath) {
		super(filePath, "\t", new LiyangSplitter());
	}


	@Override
	protected void parserProductCountry(Car car, String[] words) {
		String word = words[6];
		if (word.equals("进口")) {
			car.setProductCountry(1);
		} else if (word.equals("国产")) {
			car.setProductCountry(0);
		} else {
			car.setProductCountry(-1);
		}
	}

	@Override
	protected void parserOutput(Car car, String[] words) {
		String additions = splitter.getSplitValue(words, splitter.getAdditionsIndex());
		Matcher matcher = Pattern.compile("(\\d+(\\.\\d+)?)([A-Z]*) .*").matcher(additions);
		if (matcher.matches()) {
			car.setOutput(matcher.group(1));
			car.setOutputUnit(matcher.group(3));
		}
	}

	@Override
	protected void parserYear(Car car, String[] words) {
		car.setNewYear(-1);
		car.setYear(Integer.parseInt(words[5]));
		car.setMonth(0);
	}

	public static void main(String[] args) {
		Matcher matcher = Pattern.compile("(\\d+(\\.\\d+)?)([A-Z]*) .*").matcher("2.8TFSI 双离合 35FSI quattro 舒适型");
		if (matcher.matches()) {
			System.out.println(matcher.group(1));
			System.out.println(matcher.group(3));
		}
	}
}
