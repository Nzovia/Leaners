package com.programmer.leaners;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchViewActivity extends AppCompatActivity {
    ListView listView;
    SearchView searchView;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view);
        listView=(ListView)findViewById(R.id.listview);
        searchView=(SearchView)findViewById(R.id.searchView);

        list=new ArrayList<>();
        list.add("Java");
        list.add("Python");list.add("Kotlin");list.add("Go");list.add("Swift");list.add("C#");list.add("Linux");
        list.add("PHP");list.add("Visual basics");list.add("Haloop");list.add("R lang");list.add("Ai");
        list.add("DataSciencee");

        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice,list);
        listView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(list.contains(query)){
                    adapter.getFilter().filter(query);
                }else {
                    Toast.makeText(SearchViewActivity.this,"No match",Toast.LENGTH_LONG).show();
                }
                return false;

            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }
}
