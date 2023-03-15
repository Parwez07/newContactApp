package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder> {
    Context context;
    ArrayList<contact> arrContact;
    itemClicked Activity;
    public interface  itemClicked{
        void onItemClicked(int index);
    }
        RecyclerContactAdapter (Context context,ArrayList<contact>arrContact){
            this.arrContact=arrContact;
            this.context=context;
            Activity = (itemClicked) context;
        }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater .from(context).inflate(R.layout.contact_row,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemView.setTag(arrContact.get(position));
        holder.imgContact .setImageResource(arrContact.get(position).img);
        holder.txtNumber .setText(arrContact.get(position).number);
        holder.txtName .setText(arrContact.get(position).name);
    }

    @Override
    public int getItemCount() {
        return arrContact.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        TextView txtName,txtNumber;
        ImageView imgContact;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.tvName);
            txtNumber = itemView.findViewById(R.id.tvNumber);
            imgContact =itemView.findViewById(R.id.imgPerson);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Activity.onItemClicked(arrContact.indexOf((contact) v.getTag()));
                }
            });
        }
    }

}
