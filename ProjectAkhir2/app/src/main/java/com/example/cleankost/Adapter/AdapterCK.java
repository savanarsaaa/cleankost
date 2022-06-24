package com.example.cleankost.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cleankost.R;
import com.example.cleankost.App.DBCleaningKost;
import com.example.cleankost.Database.cleaning;

import java.util.ArrayList;

public class AdapterCK extends RecyclerView.Adapter<AdapterCK.KMViewHolder> {
    private ArrayList<cleaning> listData;
    private Context control;

    public AdapterCK(ArrayList<cleaning> listData) {
        this.listData = listData;
    }

    @NonNull
    @Override
    public KMViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.rowdatakm,parent,false);
        return new KMViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KMViewHolder holder, int position) {
        String nm, email, almt;

        nm = listData.get(position).getNama();
        email = listData.get(position).getEmail();
        almt = listData.get(position).getAlmt();
        DBCleaningKost db = new DBCleaningKost(control);

        holder.namaTxt.setText(nm);
        holder.emailTxt.setText(email);
        holder.alamatTxt.setText(almt);

    }
    @Override
    public int getItemCount() {
        return (listData != null)?listData.size(): 0;
    }

    public class KMViewHolder extends RecyclerView.ViewHolder {
        private CardView cardku;
        private TextView namaTxt,emailTxt,alamatTxt;
        public KMViewHolder(View view) {
            super(view);
            cardku = (CardView) view.findViewById(R.id.kartuku);
                    namaTxt = (TextView) view.findViewById(R.id.Nama);
                    emailTxt = (TextView) view.findViewById(R.id.Email);
                    alamatTxt = (TextView) view.findViewById(R.id.Alamat);

        }
    }
}
