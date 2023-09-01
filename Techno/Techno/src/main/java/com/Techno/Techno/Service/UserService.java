package com.Techno.Techno.Service;

import com.Techno.Techno.Model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();   // for fetch all users

    User saveUser(User user);   // for add user

    User getUserById(int id);
    void deleteUserById(int id);  // delete user by id

    ResponseDto getUser(int userId);
}
