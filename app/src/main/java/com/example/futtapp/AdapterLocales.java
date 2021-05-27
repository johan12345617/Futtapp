package com.example.futtapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.futtapp.Entidades.MensajeRecibir;

import java.util.ArrayList;
import java.util.List;

public class AdapterLocales extends RecyclerView.Adapter<AdapterLocales.HolderLocales> {


    private ArrayList<Local> listLocal;
    Context c;

    public AdapterLocales(Context c,ArrayList<Local> locales) {
        this.c=c;
        this.listLocal=locales;
    }

    @Override
    public AdapterLocales.HolderLocales onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(R.layout.cardview_locales,parent,false);
        return new AdapterLocales.HolderLocales(v);
    }

    @Override
    public void onBindViewHolder(AdapterLocales.HolderLocales holder, int position) {

        holder.getNombre().setText(listLocal.get(position).getNombre());
        holder.getDescripcion().setText(listLocal.get(position).getDescripcion());
        holder.getCantidad().setText(listLocal.get(position).getCapacidad());
        holder.getFotoLocal().setImageResource(listLocal.get(position).getUrlFoto());

    }

    @Override
    public int getItemCount() {
        return listLocal.size();
    }

    public static class HolderLocales extends RecyclerView.ViewHolder {

        private TextView nombre;
        private TextView descripcion;
        private TextView cantidad;
        private ImageView fotoLocal;

        public HolderLocales(View itemView) {
            super(itemView);
            setNombre((TextView) itemView.findViewById(R.id.nombreLocal));
            setDescripcion((TextView) itemView.findViewById(R.id.nombreDescripcion));
            setCantidad((TextView) itemView.findViewById(R.id.Capacidad));
            setFotoLocal((ImageView) itemView.findViewById(R.id.fotoLocal));
        }


        public TextView getNombre() {
            return nombre;
        }

        public void setNombre(TextView nombre) {
            this.nombre = nombre;
        }

        public TextView getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(TextView descripcion) {
            this.descripcion = descripcion;
        }

        public TextView getCantidad() {
            return cantidad;
        }

        public void setCantidad(TextView cantidad) {
            this.cantidad = cantidad;
        }

        public ImageView getFotoLocal() {
            return fotoLocal;
        }

        public void setFotoLocal(ImageView fotoLocal) {
            this.fotoLocal = fotoLocal;
        }
    }

}

