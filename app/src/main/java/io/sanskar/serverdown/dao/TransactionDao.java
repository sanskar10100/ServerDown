package io.sanskar.serverdown.dao;

import androidx.room.Dao;
import androidx.room.Insert;

import io.sanskar.serverdown.data.Transaction;

@Dao
public interface TransactionDao {

    @Insert
    void insertAll(Transaction... transactions);
}
