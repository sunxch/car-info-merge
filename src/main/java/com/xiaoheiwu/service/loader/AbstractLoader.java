package com.xiaoheiwu.service.loader;

import java.util.Iterator;
import java.util.List;

import com.xiaoheiwu.service.Car;
import com.xiaoheiwu.service.Loader;

public abstract class AbstractLoader implements Loader {
	protected Iterator<Car> it = null;
	public AbstractLoader(){
		it=load();
	}
	@Override
	public boolean hasNext() {
		return it.hasNext();
	}

	@Override
	public Car next() {
		return it.next();
	}

	@Override
	public void remove() {
		it.remove();
	}

	protected abstract Iterator<Car>  load();

	public List<Car> getAllCars(){
		throw new RuntimeException("cant getAllCars");
	}
}
