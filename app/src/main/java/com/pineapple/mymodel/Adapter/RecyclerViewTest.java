package com.pineapple.mymodel.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pineapple.mymodel.DB.model.TestModel;
import com.pineapple.mymodel.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewTest extends android.support.v7.widget.RecyclerView.Adapter<RecyclerViewTest.ViewHolder>{

    private List<TestModel> testList;
    private Context context;

    public RecyclerViewTest(ArrayList<TestModel> testList, Context context) {
        this.testList = testList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_test, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textTest.setText(testList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return testList.size();
    }


    public class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {

        public TextView textTest;

        public ViewHolder(View v) {
            super(v);
            textTest = (TextView)v.findViewById(R.id.textTest);
        }
    }
}
