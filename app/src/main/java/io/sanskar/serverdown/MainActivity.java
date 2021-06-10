package io.sanskar.serverdown;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    public final ServerDownDatabase databaseDefinition =
            Room.databaseBuilder(getApplicationContext(), ServerDownDatabase.class, "server-down").build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Customers");
        Constants.database = this.databaseDefinition;

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
}