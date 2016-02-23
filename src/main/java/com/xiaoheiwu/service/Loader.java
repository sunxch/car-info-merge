package com.xiaoheiwu.service;

import java.util.Iterator;
import java.util.List;

public interface Loader extends Iterator<Car>{

    List<Car> getAllCars();
}
