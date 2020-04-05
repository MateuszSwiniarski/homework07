package com.rodzyn.homework07.repository;

import com.rodzyn.homework07.model.Cars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class CarRepositoryImp implements CarRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CarRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Cars> getAllCar() {
        List<Cars> carsList = new ArrayList<>();
        String sql = "SELECT * FROM cars";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        maps.stream().forEach(element -> carsList.add(new Cars(
                Long.parseLong(String.valueOf(element.get("car_id"))),
                String.valueOf(element.get("mark")),
                String.valueOf(element.get("model")),
                String.valueOf(element.get("color")),
                Long.parseLong(String.valueOf(element.get("production_year")))
        )));
        return carsList;
    }

    @Override
    public void saveCar(long carId, String mark, String model, String color, long productionYear) {
        Cars cars = new Cars(carId, mark, model, color, productionYear);
        String sql = "INSERT INTO cars VALUES(?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                cars.getCarId(), cars.getMark(), cars.getModel(), cars.getColor(), cars.getProductionYear());
    }

    @Override
    public void deleteCar(long id) {
        String sql = "DELETE FROM cars where cars.car_id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void updateCar(Cars newCar) {
        String sql = "UPDATE cars SET " +
                "cars.mark = ?, cars.model = ?, cars.color = ?, cars.production_year = ? WHERE cars.car_id = ?";
        jdbcTemplate.update(sql,
                newCar.getMark(), newCar.getModel(), newCar.getColor(), newCar.getProductionYear(), newCar.getCarId());
    }

    @Override
    public Cars getCarById(long id) {
        try {
            String sql = "SELECT * FROM cars WHERE car_id = ?";
            return jdbcTemplate.queryForObject(sql, (resultSet, i) -> new Cars(
                    resultSet.getLong("car_id"),
                    resultSet.getString("mark"),
                    resultSet.getString("model"),
                    resultSet.getString("color"),
                    resultSet.getLong("production_year")
            ), id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Cars> getCarByYear(long start, long end) {
        List<Cars> carsListByYears = new ArrayList<>();
        String sql = "SELECT * FROM cars WHERE production_year >=" + start + " AND production_year <= " + end;
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        maps.stream().forEach(element -> carsListByYears.add(new Cars(
                Long.parseLong(String.valueOf(element.get("car_id"))),
                String.valueOf(element.get("mark")),
                String.valueOf(element.get("model")),
                String.valueOf(element.get("color")),
                Long.parseLong(String.valueOf(element.get("production_year")))
        )));
        return carsListByYears;
    }

    @Override
    public void deleteAllCars() {
        String sql = "TRUNCATE cars";
        jdbcTemplate.update(sql);
    }
}
