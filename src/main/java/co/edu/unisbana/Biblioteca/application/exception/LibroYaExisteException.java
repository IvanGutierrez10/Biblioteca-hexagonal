package co.edu.unisbana.Biblioteca.application.exception;

public class LibroYaExisteException extends RuntimeException{

    public LibroYaExisteException(String isbn){
        super("Ya existe un libro registrado con el isbn: "+isbn);
    }
}
