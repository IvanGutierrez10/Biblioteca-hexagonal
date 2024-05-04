package co.edu.unisbana.Biblioteca.infraestructure.out.persistence.adapter;

import co.edu.unisbana.Biblioteca.domain.entity.Libro;
import co.edu.unisbana.Biblioteca.domain.repository.LibroPort;
import co.edu.unisbana.Biblioteca.infraestructure.out.persistence.adapter.repository.LibroJPARepository;
import co.edu.unisbana.Biblioteca.infraestructure.out.persistence.orm.LibroORM;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LibroAdapterPort implements LibroPort {

    private final LibroJPARepository libroJPARepository;

    public LibroAdapterPort(LibroJPARepository libroJPARepository){
        this.libroJPARepository = libroJPARepository;
    }

    @Override
    public Libro obtenerLibro(String isbn) {
        Optional<LibroORM> byId = libroJPARepository.findById(isbn);
        byId.ifPresent(LibroORM::converToModel);
        return null;
    }

    @Override
    public void actualizarStock(Libro libro) {
        LibroORM libroORM = libroJPARepository.findById(libro.getIsbn()).get();
        libroORM.setCantidadDisponible(libro.getCantidadDisponible());
        libroJPARepository.save(libroORM);
    }
}
