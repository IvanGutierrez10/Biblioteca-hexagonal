package co.edu.unisbana.Biblioteca.application.usecase;

import co.edu.unisbana.Biblioteca.application.exception.LibroNoExisteException;
import co.edu.unisbana.Biblioteca.application.exception.LibroYaExisteException;
import co.edu.unisbana.Biblioteca.application.port_in.IAnadirLibro;
import co.edu.unisbana.Biblioteca.application.port_in.IMostrarLibros;
import co.edu.unisbana.Biblioteca.application.port_in.IRealizarPrestamo;
import co.edu.unisbana.Biblioteca.domain.entity.Libro;
import co.edu.unisbana.Biblioteca.domain.repository.LibroPort;
import co.edu.unisbana.Biblioteca.domain.repository.PrestamoPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestamosUseCase implements IRealizarPrestamo, IAnadirLibro, IMostrarLibros {
    private final LibroPort libroPort;
    private final PrestamoPort prestamoPort;

    public PrestamosUseCase(LibroPort libroPort, PrestamoPort prestamoPort) {
        this.libroPort = libroPort;
        this.prestamoPort = prestamoPort;
    }

    @Override
    public void RealizarPrestamo(String isbn) {
        Libro libro = libroPort.obtenerLibro(isbn);
        if(libro == null){
            throw new LibroNoExisteException(isbn);
        } else {
            libro.realizarPrestamo();
            System.out.println("prestamo exitoso");
            System.out.println(libro.getCantidadDisponible());
            libroPort.actualizarStock(libro);
            System.out.println("prestamo bd");
            prestamoPort.guardarPrestamo(libro);
        }

    }

    @Override
    public void AnadirLibro(LibroDTO dto) {
        Libro libro = libroPort.obtenerLibro(dto.isbn());
        System.out.println(dto.cantidadDisponible());
        if(libro == null){
            Libro nuevolibro = new Libro(dto.titulo(), dto.autor(), dto.isbn(), dto.cantidadDisponible());
            libroPort.guardarLibro(nuevolibro);
        } else {
            throw new LibroYaExisteException(dto.isbn());
        }
    }

    @Override
    public List<Libro> mostrarLibros() {
        return libroPort.obtenerLibros();
    }

}