package co.edu.unisbana.Biblioteca.infraestructure.out.persistence.adapter;

import co.edu.unisbana.Biblioteca.domain.entity.Libro;
import co.edu.unisbana.Biblioteca.domain.repository.LibroPort;
import co.edu.unisbana.Biblioteca.infraestructure.out.persistence.adapter.repository.LibroJPARepository;
import co.edu.unisbana.Biblioteca.infraestructure.out.persistence.orm.LibroORM;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LibroAdapterPort implements LibroPort {

    private final LibroJPARepository libroJPARepository;

    public LibroAdapterPort(LibroJPARepository libroJPARepository) {
        this.libroJPARepository = libroJPARepository;
    }

    @Override
    public List<Libro> obtenerLibros() {
        List<LibroORM> librosORM = libroJPARepository.findAll();
        return librosORM.stream()
                .map(LibroORM::converToModel)
                .collect(Collectors.toList());
    }

    @Override
    public Libro obtenerLibro(String isbn) {
        Optional<LibroORM> libroORM = libroJPARepository.findById(isbn);
        return libroORM.map(LibroORM::converToModel).orElse(null);
    }

    @Override
    public void guardarLibro(Libro libro) {
        LibroORM libroORM = new LibroORM();
        libroORM.setIsbn(libro.getIsbn());
        libroORM.setAutor(libro.getAutor());
        libroORM.setTitulo(libro.getTitulo());
        libroORM.setCantidadDisponible(libro.getCantidadDisponible());
        libroJPARepository.save(libroORM);
    }

    @Override
    public void actualizarStock(Libro libro) {
        Optional<LibroORM> libroORMOptional = libroJPARepository.findById(libro.getIsbn());
        if (libroORMOptional.isPresent()) {
            LibroORM libroORM = libroORMOptional.get();
            libroORM.setCantidadDisponible(libro.getCantidadDisponible());
            libroJPARepository.save(libroORM);
        } else {
            System.out.println("No lo encontre");
        }
    }
}