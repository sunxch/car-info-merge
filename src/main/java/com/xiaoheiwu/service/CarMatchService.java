package com.xiaoheiwu.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.xiaoheiwu.service.impl.CarServiceImpl;

public class CarMatchService {
	protected Loader destLoader = null;
	protected Strategy strategy = null;
	protected CarService carService = null;

	public CarMatchService(Loader origLoader, Loader destLoader,
			Strategy strategy) {
		this.destLoader = destLoader;
		this.strategy = strategy;
		this.carService = new CarServiceImpl(origLoader.getAllCars());
	}

	public CarMatchService(Loader destLoader, Strategy strategy,
			CarService carService) {
		this.destLoader = destLoader;
		this.strategy = strategy;
		this.carService = carService;
	}

	public Map<Car, List<Car>> matchCars() {
		return matchCars(destLoader);
	}

	public Map<Car, List<Car>> matchCars(Iterator<Car> destCars) {
		Map<Car, List<Car>> result = new HashMap<Car, List<Car>>();
		while (destCars.hasNext()) {
			Car car = destCars.next();
			List<Car> cars = carService.getSameCarInfo(car, strategy);
			result.put(car, cars);
		}
		return result;
	}

	public Map<Car, List<Car>> similarCars() {
		return similarCars(destLoader);
	}

	public Map<Car, List<Car>> similarCars(Iterator<Car> destCars) {
		Map<Car, List<Car>> result = new HashMap<Car, List<Car>>();
		while (destCars.hasNext()) {
			Car car = destCars.next();
			List<Car> cars = carService.getSimilarCarInfo(car, strategy);
			result.put(car, cars);
		}
		return result;
	}

}
