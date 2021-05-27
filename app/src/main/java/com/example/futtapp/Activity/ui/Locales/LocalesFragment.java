package com.example.futtapp.Activity.ui.Locales;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.futtapp.Activity.ui.LocalesViewModel;
import com.example.futtapp.AdapterLocales;
import com.example.futtapp.AdapterMensajes;
import com.example.futtapp.Local;
import com.example.futtapp.R;

import java.util.ArrayList;

public class LocalesFragment extends Fragment {

    private LocalesViewModel mViewModel;
    ArrayList<Local> locales= new ArrayList<>();

    public static LocalesFragment newInstance() {
        return new LocalesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        cargarLocales();
        View v = inflater.inflate(R.layout.locales_fragment,container,false);

        RecyclerView rvLocal = (RecyclerView) v.findViewById(R.id.rvLocales);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        AdapterLocales adapter = new AdapterLocales(v.getContext(), locales);

        rvLocal.setLayoutManager(llm);
        rvLocal.setAdapter(adapter);

        Log.d("",""+locales.get(3).getNombre());

        return inflater.inflate(R.layout.locales_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(LocalesViewModel.class);
        // TODO: Use the ViewModel
    }

    public void cargarLocales(){

        this.locales.add(new Local("Gol Plaza",R.drawable.complejo_poliderportivo_ramon_castilla,"Disponemos de locales de futbol y voley ",20));
        this.locales.add(new Local("Loza Deportiva Las Americas",R.drawable.complejo_poliderportivo_ramon_castilla,"Ambiente agradable para disfrutar del buen deporte",38));
        this.locales.add(new Local("Complejo Deportivo IPD Los Olivos",R.drawable.complejo_poliderportivo_ramon_castilla,"Locales de futbol y basquet",46));
        this.locales.add(new Local("Complejo Deportivo Andrés Avelino Cáceres",R.drawable.complejo_poliderportivo_ramon_castilla,"Locales deportivos de grass sintetico y natural ",24));
        this.locales.add(new Local("Loza Deportiva Nueva Caledonia",R.drawable.complejo_poliderportivo_ramon_castilla,"Contamos con locales de futbol y indumentaria para que disfrutes tu deporte",30));
        this.locales.add(new Local("Complejo Polideportivo Ramon Castilla",R.drawable.complejo_poliderportivo_ramon_castilla,"Contamos con locales para basquet futbol y voley ",30));

    }

}