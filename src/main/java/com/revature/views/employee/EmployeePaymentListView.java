package com.revature.views.employee;

import com.revature.beans.Car;
import com.revature.beans.Payment;
import com.revature.services.CarService;
import com.revature.services.PaymentService;

import java.util.ArrayList;

public class EmployeePaymentListView {
    private static CarService cs = CarService.getInstance();
    private static PaymentService ps = PaymentService.getInstance();

    public EmployeePaymentListView() {}

    public void display() {
        Integer carId = cs.getCarIdInput();
        Car c = cs.getCar(carId);
        ArrayList<Payment> carPayments = ps.getPayments(c);
        for (Payment p : carPayments) {
            ps.printPayment(p);
        }
    }
}
