package com.rodzyn.homework07.service;

import com.rodzyn.homework07.model.Cars;
import com.rodzyn.homework07.model.Range;
import com.rodzyn.homework07.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
        carRepository.deleteAllCars();
        carRepository.saveCar(1L, "Fiat", "126p", "blue", 1994L);
        carRepository.saveCar(2L, "Polonez", "Caro", "red", 1997L);
        carRepository.saveCar(3L, "Audi", "Q8", "white", 2017L);
        carRepository.saveCar(4L, "Kia", "Ceed", "black", 2016L);
    }

    public List<Cars> getAllCars(){
        return carRepository.getAllCar();
    }

    public void saveCar(long carId, String mark, String model, String color, long productionYear){
        carRepository.saveCar(carId, mark, model, color, productionYear);
    }

    public void updateCar(Cars newCar){
        carRepository.updateCar(newCar);
    }

    public void deleteCar(long id){
        carRepository.deleteCar(id);
    }

    public Cars getCarById(long id){
        return carRepository.getCarById(id);
    }

    public List<Cars> getCarsByYears(long start, long end){
        return carRepository.getCarByYear(start, end);
    }

    private Range newRange = new Range();

    public Range getNewRange() {
        return newRange;
    }

    public void setNewRange(Range newRange) {
        this.newRange = newRange;
    }

}
