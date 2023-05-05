package service.impl;

import service.IConverterService;

public class ConverterServiceImpl implements IConverterService {
    @Override
    public double getResult(double currency, double rate) {
        return currency * rate;
    }
}
