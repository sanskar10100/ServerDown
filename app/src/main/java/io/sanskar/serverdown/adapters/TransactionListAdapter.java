package io.sanskar.serverdown.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import io.sanskar.serverdown.R;
import io.sanskar.serverdown.data.Transaction;

public class TransactionListAdapter extends RecyclerView.Adapter<TransactionListAdapter.ViewHolder> {
    private List<Transaction> transactions;

    public TransactionListAdapter(final List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_transaction_single, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull TransactionListAdapter.ViewHolder holder, int position) {
        Transaction transaction = transactions.get(position);
        holder.creditAccountName.setText(transaction.creditAccountName);
        holder.creditAccountNumber.setText(String.valueOf(transaction.creditAccountNumber));
        holder.debitAccountNumber.setText(String.valueOf(transaction.debitAccountNumber));
        holder.debitAccountName.setText(transaction.debitAccountName);
        holder.amount.setText(String.valueOf(transaction.amount));
    }

    @Override
    public int getItemCount() {
        return transactions.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView creditAccountNumber;
        TextView creditAccountName;
        TextView debitAccountNumber;
        TextView debitAccountName;
        TextView amount;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            creditAccountNumber = itemView.findViewById(R.id.textView_credit_account_number);
            creditAccountName = itemView.findViewById(R.id.textView_credit_account_name);
            debitAccountNumber = itemView.findViewById(R.id.textView_debit_account_number);
            debitAccountName = itemView.findViewById(R.id.textView_debit_account_name);
            amount = itemView.findViewById(R.id.textView_transfer_amount);
        }
    }
}
