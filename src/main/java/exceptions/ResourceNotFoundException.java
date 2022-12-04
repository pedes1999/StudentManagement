
package exceptions;

public class ResourceNotFoundException extends RuntimeException {
    
    public ResourceNotFoundException(String errorMsg){
        super(errorMsg);
    }
}
