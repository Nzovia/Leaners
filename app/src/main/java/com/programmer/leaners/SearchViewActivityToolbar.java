package com.programmer.leaners;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;

import java.util.ArrayList;

public class SearchViewActivityToolbar extends AppCompatActivity {
    ListView listview;
    Button button;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view_toolbar);
        listview=(ListView) findViewById(R.id.listview);

        list=new ArrayList<>();
        list.add("Nicholas");
        list.add("Bernadette");
        list.add("Nicole");
        list.add("Mickei");
        list.add("Eric");
        list.add("EricSon");
        list.add("Patrick");
        list.add("Patricia");
        list.add("Wesley");
        list.add("Dancun");
        list.add("Brian");
        list.add("Borniface");
        list.add("Jeremy");
        list.add("Amos");
        list.add("Jeff");
        list.add("Afriend");
        list.add("Fidelia");
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
        listview.setAdapter(adapter);


        button=(Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(SearchViewActivityToolbar.this,AddContactActivity.class);
                        startActivity(i);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menuitems,menu);
        MenuItem SearchViewItem=menu.findItem(R.id.search);
        final SearchView searchView=(SearchView) MenuItemCompat.getActionView(SearchViewItem);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                searchView.clearFocus();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}
