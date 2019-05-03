package com.rydha.id.rydha.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.rydha.id.rydha.R;

public class DetailActivity extends AppCompatActivity {

    TextView txtDetailJudul,txtDetailProgram;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txtDetailJudul=(TextView)findViewById(R.id.txt_detail_judul);
        txtDetailProgram=(TextView)findViewById(R.id.txt_detail_program);

        txtDetailJudul.setText(getIntent().getStringExtra("id_Nama"));
        txtDetailProgram.setText(getIntent().getStringExtra("id_Detail"));
    }
}
