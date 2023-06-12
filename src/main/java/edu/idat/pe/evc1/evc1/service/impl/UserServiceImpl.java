package edu.idat.pe.evc1.evc1.service.impl;

import edu.idat.pe.evc1.evc1.dtos.request.UserRequest;
import edu.idat.pe.evc1.evc1.dtos.response.UserResponse;
import edu.idat.pe.evc1.evc1.entitty.UserEntity;
import edu.idat.pe.evc1.evc1.repository.UserRepository;
import edu.idat.pe.evc1.evc1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserRequest createUser(UserRequest userRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(userRequest.getFirstName());
        userEntity.setLastName(userRequest.getLastName());
        userEntity.setEmail(userRequest.getEmail());
        userEntity.setPassword(userRequest.getPassword());

        UserEntity savedUser = userRepository.save(userEntity);

        UserRequest savedUserRequest = new UserRequest();
        savedUserRequest.setFirstName(savedUser.getFirstName());
        savedUserRequest.setLastName(savedUser.getLastName());
        savedUserRequest.setEmail(savedUser.getEmail());
        savedUserRequest.setPassword(savedUser.getPassword());

        return savedUserRequest;
    }

    @Override
    public UserResponse loginUser(UserRequest userRequest) {
        UserEntity userEntity = userRepository.findByFirstNameAndPassword(userRequest.getFirstName(), userRequest.getPassword());

        if (userEntity != null) {
            UserResponse userResponse = new UserResponse();
            userResponse.setFirstName(userEntity.getFirstName());
            userResponse.setPassword(userEntity.getPassword());
            return userResponse;
        }

        throw new RuntimeException("Credenciales inválidas"); // Lanzar excepción en caso de credenciales inválidas
    }


}

