package com.emuniapp.emuni.Fragment;

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


public class Addproduct extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    DatabaseHelper myDb;
    EditText editName,editSurname,editMarks ,editTextId,editText_productnumber;
    Button btnAddData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View V=inflater.inflate(R.layout.fragment_add_product, container, false);
        myDb = new DatabaseHelper(getContext());

        editName = V.findViewById(R.id.editText_name);
        editSurname = V.findViewById(R.id.editText_surname);
        editText_productnumber=V.findViewById(R.id.editText_productnumber);
        editTextId = V.findViewById(R.id.editText_id);
        btnAddData = V.findViewById(R.id.button_add);
        AddData();

        return  V;



    }

    public  void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertproductData(editName.getText().toString(),
                                editSurname.getText().toString(),editText_productnumber.getText().toString());


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