package com.revature.views.customer;

import com.revature.beans.Car;
import com.revature.beans.Payment;
import com.revature.services.CarService;
import com.revature.services.CustomerService;
import com.revature.services.PaymentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerPaymentAction {
    private static CustomerService cus = CustomerService.getInstance();
    private static CarService cs = CarService.getInstance();
    private static PaymentService ps = PaymentService.getInstance();
    private static Scanner sc = new Scanner(System.in);
    final static Logger logger = LogManager.getLogger(CustomerPaymentAction.class);

    CustomerPaymentAction() {}

    public void run() {
        int carId = cs.getCarIdInput();
        Car c = cs.getCar(carId);
        BigDecimal monthlyPayment = ps.calcMonthlyPayment(c);

        System.out.println("\nYour monthly payment is $" + monthlyPayment);
        System.out.println("Would you like to make a payment?");
        System.out.println("0. No");
        System.out.println("1. Yes");
        System.out.print(">>> ");
        Integer option = null;
        try {
            option = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("\nInvalid option.");
            sc.nextLine();
        }
        if (option == null) {
            System.out.println("\nInvalid option.");
            return;
        }

        switch (option) {
        case 0:
            System.out.println("\nDon't wait too long.");
            break;
        case 1:
            Integer customerId = cus.getCurrentCustomer().getId();
            Payment p = new Payment(monthlyPayment, customerId, c.getId());
            ps.savePayment(p);
            ps.updateCarBalance(c);
            System.out.println("\nThank you for your payment.");
            System.out.println("Your new balance is $" +
                c.getBalance().setScale(2, RoundingMode.HALF_UP));
            logger.info("NEW PAYMENT FROM CUSTOMER " + customerId);
            break;
        default:
            System.out.println("\nInvalid option.");
            break;
        }
    }
}
