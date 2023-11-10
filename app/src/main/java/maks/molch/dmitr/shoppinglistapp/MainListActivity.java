package maks.molch.dmitr.shoppinglistapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainListActivity extends Activity {
    private EditText editText;
    private ShoppingListAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);

        editText = findViewById(R.id.editTextText);
        RecyclerView myRecyclerView = findViewById(R.id.my_recycler_view);

        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ShoppingListAdapter(this);
        myRecyclerView.setAdapter(adapter);
    }

//    private List<String> generateContent() {
//        return IntStream.range(0, 100)
//                .mapToObj(Integer::toString)
//                .map(s -> "Some name with #" + s)
//                .collect(Collectors.toList());
//    }

    public void addNewItem(View view) {
        adapter.addShoppingItem(editText.getText().toString());
        editText.setText("");
    }

    public void removeLastItem(View view) {
        adapter.removeLastItem();
    }
}
