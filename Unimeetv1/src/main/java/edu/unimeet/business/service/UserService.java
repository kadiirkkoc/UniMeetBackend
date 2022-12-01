package edu.unimeet.business.service;

import edu.unimeet.dto.UserCreateDTO;
import edu.unimeet.dto.UserUpdateDTO;
import edu.unimeet.dto.UserViewDTO;

import java.util.List;

public interface UserService {

    UserViewDTO getUserById(int id);

    UserViewDTO createUser(UserCreateDTO userCreateDTO);

    List<UserViewDTO> getAll();

    UserViewDTO updateUser(int id, UserUpdateDTO userUpdateDTO);

    void deleteUser(int id);

}
