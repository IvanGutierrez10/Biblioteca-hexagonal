package co.edu.unisbana.Biblioteca.domain.entity;

import co.edu.unisbana.Biblioteca.domain.exception.LibrosInsuficientesException;
import lombok.Data;

@Data
public class Libro {

    private String titulo;

    private String autor;

    private String isbn;

    private int cantidadDisponible;

    public Libro(String titulo, String autor, String isbn, int cantidadDisponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.cantidadDisponible = cantidadDisponible;
    }

    public void realizarPrestamo (){
        if(this.cantidadDisponible == 0){
            throw new LibrosInsuficientesException(this.titulo);
        } else {
            this.cantidadDisponible = cantidadDisponible - 1;
        }
    }
}
