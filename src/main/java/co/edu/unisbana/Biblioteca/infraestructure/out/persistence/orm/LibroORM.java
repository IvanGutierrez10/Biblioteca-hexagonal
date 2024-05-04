package co.edu.unisbana.Biblioteca.infraestructure.out.persistence.orm;

import co.edu.unisbana.Biblioteca.domain.entity.Libro;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "libros")
public class LibroORM {
    @Id
    @Column
    private String isbn;
    @Column
    private String titulo;
    @Column
    private String autor;
    @Column
    private int cantidadDisponible;

    public Libro converToModel() {
        return new Libro(this.isbn, this.titulo, this.autor, this.cantidadDisponible);
    }
}
