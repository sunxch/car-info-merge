package com.xiaoheiwu.service.loader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.xiaoheiwu.service.Car;

/**
 * BatchFileLoader
 *
 * @author xiaochen.sun
 * @since 2016-02-19 11:51
 */
public abstract class BatchFileLoader extends AbstractLoader{
    protected String filePath = null;
    protected BufferedReader br = null;
    protected boolean fileFinish = false;
    protected int size = 10000;

    private Iterator<Car> cache = new ArrayList<Car>().iterator();

    public BatchFileLoader(String filePath) {
        this(filePath, 10000);
    }

    public BatchFileLoader(String filePath, int size) {
        try {
            this.filePath=filePath;
            this.size = size;
            this.br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "GBK"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void reset(){
        try {
            this.fileFinish = false;
            this.cache = new ArrayList<Car>().iterator();
            this.br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "GBK"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Iterator<Car> load() {
        return new Iterator<Car>() {
            @Override
            public boolean hasNext() {
                if (cache.hasNext()) {
                    return true;
                }
                cache = loadCache();
                return cache.hasNext();
            }

            @Override
            public Car next() {
                if (hasNext()) {
                    return cache.next();
                }
                return null;
            }

            @Override
            public void remove() {
                if (cache != null) cache.remove();
            }
        };
    }

    private Iterator<Car> loadCache() {
        List<Car> cars = new ArrayList<Car>();
        if (fileFinish) {
            return cars.iterator();
        }
        try {
            while(cars.size() <= size){
                String line = br.readLine();
                if (line == null) {
                    fileFinish = true;
                    break;
                }
                if(line.trim().equals(""))continue;
                Car car = parserLine(line);
                cars.add(car);
            }
            return cars.iterator();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    protected abstract Car parserLine(String line);
}
