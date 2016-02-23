package com.xiaoheiwu.service.loader.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.xiaoheiwu.service.Car;
import com.xiaoheiwu.service.loader.BatchFileLoader;

/**
 * SimpleLoader
 *
 * @author xiaochen.sun
 * @since 2016-02-19 12:26
 */
public class SimpleLoader extends BatchFileLoader {

    public SimpleLoader(String filePath) {
        super(filePath, 10);
    }

    @Override
    protected Car parserLine(String line) {
        Car car = new Car();
        car.setBrandName(line);
        return car;
    }

    public static void main(String[] args) {
        Matcher matcher = Pattern.compile("(\\d+(.\\d+)?) ?(.*)").matcher("1.5");
        if (matcher.matches()) {
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(3));
        }
    }
}
