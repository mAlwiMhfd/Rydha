package com.rydha.id.rydha.Adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rydha.id.rydha.Activity.ContactActivity;
import com.rydha.id.rydha.Activity.DonasiActivity;
import com.rydha.id.rydha.Activity.ProgramActivity;
import com.rydha.id.rydha.Activity.ZakatActivity;
import com.rydha.id.rydha.Holder.ActivityHolder;
import com.rydha.id.rydha.Model.Activity;
import com.rydha.id.rydha.R;

import java.util.List;

/**
 * Created by ole on 1/1/19.
 */

public class ActivityAdapter extends RecyclerView.Adapter<ActivityHolder> {
    private List<Activity> activitys;
    public ActivityAdapter(List<Activity> activitys){
        this.activitys=activitys;
    }
    @Override
    public ActivityHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ActivityHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_activity,null));
    }

    @Override
    public void onBindViewHolder(ActivityHolder holder, final int position) {
        holder.gambar.setImageResource(activitys.get(position).getGambar());
        holder.txtJudul.setText(activitys.get(position).getJudul());
        holder.cardActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                switch (position){
                    case 0:
                        i = new Intent(v.getContext(), DonasiActivity.class);
                        break;
                    case 1:
                        i = new Intent(v.getContext(), ProgramActivity.class);
                        break;
                    case 2:
                        i=new Intent(v.getContext(), ZakatActivity.class);
                        break;
                    case 3:
                        i=new Intent(v.getContext(), ContactActivity.class);
                        break;
                }
                v.getContext().startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        return activitys.size();
    }


}
