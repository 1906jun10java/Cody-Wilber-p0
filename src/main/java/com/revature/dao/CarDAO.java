package com.revature.dao;

import com.revature.beans.Car;

import java.sql.SQLException;

public interface CarDAO {
    void saveCar(Car c) throws SQLException;
    Car getCar(int id) throws SQLException;
}
