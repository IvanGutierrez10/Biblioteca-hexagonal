package co.edu.unisbana.Biblioteca.infraestructure.in;

import co.edu.unisbana.Biblioteca.application.port_in.IRealizarPrestamo;
import co.edu.unisbana.Biblioteca.application.usecase.LibroDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibroController {

    private final IRealizarPrestamo prestamo;

    public LibroController(IRealizarPrestamo prestamo) {
        this.prestamo = prestamo;
    }

    @PostMapping(path = "/prestamo")
    public void realizarPrestamo(@RequestBody LibroDTO libroDTO){
        prestamo.RealizarPrestamo(libroDTO);
    }
}
