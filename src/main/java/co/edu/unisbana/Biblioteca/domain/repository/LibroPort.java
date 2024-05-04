package co.edu.unisbana.Biblioteca.domain.repository;

import co.edu.unisbana.Biblioteca.domain.entity.Libro;

public interface LibroPort {
    Libro obtenerLibro(String isbn);

    void actualizarStock(Libro libro);
}
