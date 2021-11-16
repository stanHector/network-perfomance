package fhi0.DIDR.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*created by Hector Developers
06-08-2019
*/
@ResponseStatus(value = HttpStatus.NO_CONTENT)
public class AlreadyExistsException extends Exception{

    private static final long serialVersionUID = 1L;
    public AlreadyExistsException(String message){
        super(message);
    }
}