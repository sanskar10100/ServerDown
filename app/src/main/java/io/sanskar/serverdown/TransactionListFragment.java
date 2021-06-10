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

import io.sanskar.serverdown.adapters.TransactionListAdapter;
import io.sanskar.serverdown.data.Transaction;

public class TransactionListFragment extends Fragment {

    public static TransactionListFragment newInstance() {
        return new TransactionListFragment();
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerview_transaction_list);
        recyclerView.setAdapter(new TransactionListAdapter(Collections.singletonList(new Transaction(001, 002, "Sanskar", "Som", 1000))));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
