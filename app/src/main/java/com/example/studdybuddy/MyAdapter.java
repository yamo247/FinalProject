package com.example.studdybuddy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<doc> docArrayList;

    public MyAdapter(Context context, ArrayList<doc> docArrayList) {
        this.context = context;
        this.docArrayList = docArrayList;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.item,parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {

        doc doc = docArrayList.get(position);

        holder.title.setText(doc.title);
        holder.description.setText(doc.description);

    }

    @Override
    public int getItemCount() {
        return docArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title, description;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.mtitle);
            description = itemView.findViewById(R.id.mdescription);
        }
    }

}
