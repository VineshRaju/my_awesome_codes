/**
 * Author:    Vinesh Raju R
 * 
 * Copyright (c) 2017 Vinesh Raju R
 * Deposit-withdraw program over killed with thread!!!
 * Looks like I was learning java :P
 **/
import java.util.ArrayList;
import java.util.Scanner;

class MyBank {
    static Customer customer=new Customer(0);
    public static void main(String args[]) {
        ui();

    }

    private static void ui(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t\tBanking");
        System.out.println("\n1.Deposit\n2.Withdraw");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                new Mythread("deposit", customer).start();
                break;
            case 2:
                new Mythread("withdraw", customer).start();
                break;

        }
    }

    static class Customer {
        private int balance;

        public Customer( int balance) {
            this.balance = balance;
        }

        synchronized void transaction(String action) {
            Scanner in = new Scanner(System.in);
            if (action.equals("deposit")) {
                System.out.println("Enter amount to deposit:");
                balance += in.nextInt();
                System.out.println("Deposited!");
            } else if (action.equals("withdraw")) {
                System.out.println("Current balance: " + balance);
                int amount = in.nextInt();
                if (balance - amount > 0) {
                    balance -= amount;
                    System.out.println("Withdrawn!\nCurrent balance: " + balance);

                } else {
                    System.out.println("cannot Withdraw!\nCurrent balance: " + balance);
                }
            }
        }


    }

    static class Mythread extends Thread {
        Customer customer;

        Mythread(String s, Customer c) {
            super(s);
            System.out.println("Progress: " + this.getName() + "ing");
            customer = c;
        }

        public void run() {
            customer.transaction(this.getName());
            ui();
        }
    }



}
