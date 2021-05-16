package com.example.tiketsaya;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class TicketAdapter extends RecyclerView.Adapter<TicketAdapter.MyViewHolder> {

    Context context;
    ArrayList<MyTicket> myTicket;

    public TicketAdapter(Context c, ArrayList<MyTicket> p){
        context = c;
        myTicket = p;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_myticket, viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.xnama_wisata.setText(myTicket.get(i).getNama_wisata());
        myViewHolder.xnama_lokasi.setText(myTicket.get(i).getLokasi());
        myViewHolder.xjumlah_tiket.setText(myTicket.get(i).getJumlah_ticket()+ " Tickets");

        final String getNamaWisata = myTicket.get(i).getNama_wisata();

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotomyticketdetail = new Intent(context, TicketDetail.class);
                gotomyticketdetail.putExtra("nama_wisata", getNamaWisata);
                context.startActivity(gotomyticketdetail);
            }
        });

    }

    @Override
    public int getItemCount() {
        return myTicket.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView xnama_wisata, xnama_lokasi, xjumlah_tiket;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            xnama_wisata = itemView.findViewById(R.id.xnama_wisata);
            xnama_lokasi = itemView.findViewById(R.id.xnama_lokasi);
            xjumlah_tiket = itemView.findViewById(R.id.xjumlah_tiket);
        }
    }
}
