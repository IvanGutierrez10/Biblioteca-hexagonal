package co.edu.unisbana.Biblioteca.application.port_in;

import co.edu.unisbana.Biblioteca.application.usecase.LibroDTO;

import java.util.List;

public interface IObtenerLibros {

    List<LibroDTO> obtenerLibros();
}
