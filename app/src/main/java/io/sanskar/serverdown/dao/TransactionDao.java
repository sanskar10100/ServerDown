package io.sanskar.serverdown.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.sanskar.serverdown.data.Transaction;

@Dao
public interface TransactionDao {

    @Insert
    void insertAll(Transaction... transactions);

    @Query("SELECT * FROM transactions")
    List<Transaction> getAllTransactions();
}
