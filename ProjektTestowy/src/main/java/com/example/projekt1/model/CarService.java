package com.example.projekt1.model;

public class CarService {

    CarHisotryFeignClient client;
    public void saveCar(CarCreateRequest request) {
        Car car = new Car();
        car.setName(request.getName());
        car.setYearOfProduction(request.getYearOfProduction());
        car.setHistory(client.getHistory(request.getName()));
    }
}
