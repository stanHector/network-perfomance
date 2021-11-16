package fhi0.DIDR.serviceImpl;

import fhi0.DIDR.dto.UserLoginDto;
import fhi0.DIDR.exception.ResourceNotFoundException;
import fhi0.DIDR.model.Users;
import fhi0.DIDR.repository.UserRepository;
import fhi0.DIDR.response.ApiResponse;
import fhi0.DIDR.service.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import javax.validation.Valid;

/*created by Hector
06-08-2021
*/

@Transactional
@Service
public class UserServiceImpl implements UsersService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final UserRepository usersRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository usersRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usersRepository = usersRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public ApiResponse<Users> login(@Valid UserLoginDto loginDto) throws ResourceNotFoundException {
        Users user = usersRepository.findByEmail(loginDto.getEmail());

        if (user == null) {
            throw new ResourceNotFoundException(String.format("User with email %s does not exist.", loginDto.getEmail()));
        }

        if (!BCrypt.checkpw(loginDto.getPassword(), user.getPassword())) {

            throw new RuntimeException("Password Mismatch!.");
        }

        return new ApiResponse<>(200, "Login Success!", user, user.getId(), user.getUserType(), user.getEmail(), user.getFirstname(),user.getLastname(), user.getStates(),user.getPassword());
    }


    @Override
    public boolean isUserAlreadyPresent(Users user) {
        boolean isUserAlreadyExists = false;
        Users existingUser = usersRepository.getByEmail(user.getEmail());
        // If user is found in database, then then user already exists.
        if (existingUser != null) {
            isUserAlreadyExists = true;
        }
        return isUserAlreadyExists;
    }


    @Override
    public Users save(@RequestBody Users user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return usersRepository.save(user);
    }

//    @Override
//    public void delete(int id) {
//
//    }
}