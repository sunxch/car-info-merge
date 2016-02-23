package com.xiaoheiwu.service.carmatchservice;

import java.util.List;
import java.util.Map;

import com.xiaoheiwu.service.Car;
import com.xiaoheiwu.service.CarMatchService;
import com.xiaoheiwu.service.loader.impl.ChebaoyangLoader;
import com.xiaoheiwu.service.loader.impl.LiyangLoader;
import com.xiaoheiwu.service.strategy.chebao2liyang.AodiStrategy;

public class Liyang2Chebaowang {
    public static void main(String[] args) {
        ChebaoyangLoader chebaoLoader = new ChebaoyangLoader("d:/tmp/carmodelv4.txt");
        LiyangLoader liyangLoader = new LiyangLoader("d:/tmp/liyang.aodi.txt");
//        while (loader.hasNext()) {
//            Car car = loader.next();
//            System.out.println(car);
//        }

        CarMatchService carMatchService = new CarMatchService(chebaoLoader, liyangLoader, new AodiStrategy());
        Map<Car, List<Car>> carListMap = carMatchService.matchCars();
        for (Map.Entry<Car, List<Car>> carListEntry : carListMap.entrySet()) {
            System.out.println("[" + carListEntry.getValue().size() + "] " + carListEntry.getKey() + " -> " + carListEntry.getValue());
        }
    }

}
