package com.rodzyn.homework07.repository;

import com.rodzyn.homework07.model.Cars;

import java.util.List;

public interface CarRepository {

    List<Cars> getAllCar();
    void saveCar(long carId, String mark, String model, String color, long productionYear);
    void deleteCar(long id);
    void updateCar(Cars newCar);
    Cars getCarById(long id);
    List<Cars> getCarByYear(int start, int end);
    void deleteAllCars();
}
