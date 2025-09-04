package com.example.p02_libreria_android;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

import android.content.Intent;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;

import Models.Libro;

public class ViewModelMainActivity extends AndroidViewModel {

    private ArrayList<Libro> listaLibros;
    private MutableLiveData<Libro> libroEncontrado;
    private MutableLiveData<String> mensajeMutabe;

    public ViewModelMainActivity(android.app.Application application) {
        super(application);

        mensajeMutabe = new MutableLiveData<>();
        libroEncontrado = new MutableLiveData<>();
        listaLibros = new ArrayList<>();
        listaLibros.add(new Libro("1984", "George Orwell", "Distopía", "Un futuro con vigilancia total.", R.drawable.uno));
        listaLibros.add(new Libro("Cien años de soledad", "García Márquez", "Realismo mágico", "Historia de la familia Buendía.", R.drawable.dos));
        listaLibros.add(new Libro("El Hobbit", "J.R.R. Tolkien", "Fantasía", "Bilbo vive una aventura inesperada.", R.drawable.tres));

    }

    public MutableLiveData<Libro> getLibroEncontrado() {
        return libroEncontrado;
    }

    public MutableLiveData<String> getMensajeMutabe() {
        if(mensajeMutabe == null) {
            mensajeMutabe = new MutableLiveData<>();
        }
        return mensajeMutabe;
    }

    public void encontrarLibro(String nombre ) {
        for (Libro libro : listaLibros) {
            if (libro.getNombre().equalsIgnoreCase(nombre)) {
                Intent intent = new Intent(getApplication(), DetallesActivity.class);
                intent.putExtra("libroEncontrado", libro);
                intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
                getApplication().startActivity(intent);
            }else{
                mensajeMutabe.setValue("No se encontro el libro");
            }
        }
    }
}
