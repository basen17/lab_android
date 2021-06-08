package com.eloszka.myapp1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private EditText editText;
    private Button button;
    private ListView listView;
    private ListAdapter listAdapter;
    private List<String> texts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
        listView = (ListView) findViewById(R.id.listView);

        texts = new ArrayList<>();
        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, texts);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder adb = new AlertDialog.Builder(ListActivity.this)
                        .setTitle("Usunąć element?")
                        .setMessage("Czy na pewno chcesz usunąć element?")
                        .setPositiveButton("Usuń", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                texts.remove(position);
                                Toast.makeText(getApplicationContext(), "Element został usunięty", Toast.LENGTH_LONG).show();
                                listView.invalidateViews();
                            }
                });
                adb.show();
            }
        });
    }

    public void addText(View v) {
        String text = editText.getText().toString();
        if (text.isEmpty()) {
            Toast.makeText(this, R.string.edittext_cant_be_empty, Toast.LENGTH_LONG).show();
        } else {
            texts.add(text);
            listView.invalidateViews();
            editText.getText().clear();
        }
    }
}