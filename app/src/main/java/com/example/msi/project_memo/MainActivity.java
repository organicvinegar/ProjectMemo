package com.example.msi.project_memo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> items;
    ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items = new ArrayList<String>();

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, items);
        final ListView listview = (ListView)findViewById(R.id.listview1);
        listview.setAdapter(adapter);

        Button makememo = (Button)findViewById(R.id.button);

        makememo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), MakeMemo.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {

            String title = data.getExtras().getString("title");
            String container = data.getExtras().getString("container");

            int count;
            count = adapter.getCount();

            items.add(title);

            adapter.notifyDataSetChanged();

        }
    }
}
