package com.friday.week7;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by gdaalumno on 3/3/17.
 */
public class StudentAdapter extends BaseAdapter {

    private ArrayList<Student> dataSource;
    private Activity activity;

    public StudentAdapter(ArrayList<Student> dataSource, Activity activity){
        this.dataSource = dataSource;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return dataSource.size();
    }

    @Override
    public Object getItem(int i) {
        return dataSource.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = activity.getLayoutInflater().inflate(R.layout.row,null );
        }
        TextView nameText=(TextView)view.findViewById(R.id.textName);
        nameText.setText(student.getname);
    }


}
