package io.sanskar.serverdown;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import io.sanskar.serverdown.dao.CustomerDao;
import io.sanskar.serverdown.data.Customer;

@Database(entities = {Customer.class}, version = 1)
public abstract class ServerDownDatabase extends RoomDatabase {
    public abstract CustomerDao customerDao();
}
