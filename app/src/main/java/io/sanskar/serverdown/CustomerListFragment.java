package io.sanskar.serverdown;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.Collections;

import io.sanskar.serverdown.adapters.CustomerListAdapter;
import io.sanskar.serverdown.adapters.data.Customer;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CustomerListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CustomerListFragment extends Fragment {

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


        RecyclerView recyclerView = view.findViewById(R.id.recyclerview_customer_list);
        recyclerView.setAdapter(new CustomerListAdapter(Collections.singletonList(new Customer(1, "Sanskar", "sanskar10100@gmail.com", 10000))));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}