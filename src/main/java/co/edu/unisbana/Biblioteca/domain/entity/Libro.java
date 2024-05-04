package co.edu.unisbana.Biblioteca.domain.entity;

import co.edu.unisbana.Biblioteca.domain.exception.LibrosInsuficientesException;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Libro {

    private String titulo;

    private String autor;

    private String isbn;

    private int cantidadDisponible;

    public void realizarPrestamo (){
        if(this.cantidadDisponible == 0){
            throw new LibrosInsuficientesException(this.titulo);
        } else {
            this.cantidadDisponible = cantidadDisponible - 1;
        }
    }
}
