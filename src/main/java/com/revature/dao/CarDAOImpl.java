package com.revature.dao;

import com.revature.beans.Car;
import com.revature.services.ConnectionService;

import java.math.BigDecimal;
import java.sql.*;

public class CarDAOImpl implements CarDAO {
    private static ConnectionService cs = ConnectionService.getInstance();
    private Connection connection = cs.getConnection();

    @Override
    public void saveCar(Car c) throws SQLException {
        String sql = "{ call INSERT_CAR(?,?,?,?,?,?,?)";
        CallableStatement stmt = connection.prepareCall(sql);
        stmt.setInt(1, c.getYear());
        stmt.setString(2, c.getMake());
        stmt.setString(3, c.getModel());
        stmt.setInt(4, c.getMileage());
        stmt.setDouble(5, c.getPrice().doubleValue());
        stmt.setDouble(6, c.getBalance().doubleValue());
        stmt.setInt(7, c.getOwnerId());
        stmt.execute();
    }

    @Override
    public Car getCar(int id) throws SQLException {
        String sql = "SELECT * FROM CAR WHERE CAR_ID = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();
        Car c = new Car();
        if (!rs.isBeforeFirst()) {
            return null;
        }
        while (rs.next()) {
            c.setId(rs.getInt("CAR_ID"));
            c.setYear(rs.getInt("CAR_YEAR"));
            c.setMake(rs.getString("CAR_MAKE"));
            c.setModel(rs.getString("CAR_MODEL"));
            c.setMileage(rs.getInt("CAR_MILEAGE"));
            c.setPrice(BigDecimal.valueOf(rs.getDouble("CAR_PRICE")));
            c.setBalance(BigDecimal.valueOf(rs.getDouble("CAR_BALANCE")));
            c.setOwnerId(rs.getInt("OWNER_ID"));
        }

        return c;
    }
}
