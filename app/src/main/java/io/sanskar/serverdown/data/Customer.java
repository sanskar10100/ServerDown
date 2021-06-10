package io.sanskar.serverdown.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "customers")
public class Customer {

    @PrimaryKey
    @ColumnInfo (name = "account_number")
    public int accountNumber;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "email")
    public String email;

    @ColumnInfo(name = "balance")
    public int balance;

    public Customer(int accountNumber, String name, String email, int balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.email = email;
        this.balance = balance;
    }

    public Customer() {

    }
}
