package com.eloszka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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