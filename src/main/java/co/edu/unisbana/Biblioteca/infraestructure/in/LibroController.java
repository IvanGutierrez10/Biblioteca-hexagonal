package co.edu.unisbana.Biblioteca.infraestructure.in;

import co.edu.unisbana.Biblioteca.application.port_in.IAnadirLibro;
import co.edu.unisbana.Biblioteca.application.port_in.IMostrarLibros;
import co.edu.unisbana.Biblioteca.application.port_in.IRealizarPrestamo;
import co.edu.unisbana.Biblioteca.application.usecase.LibroDTO;
import co.edu.unisbana.Biblioteca.domain.entity.Libro;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibroController {

    private final IRealizarPrestamo prestamo;
    private final IAnadirLibro Libro;

    private final IMostrarLibros mostrar;

    public LibroController(IRealizarPrestamo prestamo, IAnadirLibro libro, IMostrarLibros mostrar) {
        this.prestamo = prestamo;
        Libro = libro;
        this.mostrar = mostrar;
    }

    @PutMapping(path = "/prestamo/{isbn}")
    public void realizarPrestamo(@PathVariable String isbn){
        prestamo.RealizarPrestamo(isbn);
    }

    @PostMapping(path = "/nuevolibro")
    public void anadirLibro(@RequestBody LibroDTO libroDTO){
        Libro.AnadirLibro(libroDTO);
    }

    @GetMapping(path = "/libros")
    public List<Libro> getLibros(){
        return mostrar.mostrarLibros();
    }
}
