package io.sanskar.serverdown.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "transactions")
public class Transaction {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "transaction_number")
    public int transactionNumber;

    @ColumnInfo(name = "debit_account_number")
    public int debitAccountNumber;

    @ColumnInfo(name = "credit_account_number")
    public int creditAccountNumber;

    @ColumnInfo(name = "debit_account_name")
    public String debitAccountName;

    @ColumnInfo(name = "credit_account_name")
    public String creditAccountName;

    @ColumnInfo(name = "amount")
    public int amount;


    public Transaction(int debitAccountNumber, int creditAccountNumber, String debitAccountName, String creditAccountName, int amount) {
        this.transactionNumber = 0;
        this.debitAccountNumber = debitAccountNumber;
        this.creditAccountNumber = creditAccountNumber;
        this.debitAccountName = debitAccountName;
        this.creditAccountName = creditAccountName;
        this.amount = amount;
    }

    public Transaction() {

    }
}
