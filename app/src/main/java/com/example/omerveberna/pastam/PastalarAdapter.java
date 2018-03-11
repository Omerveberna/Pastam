package com.example.omerveberna.pastam;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by omerveberna on 11.03.2018.
 */

public class PastalarAdapter extends RecyclerView.Adapter<PastalarAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView icerik;
        public TextView kisi;
        public TextView fiyat;
        public CardView card_view;

        public ViewHolder(View view) {
            super(view);

            card_view = (CardView) view.findViewById(R.id.card_view);
            kisi = (TextView) view.findViewById(R.id.fiyat);
            fiyat = (TextView) view.findViewById(R.id.kisi);
            icerik = (TextView) view.findViewById(R.id.icerik);
        }
    }

        List<Pastalar> pasta_listesi;

        CustomItemClickListener customItemClickListener;

        public PastalarAdapter(List<Pastalar> pasta_listesi, CustomItemClickListener customItemClickListener) {
            this.pasta_listesi = pasta_listesi;
            this.customItemClickListener = customItemClickListener;

        }




    @Override
    public PastalarAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_layout, parent, false);
        final ViewHolder viewHolder = new ViewHolder(v);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customItemClickListener.onItemClick(v, viewHolder.getPosition());

            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PastalarAdapter.ViewHolder holder, int position) {
        holder.icerik.setText(pasta_listesi.get(position).getIcerik());
        holder.fiyat.setText(pasta_listesi.get(position).getFiyat());
        holder.kisi.setText(pasta_listesi.get(position).getkisi());
    }

    @Override
    public int getItemCount() {
        return pasta_listesi.size();
    }
}
