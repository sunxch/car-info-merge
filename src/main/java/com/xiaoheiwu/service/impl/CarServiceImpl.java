package com.xiaoheiwu.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.xiaoheiwu.service.Car;
import com.xiaoheiwu.service.CarService;
import com.xiaoheiwu.service.Strategy;

public class CarServiceImpl implements CarService{
	private List<Car> origCars = null;
	public  CarServiceImpl(List<Car> origCars) {
		this.origCars = origCars;
	}
	@Override
	public List<Car> getSameCarInfo(Car car, Strategy strategy) {
		List<Car> matchCars=new ArrayList<Car>();
		for (Car orig : origCars){
			boolean match=strategy.match(orig, car);
			if(match){
				matchCars.add(orig);
			}
		}
		return matchCars;
	}

	@Override
	public List<Car> getSimilarCarInfo(Car car, Strategy strategy) {
		List<Car> similarCars=new ArrayList<Car>();
		for (Car orig : origCars){
			boolean issimilar=strategy.isSimilar(orig, car);
			if(issimilar){
				similarCars.add(orig);
			}
		}
		return similarCars;
	}


}
