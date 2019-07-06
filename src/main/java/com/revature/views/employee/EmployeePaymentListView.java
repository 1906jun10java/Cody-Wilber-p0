package com.revature.views.employee;

import com.revature.beans.Car;
import com.revature.beans.Payment;
import com.revature.services.CarService;
import com.revature.services.PaymentService;

import java.util.List;

public class EmployeePaymentListView {
    private static CarService cs = CarService.getInstance();
    private static PaymentService ps = PaymentService.getInstance();

    EmployeePaymentListView() {}

    public void display() {
        Integer carId = cs.getCarIdInput();
        Car c = cs.getCar(carId);
        List<Payment> carPayments = ps.getCarPayments(c);
        for (Payment p : carPayments) {
            ps.printPayment(p);
        }
    }
}
