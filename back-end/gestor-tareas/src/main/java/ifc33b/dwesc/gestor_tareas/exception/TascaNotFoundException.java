package ifc33b.dwesc.gestor_tareas.exception;

public class TascaNotFoundException extends RuntimeException {

    public TascaNotFoundException(String message) {
        super(message);
    }

    public TascaNotFoundException(Long id) {
        super("Tasca not found! With id: " + id);
    }
}
