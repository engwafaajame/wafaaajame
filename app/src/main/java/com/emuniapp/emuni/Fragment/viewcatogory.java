package com.emuniapp.emuni.Fragment;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.emuniapp.emuni.Activity.ThreeColumn_ListAdapter;
import com.emuniapp.emuni.Activity.ViewListContents;
import com.emuniapp.emuni.Adapter.MyAdapter;
import com.emuniapp.emuni.MainActivity;
import com.emuniapp.emuni.R;
import com.emuniapp.emuni.classes.Category;
import com.emuniapp.emuni.classes.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;


public class viewcatogory extends Fragment {
    DatabaseHelper myDB;
    ArrayList<Category> categorylist;
    ListView listView;
    Category category;


    // TODO: Rename parameter arguments, choose names that match


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       final View v = inflater.inflate(R.layout.fragment_viewc_item, container, false);

        myDB = new DatabaseHelper(getContext());
        listView = v.findViewById(R.id.listViewcatogory);

        categorylist = new ArrayList<>();
        Cursor data = myDB.getAllcatData();
        int numRows = data.getCount();
        if (numRows == 0) {
            Toast.makeText(getActivity(), "The Database is empty  :(.", Toast.LENGTH_LONG).show();
        } else {
            int i = 0;
            while (data.moveToNext()) {
                category = new Category(data.getString(0), data.getString(1), data.getString(2));
                categorylist.add(i, category);
                System.out.println(data.getString(0) + " " + data.getString(1) + " " + data.getString(2));
                i++;
            }
            ThreeColumn_ListAdapter adapter = new ThreeColumn_ListAdapter(getContext(), R.layout.list_item, categorylist);

            listView.setAdapter(adapter);

        }
        return v;

    }

}