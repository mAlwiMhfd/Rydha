package com.rydha.id.rydha.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rydha.id.rydha.Adapter.ProgramAdapter;
import com.rydha.id.rydha.Model.Program;
import com.rydha.id.rydha.R;

import java.util.ArrayList;
import java.util.List;

public class ProgramActivity extends AppCompatActivity {

    private List<Program>programs=new ArrayList<>();
    RecyclerView lstProg;
    LinearLayoutManager linear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program);
        lstProg=(RecyclerView)findViewById(R.id.lstProgram);

        linear=new LinearLayoutManager(this);
        lstProg.setLayoutManager(linear);

        ProgramAdapter adapter=new ProgramAdapter(programs);
        lstProg.setAdapter(adapter);
        programsCollect();
    }
    private void programsCollect(){
        programs.add(new Program("Program B-BEST (Bantuan Biaya Studi) Dhuafa","adalah program bantuan biaya studi kepada dhuafa untuk menlanjutkan pendidikan sampai tingkat Perguruan Tinggi."));
        programs.add(new Program("Program Bina Yatim","Program ini adalah program pembinaan akhlak yatim. Wujud program ini adalah melalui Taman Pendidikan Al-Quran untuk usia TK dan SD. Pengajian dan Pembinaan secara Rutin untuk anak-anak yatim usia SD dan SLTP."));
        programs.add(new Program("Program Peduli Dhuafa","Program ini adalah program yang bersifat karitas seperti pemberian sembako, pengobatan masal dan perbantuan biaya rumah sakit dan lain-lain."));
        programs.add(new Program("Program Bea didik dan Bea Prestasi Yatim","Program Bea didik adalah program pemberian biaya pendidikan anak-anak yatim dari tingkat Sekolah Dasar sampai dengan SLTP, bea didik ini meliputi perlengkapan sekolah (baju seragam, sepatu dan tas) dan keseluruhan biaya pendidikan seperti uang pembangunan, SPP, Uang ujian semester, ujian akhir, studi wisata dan lain-lain. Sedangkan program Bea Prestasi adalah Uang yang diberikan langsung kepada anak yatim yang berprestasi. Bea Prestasi ini diberikan setiap semester dengan tujuan untuk meningkatkanprestasi akademik anak-anak yatim. "));
        programs.add(new Program("Program Pemberdayaan Ekonomi Umat (PEU) ","Program ini merupakan sasaran utama dalam pemberdayaan kaum dhuafa, melalui program ini Yayasan RYDHA berperan sebagai mitra dalam pemberdayaan ekonomi kaum dhuafa dengan cara memberdayakan kaum dhuafa sehingga meningkatkan taraf hidup dan kesejahteraan kaum dhuafa. Yayasan Rydha memberikan bantuan modal, pelatihan bisnis dan manajerial. Mereka di kumpulkan dalam beberapa kelompok bisnis dan kemudian diberikan perbantuan pemodalan. Tujuan utama dari program ini adalah \"Mengubah Mustahiq menjadi Muzakki\" "));
        programs.add(new Program("Program RYDHA Peduli Yatim","Adalah program yang bersifat karitas atau berupa santunan temporer seperti pembagian sembako, santunan idul fitri, pengobatan dan khitanan serta kegiatan-kegiatan karitas lainnya."));
        programs.add(new Program("Program Kerja Ramadhan Yatim","Program Kerja Ramadhan adalah program kerja khusus dan rutin yang dilaksanakan pada Bulan Ramadhan seperti program Meraih Malam 1000 bulan dengan 1000 anak yatim, Itikaf bersama anak-anak yatim, Buka puasa dan sahur bersama anak-anak yatim (tebar gizi Ramadhan), Santunan Idul Fitri / Paket Hadiah Lebaran (PAHALA) untuk anak-anak yatim dan lain-lain"));
        programs.add(new Program("Program Mobil Sehat Dhuafa (sejenis Mobil Ambulance)","Program penyediaan sarana transportasi untuk Dhuafa yang membutuhkan transportasi ke dan dari rumah sakit."));
        programs.add(new Program("Program Pembinaan Akhlak dan Kreatifitas Yatim","Program ini bertujuan untuk membina dan mengajarkan mereka tentang Agama Islam secara menyeluruh dari mulai penanaman aqidah, akhlaq, baca tulis Al-Qurn, Fiqih dan lain-lain. Kami ingin mereka mempunyai bekal keimanan dan pemahaman Islam yang kuat. Pada program ini juga diajarkan keterampilan untuk membangun kreatifitas dalamrangka kemandirian anak-anak Yatim. Bentuk program ini adalah pembinaan rutin setiap hari Ahad khususnya pada hari ahad pertama dan ketiga setiap bulan."));
        programs.add(new Program("Program Qurban untuk Yatim dan Dhuafa","Program rutin setiap Idul Qurban untuk menerima dan mendistribusikan qurban kepada yatim dan dhuafa."));
        programs.add(new Program("Program Kerja Ramadhan untuk Dhuafa","Program Kerja Ramadhan adalah program kerja khusus dan rutin yang dilaksanakan pada setiap Bulan Ramadhan seperti Terbar Gizi Ramadhan (Buka Puasa dan Sahur) untuk Dhuafa, THR Mulia dan Bingkisan untuk DHuafa."));
        programs.add(new Program("Program Pembiayaan Pendidikan yang Berkelanjutan.","Program ini adalah program pembiayaan pendidikan anak anak yatim, namun tidak hanya terbatas Sekolah Dasar saja melainkan sampai ke perguruan tinggi. Pembiayaan pendidikan mereka sampai tingkat SLTP berasal dari dana yatim yang donatur sumbangkan. Mulai Tingkat SMA dan Perguruan Tinggi pembiayaan mereka berasal dari dana zakat dan sedekah (Program Peduli Pendidikan Dhuafa)."));
        programs.add(new Program("Program Kemandirian Yatim","Program ini mengajarkan keterampilan dan praktek untuk kemandirian yatim seperti belajar service HP, menjahit, operator komputer dan lain-lain"));
        programs.add(new Program("Program Yatim Enterpreneur","Program ini menekankan pelatihan dan pembinaan yatim melaksanakan bisnis yang sesuai dengan tuntunan syariah."));
    }
}
