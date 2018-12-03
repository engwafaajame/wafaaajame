package com.emuniapp.emuni.Fragment;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.emuniapp.emuni.Activity.ThreeColumn_ListAdapter;
import com.emuniapp.emuni.Activity.ThreeColumn_ProductAdapter;
import com.emuniapp.emuni.Activity.ViewListContents;
import com.emuniapp.emuni.R;
import com.emuniapp.emuni.classes.Category;
import com.emuniapp.emuni.classes.DatabaseHelper;
import com.emuniapp.emuni.classes.Product;

import java.util.ArrayList;


public class viewitem extends Fragment {
    DatabaseHelper myDB;
    ArrayList<Product> userList;
    ListView listView;
    Product user;


    // TODO: Rename parameter arguments, choose names that match


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_view_item, container, false);

        myDB = new DatabaseHelper(getContext());

        userList = new ArrayList<>();
        Cursor data = myDB.getAllproductData();
        int numRows = data.getCount();
        if(numRows == 0){
            Toast.makeText(getContext(),"The Database is empty  :(.",Toast.LENGTH_LONG).show();
        }else{
            int i=0;
            while(data.moveToNext()){
                user = new Product(data.getString(0),data.getString(1),data.getString(2),data.getString(3));
                userList.add(i,user);
                System.out.println(data.getString(0)+" "+data.getString(1)+" "+data.getString(2));
                i++;
            }
            ThreeColumn_ProductAdapter adapter =  new ThreeColumn_ProductAdapter(getContext(),R.layout.list_itemproduct, userList);
            listView =v.findViewById(R.id.list_product);
            listView.setAdapter(adapter);
        }
        return v;

    }
}






