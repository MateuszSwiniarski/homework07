package com.rodzyn.homework07.controller;

import com.rodzyn.homework07.model.Cars;
import com.rodzyn.homework07.model.Range;
import com.rodzyn.homework07.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cars")
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public String getCars(Model model){
        model.addAttribute("cars", carService.getAllCars());
        model.addAttribute("addCar", new Cars());
        return "cars/cars";
    }

    @PostMapping
    public String addCar(Cars newCar){
        carService.saveCar(
                newCar.getCarId(), newCar.getColor(), newCar.getMark(), newCar.getColor(), newCar.getProductionYear());
        return "redirect:/cars";
    }

    @GetMapping("/years")
    public String getCarsByYears(Model model){
        model.addAttribute("range", new Range());
        model.addAttribute("years", carService.getCarsByYears(carService.getNewRange().getStart(), carService.getNewRange().getEnd()));
        return "cars/year";
    }

    @PostMapping("/years")
    public String postCarsByYears(Range range){
        carService.getNewRange().setStart(range.getStart());
        carService.getNewRange().setEnd(range.getEnd());
        return "redirect:/cars/years";
    }

    @GetMapping("/delete/{id}")
    public String deleteCarById(@PathVariable ("id") int id){
        carService.deleteCar(id);
        return "redirect:/cars";
    }

    @GetMapping("/{id}")
    public String getCarById(@PathVariable("id") long id, Model model){
        model.addAttribute("onecar", carService.getCarById(id));
        return "cars/onecar";
    }

    @GetMapping("/update/{id}")
    public String updateCarById(@PathVariable("id") long id, Model model){
        model.addAttribute("updatecar", carService.getCarById(id));
        return "cars/updatecar";
    }

    @PostMapping("/update")
    private String updateCarbyId(@ModelAttribute Cars updateCar){
        carService.updateCar(updateCar);
        return "redirect:/cars";
    }


}
