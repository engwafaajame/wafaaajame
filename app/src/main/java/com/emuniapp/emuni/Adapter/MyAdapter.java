package com.emuniapp.emuni.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.emuniapp.emuni.classes.Category;
import com.emuniapp.emuni.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iSaleem on 11/21/17.
 */

public class MyAdapter extends ArrayAdapter<Category> {

    private LayoutInflater mInflater;
    private ArrayList<Category> users;
    private int mViewResourceId;

    public MyAdapter(Context context, int textViewResourceId, ArrayList<Category> users) {
        super(context, textViewResourceId, users);
        this.users = users;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(mViewResourceId, null);

        Category user = users.get(position);

        if (user != null) {
            TextView firstName = (TextView) convertView.findViewById(R.id.tvId);
            TextView lastName = (TextView) convertView.findViewById(R.id.tvName);
            TextView favFood = (TextView) convertView.findViewById(R.id.desc);
            if (firstName != null) {
                firstName.setText(user.getId());
            }
            if (lastName != null) {
                lastName.setText((user.getCategory_name()));
            }
            if (favFood != null) {
                favFood.setText((user.getCategory_description()));
            }
        }

        return convertView;
    }
}

   /* private LayoutInflater inflater;
       ArrayList<Category> catogorylist;
       int resource;



    public MyAdapter(@NonNull Context context, int resource ,ArrayList<Category>catogorylist) {
        super(context, resource,catogorylist);
        this.catogorylist=catogorylist;
        this.resource=resource;
        this.catogorylist=catogorylist;
        inflater= (LayoutInflater) context
                        .getSystemService
                                (Context.LAYOUT_INFLATER_SERVICE);

    }

   /* private final List<Category> employees;
    private final Context context;
    private LayoutInflater inflater;
    public MyAdapter(Context context, List<Category> employees){
        this.employees = employees;
        this.context = context;
        //this.inflater = LayoutInflater.from(context);
        this.inflater = (LayoutInflater)
                context
                        .getSystemService
                                (Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return catogorylist.size();
    }

    @Override
    public Category getItem(int position) {
        return catogorylist.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        //Toast.makeText(context, position+"", Toast.LENGTH_SHORT).show();
        if(view == null){
            view = inflater.inflate(R.layout.list_item,viewGroup,
                    false);
            MyHolder holder = new MyHolder();
            holder.tvid = view.findViewById(R.id.tvId);
            holder.tvname = view.findViewById(R.id.tvName);
            holder.tvdecription = view.findViewById(R.id.desc);
            view.setTag(holder);
        }
        MyHolder holder = (MyHolder)view.getTag();
        holder.tvid.setText(catogorylist.get(position).getId());
        holder.tvname.setText(catogorylist.get(position).getCategory_name());
        holder.tvdecription.setText(catogorylist.get(position).getCategory_description());
        return view;
    }
    static class MyHolder {
        TextView tvid;
        TextView tvname;
        TextView tvdecription;
    }*/


