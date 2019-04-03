package by.epam.javatraining.beseda.task04.model.exception;

/**
 *
 * @author Beseda
 * @version 1.0 28/03/2019
 */
public class ProjectTechnicalException extends ProjectException{

    public ProjectTechnicalException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProjectTechnicalException(Throwable cause) {
        super(cause);
    }

    public ProjectTechnicalException(String message, Throwable cause, 
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    
}
