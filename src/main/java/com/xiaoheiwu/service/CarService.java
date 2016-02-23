package com.xiaoheiwu.service;

import java.util.List;

public interface CarService {

	public List<Car> getSameCarInfo(Car car, Strategy strategy);
	
	public List<Car> getSimilarCarInfo(Car car, Strategy strategy);
}
