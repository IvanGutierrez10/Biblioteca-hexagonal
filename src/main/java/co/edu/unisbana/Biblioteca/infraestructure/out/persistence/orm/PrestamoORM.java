package co.edu.unisbana.Biblioteca.infraestructure.out.persistence.orm;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Table (name = "prestamos")
public class PrestamoORM {
    @Id
    @Column
    private UUID uuid;

    @JoinColumn
    @ManyToOne
    private LibroORM libro;

    @Column
    private LocalDate fechaPrestamo;

    @Column
    private LocalDate fechaDevolucion;

}
