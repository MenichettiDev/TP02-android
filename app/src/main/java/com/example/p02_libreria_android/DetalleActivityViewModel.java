package com.example.p02_libreria_android;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import Models.Libro;

public class DetalleActivityViewModel extends AndroidViewModel {

    private MutableLiveData<Libro> mutableLibro;
    public DetalleActivityViewModel(@NonNull Application application)
    {
        super( application);
    }
    public LiveData<Libro> getMutableLibro(){
        //inicializar aaca el libro
        if( mutableLibro == null) {
            mutableLibro = new MutableLiveData<>();
        }
        return mutableLibro;
    }
    public void setMutableLibro(Libro l){
        mutableLibro.setValue(l);
    }

    public void LeerLibro(Intent intent) {
        Libro libroExtra = (Libro)intent.getParcelableExtra("libroEncontrado", Libro.class);

        if (libroExtra != null) {
            mutableLibro.setValue(libroExtra);
        }
    }

}
