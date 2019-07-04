package com.revature.views.customer;

import com.revature.beans.Car;
import com.revature.beans.Customer;
import com.revature.beans.Payment;
import com.revature.services.CarService;
import com.revature.services.CustomerService;
import com.revature.services.PaymentService;

import java.util.ArrayList;

public class CustomerPaymentListView {
    private static CustomerService cus = CustomerService.getInstance();
    private static CarService cs = CarService.getInstance();
    private static PaymentService ps = PaymentService.getInstance();

    public CustomerPaymentListView() {}

    public void display() {
        Customer currentCustomer = cus.getCurrentCustomer();
        Integer carId = cs.getCarIdInput();
        Car c = cs.getCar(carId);
        if (c.getOwnerId().equals(currentCustomer.getId())) {
            ArrayList<Payment> carPayments = ps.getPayments(c);
            for (Payment p : carPayments) {
                ps.printPayment(p);
            }
        }
        else {
            System.out.println("\nThis is not your vehicle.");
        }
    }
}
