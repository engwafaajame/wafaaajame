package com.emuniapp.emuni.Fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.emuniapp.emuni.R;
import com.emuniapp.emuni.classes.DatabaseHelper;


public class add_item extends Fragment {
    // TODO: Rename parameter arguments, choose names that match

    DatabaseHelper myDb;
    EditText editName,editSurname,editMarks ,editTextId;
    Button btnAddData;
    Button btnviewAll;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View V=inflater.inflate(R.layout.fragment_add_item, container, false);

        myDb = new DatabaseHelper(getContext());

        editName = V.findViewById(R.id.editText_name);
        editSurname = V.findViewById(R.id.editText_surname);
        btnviewAll = V.findViewById(R.id.button_viewAll);
        editTextId = V.findViewById(R.id.editText_id);
        btnAddData = V.findViewById(R.id.button_add);
        AddData();
        viewAll();

        return  V;



    }


    public void viewAll() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllcatData();
                        if(res.getCount() == 0) {
                            // show message
                            showMessage("Error","Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Id :"+ res.getString(0)+"\n");
                            buffer.append("Name :"+ res.getString(1)+"\n");
                            buffer.append("Description :"+ res.getString(2)+"\n");
                        }

                        // Show all data
                        showMessage("Data",buffer.toString());
                    }
                }
        );
    }


    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    public  void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertcatogoryData(editName.getText().toString(),
                                editSurname.getText().toString());


                        if(isInserted == true) {
                            editName.setText("");
                            editSurname.setText("");
                            Toast.makeText(getActivity(), "Data Inserted", Toast.LENGTH_LONG).show();
                        }
                        else
                            Toast.makeText(getActivity(),"Data not Inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }


}