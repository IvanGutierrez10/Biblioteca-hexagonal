package co.edu.unisbana.Biblioteca.application.port_in;

import co.edu.unisbana.Biblioteca.domain.entity.Libro;

import java.util.List;

public interface IMostrarLibros {
    List<Libro> mostrarLibros();
}
