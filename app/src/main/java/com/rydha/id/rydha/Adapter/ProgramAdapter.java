package com.rydha.id.rydha.Adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rydha.id.rydha.Activity.DetailActivity;
import com.rydha.id.rydha.Holder.ProgramHolder;
import com.rydha.id.rydha.Model.Program;
import com.rydha.id.rydha.R;

import java.util.List;

/**
 * Created by ole on 1/7/19.
 */

public class ProgramAdapter extends RecyclerView.Adapter<ProgramHolder> {
    private List<Program> programs;
    public ProgramAdapter(List<Program>programs){
        this.programs=programs;
    }
    @Override
    public ProgramHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ProgramHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_program,null));
    }

    @Override
    public void onBindViewHolder(ProgramHolder holder, final int position) {
        holder.txtNamaProker.setText(programs.get(position).getNama());
        holder.txtDetailProker.setText(programs.get(position).getDetail());

        holder.cardProker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(v.getContext(), DetailActivity.class);
                i.putExtra("id_Nama",programs.get(position).getNama());
                i.putExtra("id_Detail",programs.get(position).getDetail());
                v.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return programs.size();
    }
}
