package io.sanskar.serverdown.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.sanskar.serverdown.data.Customer;

@Dao
public interface CustomerDao {

    @Query("SELECT * FROM customers")
    List<Customer> getAllCustomers();

    @Insert
    void insertAll(Customer... customers);
}
