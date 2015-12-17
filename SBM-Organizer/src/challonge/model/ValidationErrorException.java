package challonge.model;

import java.util.List;

/**
 * @author Nicholas Hauschild
 *         Date: 5/13/13
 *         Time: 11:52 PM
 */
public class ValidationErrorException extends RuntimeException {
    private List<String> validationErrors;

    public ValidationErrorException(final List<String> validationErrors) {
        super(validationErrors.toString());
        this.validationErrors = validationErrors;
    }

    public List<String> getValidationErrors() {
        return validationErrors;
    }
}
