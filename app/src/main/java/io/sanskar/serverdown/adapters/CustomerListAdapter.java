package io.sanskar.serverdown.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import io.sanskar.serverdown.CustomerListFragment;
import io.sanskar.serverdown.R;
import io.sanskar.serverdown.data.Customer;

public class CustomerListAdapter extends RecyclerView.Adapter<CustomerListAdapter.ViewHolder> {
    private List<Customer> customers;
    private boolean transferMode = false;

    public CustomerListAdapter(final List<Customer> customers, final boolean transferMode) {
        this.customers = customers;
        this.transferMode = transferMode;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_customer_single, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CustomerListAdapter.ViewHolder holder, int position) {
        Customer customer = customers.get(position);
        holder.customerName.setText(customer.name);
        holder.customerEmail.setText(customer.email);
        holder.customerBalance.setText(String.valueOf(customer.balance));
        holder.customerAccountNumber.setText(String.valueOf(customer.accountNumber));
    }

    @Override
    public int getItemCount() {
        return customers.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView customerName;
        TextView customerEmail;
        TextView customerBalance;
        TextView customerAccountNumber;
        boolean collapsed = true;
        ConstraintLayout hiddenLayout;
        TextView transferMoneyButton;

        public ViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            customerName = itemView.findViewById(R.id.textView_customer_name);
            customerEmail = itemView.findViewById(R.id.textView_customer_email);
            customerBalance = itemView.findViewById(R.id.textView_customer_balance);
            customerAccountNumber = itemView.findViewById(R.id.textView_customer_account_number);
            hiddenLayout = itemView.findViewById(R.id.layout_customer_hidden);
            transferMoneyButton = itemView.findViewById(R.id.button_customer_transfer_money);

            itemView.setOnClickListener(v -> {
                if (collapsed) {
                    hiddenLayout.setVisibility(View.VISIBLE);
                    collapsed = false;
                } else {
                    hiddenLayout.setVisibility(View.GONE);
                    collapsed = true;
                }
            });

            transferMoneyButton.setOnClickListener(v -> {
                int itemPosition = getAdapterPosition();
                CustomerListFragment.transferAmount(itemPosition);

            });
        }
    }
}
