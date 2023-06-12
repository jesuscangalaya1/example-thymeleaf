package edu.idat.pe.evc1.evc1.service;

import edu.idat.pe.evc1.evc1.dtos.request.UserRequest;
import edu.idat.pe.evc1.evc1.dtos.response.UserResponse;

public interface UserService {

    UserRequest createUser(UserRequest userRequest);
    UserResponse loginUser(UserRequest userRequest);


}
