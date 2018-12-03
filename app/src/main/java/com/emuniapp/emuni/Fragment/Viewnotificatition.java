package com.emuniapp.emuni.Fragment;

import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.emuniapp.emuni.R;
import com.emuniapp.emuni.classes.DatabaseHelper;
import com.emuniapp.emuni.classes.Product;

import java.util.ArrayList;


public class Viewnotificatition extends Fragment {

    private static final String CHANNEL_ID ="CHANNEL_ID" ;
    DatabaseHelper myDb;
    EditText editName,editSurname,editMarks ,editTextId;
    Button btnAddData;
    Button btnviewAll;
    String textofnotification ;
    ListView listView;
    ArrayAdapter<String> adapter;
    ArrayList<String> listItems;
    DatabaseHelper myDB;
    DatabaseHelper myDB2;




    // TODO: Rename parameter arguments, choose names that match


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View V=inflater.inflate(R.layout.fragment_viewnotification, container, false);
        myDb = new DatabaseHelper(getActivity());
        textofnotification = getString(R.string.notification_channel_description);
       listItems=new ArrayList<String>();
   listView=V.findViewById(R.id.listViewnotification);
        editName = V.findViewById(R.id.editText_name);
        editName.setText(textofnotification);
        btnviewAll = V.findViewById(R.id.button_viewAll);
        btnAddData = V.findViewById(R.id.button_add);
        AddData();
        myDB = new DatabaseHelper(getContext());

        //
        viewAll();

        Intent intent = new Intent(getActivity(), Viewnotificatition.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(getContext(), 0, intent, 0);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getContext(), CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Notification Tittle ")
                .setContentText(textofnotification)
                .setContentIntent(pendingIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        //Show it
        NotificationManager mNotificationManager =
                (NotificationManager) getActivity().getSystemService(getActivity().NOTIFICATION_SERVICE);

        mNotificationManager.notify(1000, mBuilder.build());
        return V;
    }
    public void viewAll() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Cursor res = myDb.getListnotification();
                        if(res.getCount() == 0) {
                            // show message
                            showMessage("Error","Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Id :"+ res.getString(0)+"\n");
                            buffer.append(" نص  الاشعار  :"+ res.getString(1)+"\n\n");

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

        myDB = new DatabaseHelper(getContext());
        myDB2 = new DatabaseHelper(getContext());

        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertnotificationData(editName.getText().toString());

                        if(isInserted == true) {
                            editName.setText("");
                            Toast.makeText(getActivity(), "Data Inserted", Toast.LENGTH_LONG).show();




                        }
                        else
                            Toast.makeText(getActivity(),"Data not Inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );


        int i=0;
        Cursor data = myDB2.getListnotification();
        while(data.moveToNext()){
            listItems.add(data.getString(1).toString());
            i++;
        }
        adapter=new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1,
                listItems);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }



}