package sg.edu.rp.c346.id20022404.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etElement;
    Button btnAdd, btnClear;
    ListView lvItem;
    ArrayList<String> alItems;
    ArrayAdapter<String> aaItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColour);
        btnAdd = findViewById(R.id.buttonAdd);
        btnClear = findViewById(R.id.buttonClear);
        lvItem = findViewById(R.id.listViewList);

        alItems = new ArrayList<>();

        aaItem = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, alItems);
        lvItem.setAdapter(aaItem);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newItem = etElement.getText().toString();
                alItems.add(newItem);
                aaItem.notifyDataSetChanged();
                etElement.setText("");
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alItems.clear();
                aaItem.notifyDataSetChanged();
                etElement.setText("");
            }
        });
    }
}