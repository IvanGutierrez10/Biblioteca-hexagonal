package co.edu.unisbana.Biblioteca.application.port_in;

import co.edu.unisbana.Biblioteca.application.usecase.LibroDTO;

public interface IRealizarPrestamo {

    void RealizarPrestamo (String isbn);
}
