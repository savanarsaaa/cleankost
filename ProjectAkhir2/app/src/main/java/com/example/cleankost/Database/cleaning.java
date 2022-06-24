package com.example.cleankost.Database;

public class cleaning {
    String Nama;
    String Email;
    String Almt;

    public cleaning() {
    }

    public cleaning(String Nama, String Email, String Almt) {
        this.Nama = Nama;
        this.Email = Email;
        this.Almt = Almt;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAlmt() {
        return Almt;
    }

    public void setAlmt(String Almt) {
        this.Almt = Almt;
    }
}

