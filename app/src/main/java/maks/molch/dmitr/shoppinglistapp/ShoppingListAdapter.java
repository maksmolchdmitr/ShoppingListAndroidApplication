package maks.molch.dmitr.shoppinglistapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class ShoppingListAdapter extends RecyclerView.Adapter<ShoppingItemViewHolder> {
    private final LinkedList<String> data = new LinkedList<>();
    private final Context context;

    public ShoppingListAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @NonNull
    public ShoppingItemViewHolder onCreateViewHolder(ViewGroup parent, int ViewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_view, parent, false);
        return new ShoppingItemViewHolder(view);
    }

    public void onBindViewHolder(ShoppingItemViewHolder viewHolder, int position) {
        viewHolder.textView.setText(data.get(position));
    }

    public void addShoppingItem(String itemName) {
        if (!itemName.isEmpty()) {
            data.addLast(itemName);
            this.notifyItemInserted(getItemCount());
        } else {
            Toast.makeText(context, R.string.item_name_must_be_not_empty, Toast.LENGTH_SHORT).show();
        }
    }

    public void removeLastItem() {
        if (getItemCount() > 0) {
            data.removeLast();
            this.notifyItemRemoved(getItemCount());
        } else {
            Toast.makeText(context, R.string.no_items_left, Toast.LENGTH_SHORT).show();
        }
    }
}