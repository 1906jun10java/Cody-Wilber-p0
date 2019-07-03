package com.revature.views.customer;

import com.revature.beans.Car;
import com.revature.beans.Payment;
import com.revature.services.CarService;
import com.revature.services.CustomerService;
import com.revature.services.PaymentService;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerPaymentAction {
    private static CustomerService cus = CustomerService.getInstance();
    private static CarService cs = CarService.getInstance();
    private static PaymentService ps = PaymentService.getInstance();
    private static Scanner sc = new Scanner(System.in);

    public CustomerPaymentAction() {}

    public void run() {
        Integer carId = cs.getCarIdInput();
        Car c = cs.getCar(carId);
        BigDecimal monthlyPayment = ps.calcMonthlyPayment(c);

        System.out.println("\nYour monthly payment is " + monthlyPayment);
        System.out.println("Would you like to make a payment?");
        System.out.println("0. No");
        System.out.println("1. Yes");
        System.out.println(">>> ");
        Integer option = null;
        try {
            option = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
            sc.nextLine();
        }

        switch (option) {
        case 0:
            System.out.println("\nDon't wait too long.");
            break;
        case 1:
            Integer customerId = cus.getCurrentCustomer().getId();
            Payment p = new Payment(monthlyPayment, customerId, c.getId());
            ps.addPayment(p);
            BigDecimal newBalance = ps.getNewCarBalance(c);
            c.setBalance(newBalance);
            cs.updateCar(c);
            System.out.println("\nThank you for your payment.");
            System.out.println("Your new balance is " + newBalance.setScale(2));
            break;
        default:
            System.out.println("\nInvalid option.");
            break;
        }
    }
}
