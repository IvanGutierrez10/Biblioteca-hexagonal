package co.edu.unisbana.Biblioteca.domain.repository;

import co.edu.unisbana.Biblioteca.domain.entity.Libro;

import java.util.List;

public interface LibroPort {

    List<Libro> obtenerLibros ();
    Libro obtenerLibro(String isbn);

    void actualizarStock(Libro libro);
}
