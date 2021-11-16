package fhi0.DIDR.controller;

import fhi0.DIDR.dto.UserDto;
import fhi0.DIDR.exception.EmailExistsException;
import fhi0.DIDR.exception.ResourceNotFoundException;
import fhi0.DIDR.model.Users;
import fhi0.DIDR.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class UsersController {

    @Autowired
    UserRepository userRepository;


    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("users")
    List<Users> getUsers() {

        return userRepository.findAll();
    }


    //get user by Id
    @GetMapping("user/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Users user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));
        return ResponseEntity.ok().body(user);
    }

    //create user
    @PostMapping("user")
    public ResponseEntity<Object> createUser(@Valid @RequestBody Users users) throws EmailExistsException {
        Users usersEmail = userRepository.findByEmail(users.getEmail());
        if (usersEmail != null) {
            throw new EmailExistsException(String.format("User with email %s already exist", users.getEmail()));
        }
        users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
//        notificationService.sendEmail(users);
        return new ResponseEntity<>(userRepository.save(users), HttpStatus.CREATED);
    }


    @PatchMapping("user/{id}")
    public Users updateUser(@PathVariable("id") Long id, @Valid @RequestBody UserDto userDto) throws ResourceNotFoundException {
        System.out.println("Update User with ID = " + id + "...");
        Users users = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));

        final Users updatedUser = userRepository.save(users);
        System.out.println("Updated User " + updatedUser);
        return userRepository.save(updatedUser);
    }

    @PutMapping("user/{id}")
    public Users updateUsers(@PathVariable("id") Long id, @Valid @RequestBody UserDto userDto) throws ResourceNotFoundException {
        System.out.println("Update User with ID = " + id + "...");
        Users users = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));

        users.setEmail(userDto.getEmail());
        users.setUserType(userDto.getUserType());
        users.setFirstname(userDto.getFirstname());
        users.setLastname(userDto.getLastname());
        final Users updatedUser = userRepository.save(users);
        System.out.println("Updated User " + updatedUser);
        return userRepository.save(updatedUser);
    }

    //delete user
    @DeleteMapping("user/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Users user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));
        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}