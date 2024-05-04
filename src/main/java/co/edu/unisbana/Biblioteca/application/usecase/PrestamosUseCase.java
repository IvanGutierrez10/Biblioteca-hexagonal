package co.edu.unisbana.Biblioteca.application.usecase;

import co.edu.unisbana.Biblioteca.application.exception.LibroNoExisteException;
import co.edu.unisbana.Biblioteca.application.port_in.IAnadirLibro;
import co.edu.unisbana.Biblioteca.application.port_in.IObtenerLibros;
import co.edu.unisbana.Biblioteca.application.port_in.IRealizarPrestamo;
import co.edu.unisbana.Biblioteca.domain.entity.Libro;
import co.edu.unisbana.Biblioteca.domain.repository.LibroPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestamosUseCase implements IRealizarPrestamo, IObtenerLibros, IAnadirLibro {
    private final LibroPort libroPort;

    public PrestamosUseCase(LibroPort libroPort){
        this.libroPort = libroPort;
    }

    @Override
    public void RealizarPrestamo(LibroDTO dto) {
        Libro libro = libroPort.obtenerLibro(dto.isbn());
        if(libro == null){
            throw new LibroNoExisteException(dto.isbn());
        }
        libro.realizarPrestamo();
        libroPort.actualizarStock(libro);
    }

    @Override
    public void AnadirLibro() {

    }

    @Override
    public List<LibroDTO> obtenerLibros() {
        return null;
    }
}