package io.sanskar.serverdown.data;

public class Transaction {
    public int debitAccountNumber;
    public int creditAccountNumber;
    public String debitAccountName;
    public String creditAccountName;
    public int amount;

    public Transaction(int debitAccountNumber, int creditAccountNumber, String debitAccountName, String creditAccountName, int amount) {
        this.debitAccountNumber = debitAccountNumber;
        this.creditAccountNumber = creditAccountNumber;
        this.debitAccountName = debitAccountName;
        this.creditAccountName = creditAccountName;
        this.amount = amount;
    }
}
