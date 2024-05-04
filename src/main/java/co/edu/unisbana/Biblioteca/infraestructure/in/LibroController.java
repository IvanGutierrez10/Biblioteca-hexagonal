package co.edu.unisbana.Biblioteca.infraestructure.in;

import co.edu.unisbana.Biblioteca.application.port_in.IAnadirLibro;
import co.edu.unisbana.Biblioteca.application.port_in.IRealizarPrestamo;
import co.edu.unisbana.Biblioteca.application.usecase.LibroDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibroController {

    private final IRealizarPrestamo prestamo;
    private final IAnadirLibro Libro;

    public LibroController(IRealizarPrestamo prestamo, IAnadirLibro Libro) {
        this.prestamo = prestamo;
        this.Libro = Libro;
    }

    @PostMapping(path = "/prestamo")
    public void realizarPrestamo(@RequestBody String isbn){
        prestamo.RealizarPrestamo(isbn);
    }

    @PostMapping(path = "/nuevolibro")
    public void anadirLibro(@RequestBody LibroDTO libroDTO){
        Libro.AnadirLibro(libroDTO);
    }
}
