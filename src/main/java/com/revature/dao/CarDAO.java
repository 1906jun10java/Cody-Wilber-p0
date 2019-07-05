package com.revature.dao;

import com.revature.beans.Car;

import java.sql.SQLException;
import java.util.List;

public interface CarDAO {
    void saveCar(Car c) throws SQLException;
    Car getCar(int id) throws SQLException;
    List<Car> getUnownedCars() throws SQLException;
    List<Car> getCustomerCars(int customerId) throws SQLException;
    void updateCar(Car c) throws SQLException;
    void deleteCar(int id) throws SQLException;
}
