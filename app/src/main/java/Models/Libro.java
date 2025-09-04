package Models;

import java.io.Serializable;

public class Libro implements Serializable {

    private String nombre;
    private String autor;
    private String genero;
    private String descripcion;
    private int foto;

    public Libro(String nombre, String autor, String genero, String descripcion, int foto) {
        this.nombre = nombre;
        this.autor = autor;
        this.genero = genero;
        this.descripcion = descripcion;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getFoto() {
        return foto;
    }
    public void setFoto(int foto) {
        this.foto = foto;
    }
}
