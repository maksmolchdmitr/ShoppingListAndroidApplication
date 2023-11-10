package maks.molch.dmitr.shoppinglistapp;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ShoppingItemViewHolder extends RecyclerView.ViewHolder {
    public TextView textView;

    public ShoppingItemViewHolder(@androidx.annotation.NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.text_item);
    }
}
