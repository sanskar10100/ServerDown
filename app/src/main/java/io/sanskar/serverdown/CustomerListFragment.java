package io.sanskar.serverdown;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import io.sanskar.serverdown.adapters.CustomerListAdapter;
import io.sanskar.serverdown.data.Customer;
import io.sanskar.serverdown.data.Transaction;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CustomerListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CustomerListFragment extends Fragment {

    private static RecyclerView recyclerView;
    private static List<Customer> customers;
    private static FragmentActivity activityContext;
    private static Customer debitCustomer = null;
    private static Customer creditCustomer = null;
    private static int transferAmount = 0;
    private static CustomerListFragment currentContext;

    public CustomerListFragment() {
        // Required empty public constructor
    }

    public static CustomerListFragment newInstance() {
        return new CustomerListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_customer_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        activityContext = requireActivity();
        currentContext = this;
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Customers");
        ((MainActivity) getActivity()).findViewById(R.id.bottom_nav_bar).setVisibility(View.VISIBLE);
        customers = Constants.database.customerDao().getAllCustomers();
        recyclerView = view.findViewById(R.id.recyclerview_customer_list);
        recyclerView.setAdapter(new CustomerListAdapter(customers, false));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    public static void beneficiarySelected(int itemPosition) {
        creditCustomer = customers.get(itemPosition);
        // Transfer the amount
        debitCustomer.balance -= transferAmount;
        creditCustomer.balance += transferAmount;
        Constants.database.customerDao().updateCustomers(debitCustomer, creditCustomer);
        Constants.database.transactionDao().insertAll(new Transaction(debitCustomer.accountNumber, creditCustomer.accountNumber, debitCustomer.name, creditCustomer.name, transferAmount));
        activityContext.getSupportFragmentManager()
                .beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragment_container, CustomerListFragment.class, null)
                .commit();
    }

    public static void transferAmount(int itemPosition) {
        Customer customer = customers.get(itemPosition);
        View inflatedLayout = activityContext.getLayoutInflater().inflate(R.layout.dialog_transfer_amount, null);
        AlertDialog dialog = new AlertDialog.Builder(activityContext)
                .setView(inflatedLayout)
                .setPositiveButton("Next", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Nada
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Nada
                    }
                }).create();

        dialog.show();

        EditText amountEditText = inflatedLayout.findViewById(R.id.editText_transfer_amount);
        Button positiveButton = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
        positiveButton.setOnClickListener(v -> {
            int amount = Integer.parseInt(amountEditText.getText().toString());
            if (amount > customer.balance) {
                Toast.makeText(activityContext, "Amount cannot be greater than the current balance!", Toast.LENGTH_SHORT).show();
            } else {
                transferAmount = amount;
                debitCustomer = customer;
                recyclerView.setAdapter(new CustomerListAdapter(customers, true));
                ((MainActivity) currentContext.getActivity()).getSupportActionBar().setTitle("Choose Beneficiary");
                ((MainActivity) currentContext.getActivity()).findViewById(R.id.bottom_nav_bar).setVisibility(View.GONE);
                dialog.dismiss();
            }
        });
    }
}