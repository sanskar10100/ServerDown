package io.sanskar.serverdown;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import io.sanskar.serverdown.dao.CustomerDao;
import io.sanskar.serverdown.dao.TransactionDao;
import io.sanskar.serverdown.data.Customer;
import io.sanskar.serverdown.data.Transaction;

@Database(entities = {Customer.class, Transaction.class}, version = 1)
public abstract class ServerDownDatabase extends RoomDatabase {
    public abstract CustomerDao customerDao();
    public abstract TransactionDao transactionDao();
}
