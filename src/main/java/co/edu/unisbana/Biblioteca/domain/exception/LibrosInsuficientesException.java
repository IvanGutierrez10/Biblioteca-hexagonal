package co.edu.unisbana.Biblioteca.domain.exception;

public class LibrosInsuficientesException extends RuntimeException{

    public LibrosInsuficientesException(String titulo){
        super("No contamos con la disponibilidad del libro: "+titulo);
    }
}
