package com.example.mealtracker.ui.main.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mealtracker.R;
import com.example.mealtracker.ui.main.IngredientItem;

import java.util.ArrayList;

public class TimerRecyclerViewAdapter extends RecyclerView.Adapter<TimerRecyclerViewAdapter.TimerViewHolder> {

    ArrayList<IngredientItem> mIngredients;
    int limit = 4;

    public TimerRecyclerViewAdapter(ArrayList<IngredientItem> mIngredients) {
        this.mIngredients = mIngredients;
    }


    @NonNull
    @Override
    public TimerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_timers,parent,false);
        TimerViewHolder tvh = new TimerViewHolder(v);
        return tvh;
    }

    public void onBindViewHolder(@NonNull TimerViewHolder holder, int position) {
        IngredientItem mIngredient  = mIngredients.get(position);
        Context ctx = holder.itemView.getContext();
        long days = mIngredient.getTimeLeft()[0];
        Log.i("Timer Recycler Adapter",""+days);
        if (days>=6){
            holder.mTitleBar.setBackgroundColor(ContextCompat.getColor(ctx,R.color.card_title_green));
            holder.mIcon.setImageDrawable(ContextCompat.getDrawable(ctx,R.drawable.ic_baseline_check_circle_24));
            holder.mCard.setBackgroundColor(ContextCompat.getColor(ctx,R.color.card_green));
        } else if (days>=3){
            holder.mTitleBar.setBackgroundColor(ContextCompat.getColor(ctx,R.color.card_title_yellow));
            holder.mIcon.setImageDrawable(ContextCompat.getDrawable(ctx,R.drawable.ic_baseline_warning_24));
            holder.mCard.setBackgroundColor(ContextCompat.getColor(ctx,R.color.card_yellow));
        } else{
            holder.mTitleBar.setBackgroundColor(ContextCompat.getColor(ctx,R.color.card_title_red));
            holder.mIcon.setImageDrawable(ContextCompat.getDrawable(ctx, R.drawable.ic_baseline_error_24));
            holder.mCard.setBackgroundColor(ContextCompat.getColor(ctx,R.color.card_red));
       }

        holder.mName.setText(mIngredient.getName());
        holder.mDays.setText(""+mIngredient.getTimeLeft()[0]);
        holder.mHours.setText(""+mIngredient.getTimeLeft()[1]);

    }

    @Override
    public int getItemCount() {
        return Math.min(mIngredients.size(),limit);
    }

    public static class TimerViewHolder extends RecyclerView.ViewHolder{

        public LinearLayout mTitleBar;
        public LinearLayout mCard;
        public TextView mName;
        public ImageView mIcon;
        public TextView mDays;
        public  TextView mHours;

        public TimerViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitleBar = itemView.findViewById(R.id.timerTitleCard);
            mCard = itemView.findViewById(R.id.timerCard);
            mName = itemView.findViewById(R.id.ingredientName);
            mIcon = itemView.findViewById(R.id.ingredientIcon);
            mDays = itemView.findViewById(R.id.timerDays);
            mHours = itemView.findViewById(R.id.timerHours);

        }

    }
}