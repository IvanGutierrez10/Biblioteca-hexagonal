package co.edu.unisbana.Biblioteca.application.exception;

public class LibroNoExisteException extends RuntimeException{

    public LibroNoExisteException(String isbn){
        super("No existe ningun libro registrado con el isbn: "+isbn);
    }
}
