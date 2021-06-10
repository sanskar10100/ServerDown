package io.sanskar.serverdown.adapters.data;

public class Customer {
    public int accountNumber;
    public String name;
    public String email;
    public int balance;

    public Customer(int accountNumber, String name, String email, int balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.email = email;
        this.balance = balance;
    }
}
