package com.mobdeve.s17.aquino.melanie.restorate;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RestoAdapter extends RecyclerView.Adapter<RestoAdapter.ViewHolder> {
    ArrayList<RestoData> restoData =new ArrayList<>();
    Context context;

    public RestoAdapter(ArrayList<RestoData> restoData, Activity activity) {
        this.restoData = restoData;
        this.context = activity;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.resto_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final RestoData RestoDataList = restoData.get(position);
        holder.restoName.setText(RestoDataList.getName());
        holder.restoType.setText(RestoDataList.getType());
        Picasso.with(context).load(Uri.parse(RestoDataList.getImage())).into(holder.restoImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            /* TODO Call an intent for OrderActivity allowing you to order food */


            @Override
            public void onClick(View v) {
                Intent intent = new Intent (context, ViewRestoActivity.class);


                context.startActivity(intent);

                /* Remove this and replace it with an intent call*/
                //Toast.makeText(context, "TODO: Call OrderActivity via intent and order "+myFoodDataList.getFoodName(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return restoData.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView restoImage;
        TextView restoName;
        TextView restoType;
        TextView restoRating;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            restoImage = itemView.findViewById(R.id.resto_image);
            restoName = itemView.findViewById(R.id.resto_name);
            restoType = itemView.findViewById(R.id.resto_type);
            //restoRating = itemView.findViewById(R.id.resto_rating);
        }
    }

}