package com.example.futtapp;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.GlideException;
import com.example.futtapp.Entidades.MensajeRecibir;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class AdapterMensajes extends RecyclerView.Adapter<AdapterMensajes.HolderMensaje> {

    private List<MensajeRecibir> listMensaje = new ArrayList<>();
    private Context c;

    public AdapterMensajes(Context c) {
        this.c = c;
    }

    public void addMensaje(MensajeRecibir m){
        listMensaje.add(m);
        notifyItemInserted(listMensaje.size());
    }

    @Override
    public HolderMensaje onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(R.layout.card_view_mensajes,parent,false);
        return new HolderMensaje(v);
    }

    @Override
    public void onBindViewHolder(HolderMensaje holder, int position) {
        holder.getNombre().setText(listMensaje.get(position).getNombre());
        holder.getMensaje().setText(listMensaje.get(position).getMensaje());
        if(listMensaje.get(position).getType_mensaje().equals("2")){
            holder.getFotoMensaje().setVisibility(View.VISIBLE);
            holder.getMensaje().setVisibility(View.VISIBLE);
            Glide.with(c).load(listMensaje.get(position).getUrlFoto()).into(holder.getFotoMensaje());
        }else if(listMensaje.get(position).getType_mensaje().equals("1")){
            holder.getFotoMensaje().setVisibility(View.GONE);
            holder.getMensaje().setVisibility(View.VISIBLE);
        }
        if(listMensaje.get(position).getFotoPerfil().isEmpty()){
            holder.getFotoMensajePerfil().setImageResource(R.mipmap.ic_launcher);
        }else{
            Glide.with(c).load(listMensaje.get(position).getFotoPerfil()).into(holder.getFotoMensajePerfil());
        }
        Long codigoHora = listMensaje.get(position).getHora();
        Date d = new Date(codigoHora);
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");//a pm o am
        holder.getHora().setText(sdf.format(d));
    }

    @Override
    public int getItemCount() {
        return listMensaje.size();
    }

    public static class HolderMensaje extends RecyclerView.ViewHolder {

        private TextView nombre;
        private TextView mensaje;
        private TextView hora;
        private CircleImageView fotoMensajePerfil;
        private ImageView fotoMensaje;

        public HolderMensaje(View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.nombreMensaje);
            mensaje = (TextView) itemView.findViewById(R.id.mensajeMensaje);
            hora = (TextView) itemView.findViewById(R.id.horaMensaje);
            fotoMensajePerfil = (CircleImageView) itemView.findViewById(R.id.fotoPerfilMensaje);
            fotoMensaje = (ImageView) itemView.findViewById(R.id.mensajeFoto);
        }

        public TextView getNombre() {
            return nombre;
        }

        public void setNombre(TextView nombre) {
            this.nombre = nombre;
        }

        public TextView getMensaje() {
            return mensaje;
        }

        public void setMensaje(TextView mensaje) {
            this.mensaje = mensaje;
        }

        public TextView getHora() {
            return hora;
        }

        public void setHora(TextView hora) {
            this.hora = hora;
        }

        public CircleImageView getFotoMensajePerfil() {
            return fotoMensajePerfil;
        }

        public void setFotoMensajePerfil(CircleImageView fotoMensajePerfil) {
            this.fotoMensajePerfil = fotoMensajePerfil;
        }

        public ImageView getFotoMensaje() {
            return fotoMensaje;
        }

        public void setFotoMensaje(ImageView fotoMensaje) {
            this.fotoMensaje = fotoMensaje;
        }
    }


}