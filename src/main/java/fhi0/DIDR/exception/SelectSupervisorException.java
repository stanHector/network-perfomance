package fhi0.DIDR.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*created by Hector Developers
06-08-2019
*/
@ResponseStatus(value = HttpStatus.NO_CONTENT)
public class SelectSupervisorException extends Exception{

    private static final long serialVersionUID = 1L;
    public SelectSupervisorException(String message){
        super(message);
    }
}