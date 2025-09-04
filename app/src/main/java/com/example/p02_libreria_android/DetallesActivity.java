package com.example.p02_libreria_android;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.p02_libreria_android.databinding.ActivityDetallesBinding;

import Models.Libro;



public class DetallesActivity extends AppCompatActivity {

    private DetalleActivityViewModel vm;
    private ActivityDetallesBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetallesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(DetalleActivityViewModel.class);

        vm.getMutableLibro().observe(this, new Observer<Libro>() {
            @Override
            public void onChanged(Libro l) {
                binding.txtTitulo.setText(l.getNombre());
                binding.txtAutor.setText(l.getAutor());
                binding.txtGenero.setText(l.getGenero());
                binding.txtDescripcion.setText(l.getDescripcion());
                binding.imageView.setImageResource(l.getFoto());
            }
        });

        //le paso el intent al view model
        vm.LeerLibro(getIntent());

    }


}