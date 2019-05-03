package com.rydha.id.rydha.Holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.rydha.id.rydha.R;

/**
 * Created by ole on 1/7/19.
 */

public class ProgramHolder extends RecyclerView.ViewHolder {
    public TextView txtNamaProker;
    public TextView txtDetailProker;
    public View cardProker;
    public ProgramHolder(View itemView) {
        super(itemView);
        txtNamaProker=itemView.findViewById(R.id.txt_Nama_Proker);
        txtDetailProker=itemView.findViewById(R.id.txt_Detail_Proker);
        cardProker=itemView.findViewById(R.id.carditem_proker);
    }
}
