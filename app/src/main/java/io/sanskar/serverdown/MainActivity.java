package io.sanskar.serverdown;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import io.sanskar.serverdown.data.Customer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Customers");
        Constants.database = Room.databaseBuilder(getApplicationContext(), ServerDownDatabase.class, "server-down")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
        instantiateCustomerDatabase();

        getSupportFragmentManager()
                .beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.fragment_container, CustomerListFragment.class, null)
                .commit();

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav_bar);
        bottomNav.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.action_customers: {
                    getSupportActionBar().setTitle("Customers");
                    getSupportFragmentManager()
                            .beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragment_container, CustomerListFragment.class, null)
                            .commit();
                    break;
                }

                case R.id.action_transactions: {
                    getSupportActionBar().setTitle("Transactions");
                    getSupportFragmentManager()
                            .beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragment_container, TransactionListFragment.class, null)
                            .commit();
                    break;
                }
            }

            item.setChecked(true);
            return true;
        });
    }

    private void instantiateCustomerDatabase() {
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        boolean firstLaunch = sharedPreferences.getBoolean("FIRST_LAUNCH", true);
        if (firstLaunch) {
            Customer[] customers = {
                    new Customer(1000, "Sauron", "sauron@mordor.com", 9999999),
                    new Customer(1001, "Frodo", "frogobaggins@gmail.com", 340097),
                    new Customer(1002, "Aragorn", "aragornelessar@gmail.com", 1297525),
                    new Customer(1003, "Samwise", "samgamgee@yahoo.com", 85890),
                    new Customer(1004, "Gandalf", "gandalf@protonmail.com", 9700),
                    new Customer(1005, "Elrond", "elrond@ymail.com", 72346523),
                    new Customer(1006, "Theoden", "theodenofrohan@gmail.com", 305785),
                    new Customer(1007, "Eomer", "eomer@mail.com", 132412),
                    new Customer(1008, "Legolas", "legolas@protonmail.com", 879912),
                    new Customer(1009, "Gimli", "gimlisonofgloin@gmail.com", 567743)
            };
            Constants.database.customerDao().insertAll(customers);
            sharedPreferences.edit().putBoolean("FIRST_LAUNCH", false).apply();
        }
    }
}