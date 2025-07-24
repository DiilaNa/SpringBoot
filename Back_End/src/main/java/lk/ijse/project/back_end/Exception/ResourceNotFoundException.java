package lk.ijse.project.back_end.Exception;
//Custom Exception
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
