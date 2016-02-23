package com.xiaoheiwu.service.strategy;

import com.xiaoheiwu.service.Car;
import com.xiaoheiwu.service.Strategy;

public abstract class AbstractStrategy implements Strategy {

	public boolean isDebug(){
		return false;
	}

	@Override
	public boolean match(Car orig, Car dest) {
		boolean a = this.matchAddition(orig, dest);
		boolean b = this.matchBrand(orig, dest);
		boolean o = this.matchOutput(orig, dest);
		boolean c = this.matchProductCountry(orig, dest);
		boolean s = this.matchSerial(orig, dest);
		boolean y = this.matchYear(orig, dest);
		if (isDebug()) {
			System.out.println(String.format("[DEBUG][MATCH]\t%s\t%s\t%b\t%b\t%b\t%b\t%b\t%b,", orig.simpleInfo(), dest.simpleInfo(), a, b, s, y, o, c));
		}

		return a && b && o && c && s && y;
	}

	@Override
	public boolean isSimilar(Car orig, Car dest) {
		boolean a = this.isSimilarAddition(orig, dest);
		boolean b = this.isSimilarBrand(orig, dest);
		boolean o = this.isSimilarOutput(orig, dest);
		boolean c = this.isSimilarProductCountry(orig, dest);
		boolean s = this.isSimilarSerial(orig, dest);
		boolean y = this.isSimilarYear(orig, dest);
		if (isDebug()) {
			System.out.println(String.format("[DEBUG][SIMILAR]\t%s\t%s\t%b\t%b\t%b\t%b\t%b\t%b,", orig.simpleInfo(), dest.simpleInfo(), a, b, s, y, o, c));
		}
		return a && b && o && c && s && y;

	}

	@Override
	public boolean matchBrand(Car orig, Car dest) {
		return orig.getBrandName().equals(dest.getBrandName());
	}

	@Override
	public boolean matchOutput(Car orig, Car dest) {
		return orig.getOutput().equals(dest.getOutput())
				&& orig.getOutputUnit().equals(dest.getOutputUnit());
	}


	@Override
	public boolean matchProductCountry(Car orig, Car dest) {
		return orig.getProductCountry() == -1
				|| dest.getProductCountry() == -1
				|| orig.getProductCountry() == dest.getProductCountry();
	}

	@Override
	public boolean matchYear(Car orig, Car dest) {
		return orig.getYear() == dest.getYear()
				&& (orig.getMonth() == 0 || dest.getMonth() == 0 || orig.getMonth() == dest.getMonth())
				&& (orig.getNewYear() == -1 || dest.getNewYear() == -1 || orig.getNewYear() == dest.getNewYear());
	}

	@Override
	public boolean isSimilarProductCountry(Car orig, Car dest) {
		return matchProductCountry(orig, dest);
	}

	@Override
	public boolean isSimilarYear(Car orig, Car dest) {
		return orig.getYear() == dest.getYear();
	}

	@Override
	public boolean isSimilarBrand(Car orig, Car dest) {
		return matchBrand(orig, dest);
	}

	@Override
	public boolean isSimilarOutput(Car orig, Car dest) {
		return orig.getOutput().equals(dest.getOutput());
	}
	
}
