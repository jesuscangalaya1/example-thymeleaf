package edu.idat.pe.evc1.evc1.service;

import edu.idat.pe.evc1.evc1.dtos.request.UserRequest;
import edu.idat.pe.evc1.evc1.dtos.response.UserResponse;

import java.util.List;

public interface UserService {

    UserRequest createUser(UserRequest userRequest);
    UserResponse loginUser(UserRequest userRequest);

    List<UserResponse> getAllUsers();



    }
