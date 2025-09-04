package com.example.p02_libreria_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.p02_libreria_android.databinding.ActivityMainBinding;

import Models.Libro;

public class MainActivity extends AppCompatActivity {

    private ViewModelMainActivity vm;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(ViewModelMainActivity.class);

        vm.getMensajeMutabe().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.txtError.setText(s);
            }
        });

        binding.btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ingreso = binding.txtIngreso.getText().toString();
                if(ingreso.isEmpty()) {
                    vm.getMensajeMutabe().setValue("Debe ingresar un nombre");
                    return;
                }
                vm.encontrarLibro(ingreso);
            }
        });

    }
}