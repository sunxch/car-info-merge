package com.xiaoheiwu.service.strategy.chebao2liyang;

import com.xiaoheiwu.service.Car;
import com.xiaoheiwu.service.strategy.AbstractStrategy;

/**
 * AodiStrategy
 *
 * @author xiaochen.sun
 * @since 2016-02-22 14:00
 */
public class AodiStrategy extends AbstractStrategy {
    @Override
    public boolean matchSerial(Car orig, Car dest) {
        String chebao = orig.getSerialName();
        String liyangSerial = dest.getSerialName();
        String modelName = dest.getModelName();
        return chebao.equals(liyangSerial) || chebao.equals(modelName);
    }

    @Override
    public boolean matchAddition(Car orig, Car dest) {
        return true;
    }

    @Override
    public boolean isSimilarSerial(Car orig, Car dest) {
        String chebao = orig.getSerialName();
        String liyangSerial = dest.getSerialName();
        String modelName = dest.getModelName();
        return liyangSerial.contains(chebao) || modelName.contains(chebao)
                || chebao.contains(liyangSerial) || chebao.contains(modelName);
    }

    @Override
    public boolean isSimilarAddition(Car orig, Car dest) {
        return matchAddition(orig, dest);
    }
}
