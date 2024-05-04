package co.edu.unisbana.Biblioteca.domain.repository;

import co.edu.unisbana.Biblioteca.domain.entity.Libro;

import java.util.UUID;

public interface PrestamoPort {
    UUID guardarPrestamo (Libro libro);
}
