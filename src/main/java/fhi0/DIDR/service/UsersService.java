package fhi0.DIDR.service;

import fhi0.DIDR.dto.UserLoginDto;
import fhi0.DIDR.exception.ResourceNotFoundException;
import fhi0.DIDR.model.Users;
import fhi0.DIDR.response.ApiResponse;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/*created by Hector
06-08-2021
*/
@Transactional
@Service
public interface UsersService {

    ApiResponse login(UserLoginDto loginDto) throws ResourceNotFoundException;

    boolean isUserAlreadyPresent(Users users);

    Users save(Users users);

//    void delete(int id);
}
