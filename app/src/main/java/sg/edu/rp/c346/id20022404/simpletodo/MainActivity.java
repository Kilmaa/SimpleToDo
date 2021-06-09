package sg.edu.rp.c346.id20022404.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spanItem;
    EditText etElement;
    Button btnAdd, btnClear, btnRemove;
    ListView lvItem;
    ArrayList<String> alItems;
    ArrayAdapter<String> aaItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextItem);
        btnAdd = findViewById(R.id.buttonAdd);
        btnClear = findViewById(R.id.buttonClear);
        btnRemove = findViewById(R.id.buttonDelete);
        lvItem = findViewById(R.id.listViewList);

        spanItem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (spanItem.getSelectedItem().toString().equalsIgnoreCase("Add a new task")) {
                    etElement.setHint(getString(R.string.hintAdd));
                    btnAdd.setEnabled(true);
                    btnRemove.setEnabled(false);

                } else if (spanItem.getSelectedItem().toString().equalsIgnoreCase("Remove a task")) {
                    etElement.setHint(getString(R.string.hintRemove));
                    btnRemove.setEnabled(true);
                    btnAdd.setEnabled(false);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                if (spanItem.getSelectedItem() == "Add a new task") {
                    etElement.setHint(getString(R.string.hintAdd));
                    btnAdd.setEnabled(true);
                    btnRemove.setEnabled(false);

                } else if (spanItem.getSelectedItem() == "Remove a task") {
                    etElement.setHint(getString(R.string.hintRemove));
                    btnRemove.setEnabled(true);
                    btnAdd.setEnabled(false);
                }
            }
        });

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

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newItem = etElement.getText().toString();
                alItems.remove(newItem);
                aaItem.notifyDataSetChanged();
                etElement.setText("");
            }
        });
    }
}