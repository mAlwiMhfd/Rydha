package com.rydha.id.rydha.Model;

/**
 * Created by ole on 1/7/19.
 */

public class Program {
    private String Nama;
    private String Detail;

    public Program(String nama, String detail) {
        this.Nama = nama;
        this.Detail = detail;
    }

    public String getNama() {
        return Nama;
    }

    public String getDetail() {
        return Detail;
    }
}
